package au.edu.uts.project.dao.daoImpl;

import au.edu.uts.project.dao.OrderDao;
import au.edu.uts.project.domain.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    private Connection connection;
    private PreparedStatement pst;

    public OrderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * add order without orderline
     * @param order
     * @return
     */
    @Override
    public long createOrder(Order order) throws SQLException {
        String sql = "INSERT INTO ORDERS (cust_email, order_status, delivery_date, delivery_time) VALUES (?, ?, ?, ?)";
        this.pst = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        this.pst.setString(1, order.getEmail());
        this.pst.setString(2, order.getStatus());
        this.pst.setString(3, order.getDeliveryDate());
        this.pst.setString(4, order.getDeliveryTime());
        this.pst.execute();
        ResultSet result = this.pst.getGeneratedKeys();
        long id = 0;
        if(result.next()){
            id = result.getLong(1);
        }
        this.pst.close();
        return id;

    }

    /**
     * update order
     * @param order
     * @return
     */
    @Override
    public int updateOrder(Order order) throws SQLException {
        String sql = "UPDATE Orders SET cust_email=?, order_status=?, delivery_date=?, delivery_time=? WHERE order_id=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, order.getEmail());
        this.pst.setString(2, order.getStatus());
        this.pst.setString(3, order.getDeliveryDate());
        this.pst.setString(4, order.getDeliveryTime());
        this.pst.setInt(5, order.getOrderId());
        int result = this.pst.executeUpdate();
        this.pst.close();
        return result;
    }

    /**
     * get order by user email
     * @param email
     * @return
     */
    @Override
    public List<Order> getListByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Orders WHERE cust_email=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, email);
        ResultSet result = this.pst.executeQuery();
        List<Order> list = new ArrayList<>();
        while(result.next()){
            Order order = new Order();
            order.setOrderId(Integer.parseInt(result.getString("order_id")));
            order.setEmail(result.getString("cust_email"));
            order.setStatus(result.getString("order_status"));
            order.setDeliveryDate(result.getString("delivery_date"));
            order.setDeliveryTime(result.getString("delivery_time"));
            list.add(order);
        }
        this.pst.close();
        return list;
    }

    /**
     * remove order by id
     * @param id
     * @return
     */
    @Override
    public int removeOrder(int id) throws SQLException {
        String sql = "DELETE FROM Orders WHERE order_id=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setInt(1, id);
        int result = this.pst.executeUpdate();
        this.pst.close();
        return result;
    }

    @Override
    public List<Order> filterList(String email, int id, String date) throws SQLException {
        String sql;
        if(id == 0){
            sql = "SELECT * FROM Orders WHERE CAST(delivery_date AS VARCHAR(100)) LIKE ? AND cust_email=?";
            this.pst = this.connection.prepareStatement(sql);
            this.pst.setString(1, "%" + date + "%");
            this.pst.setString(2, email);
        } else {
            sql = "SELECT * FROM Orders WHERE order_id=? AND cust_email=?";
            this.pst = this.connection.prepareStatement(sql);
            this.pst.setInt(1, id);
            this.pst.setString(2, email);
        }
        ResultSet result = this.pst.executeQuery();
        List<Order> list = new ArrayList<>();
        while(result.next()){
            Order order = new Order();
            order.setOrderId(Integer.parseInt(result.getString("order_id")));
            order.setEmail(result.getString("cust_email"));
            order.setStatus(result.getString("order_status"));
            order.setDeliveryDate(result.getString("delivery_date"));
            order.setDeliveryTime(result.getString("delivery_time"));
            list.add(order);
        }
        this.pst.close();
        return list;
    }

    @Override
    public int updateStatusById(int orderId, String status) throws SQLException {
        String sql = "UPDATE orders SET order_status=? WHERE order_id=?";
        this.pst = this.connection.prepareStatement(sql);
        this.pst.setString(1, status);
        this.pst.setInt(2, orderId);
        int result = this.pst.executeUpdate();
        return result;
    }
}
