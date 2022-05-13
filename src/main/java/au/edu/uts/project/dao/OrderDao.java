package au.edu.uts.project.dao;

import au.edu.uts.project.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    int createOrder(Order order) throws SQLException;

    int updateOrder(Order order) throws SQLException;

    List<Order> getListByEmail(String email) throws SQLException;

    int removeOrder(int id) throws SQLException;

    List<Order> filterList(String email, int id, String date) throws SQLException;
}
