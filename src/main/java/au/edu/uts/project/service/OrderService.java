package au.edu.uts.project.service;

import au.edu.uts.project.domain.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    long createOrder(Order order);

    int updateOrder(Order order);

    List<Order> getListByEmail(String email);

    int removeOrder(int id);

    List<Order> filterList(String email, int id, String date);

    int updateStatusById(String status, int id);

}
