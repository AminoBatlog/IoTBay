package au.edu.uts.project.dao;

import au.edu.uts.project.domain.OrderLine;

import java.sql.SQLException;
import java.util.List;

public interface OrderLineDao {

    List<OrderLine> getOrderLineById(int id) throws SQLException;

    int removeOrderLine(int orderId, int devId) throws SQLException;

    int createOrderLine(OrderLine orderLine) throws SQLException;

    int currentStock(int devid) throws SQLException;

    int changeStock(int devid, int quantity) throws SQLException;

}
