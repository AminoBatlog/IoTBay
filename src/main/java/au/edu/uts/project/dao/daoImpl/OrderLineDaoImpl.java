package au.edu.uts.project.dao.daoImpl;

import au.edu.uts.project.dao.OrderLineDao;
import au.edu.uts.project.domain.OrderLine;
import au.edu.uts.project.domain.OrderLineVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderLineDaoImpl implements OrderLineDao {

    private Connection connection;
    private PreparedStatement pst;

    public OrderLineDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<OrderLineVO> getOrderLineById(int id) throws SQLException {
        String sql = "SELECT order_id, t1.dev_id, order_quantity, dev_name, (order_quantity * dev_price) AS total_price FROM orderline t1 INNER JOIN iot_dev t2 ON t1.dev_id = t2.dev_id WHERE order_id = ?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setInt(1, id);
        ResultSet result = this.pst.executeQuery();
        List<OrderLineVO> list = new ArrayList<>();
        while(result.next()) {
            OrderLineVO orderLine = new OrderLineVO();
            orderLine.setOrderId(result.getInt(1));
            orderLine.setDevId(result.getInt(2));
            orderLine.setQuantity(result.getInt(3));
            orderLine.setDevName(result.getString(4));
            orderLine.setTotalPrice(result.getDouble(5));
            list.add(orderLine);
        }
        this.pst.close();
        return list;
    }

    @Override
    public int removeOrderLine(int orderId, int devId) throws SQLException {
        String sql = "DELETE FROM orderline WHERE order_id=? AND dev_id=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setInt(1, orderId);
        this.pst.setInt(2, devId);
        int result = this.pst.executeUpdate();
        this.pst.close();
        return result;
    }

    @Override
    public int createOrderLine(OrderLine orderLine) throws SQLException {
        // check if the stock is allowed
        int currentQuantity = currentStock(orderLine.getDevId());
        if(orderLine.getQuantity() <= currentQuantity){
            String sql = "INSERT INTO orderline (order_id, dev_id, order_quantity) VALUES (?, ?, ?)";
            this.pst = this.connection.prepareStatement(sql);
            this.pst.setInt(1, orderLine.getOrderId());
            this.pst.setInt(2, orderLine.getDevId());
            this.pst.setInt(3, orderLine.getQuantity());
            int result = this.pst.executeUpdate();
            // update the stock quantity
            this.pst.close();
            changeStock(orderLine.getDevId(), currentQuantity - orderLine.getQuantity());
            return result;
        }
        return 0;
    }

    @Override
    public int currentStock(int devid) throws SQLException {
        String sql = "SELECT quantity FROM iot_dev WHERE dev_id=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setInt(1, devid);
        ResultSet result = this.pst.executeQuery();
        int stock = 0;
        while(result.next()) {
            stock = result.getInt("quantity");
        }
        this.pst.close();
        return stock;
    }

    @Override
    public int changeStock(int devid, int quantity) throws SQLException {
        String sql = "UPDATE iot_dev SET quantity=? WHERE dev_id=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setInt(1, quantity);
        this.pst.setInt(2, devid);
        int result = this.pst.executeUpdate();
        return result;
    }
}
