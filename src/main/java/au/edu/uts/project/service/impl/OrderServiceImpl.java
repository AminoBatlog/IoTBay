package au.edu.uts.project.service.impl;

import au.edu.uts.project.dao.OrderDao;
import au.edu.uts.project.dao.daoImpl.OrderDaoImpl;
import au.edu.uts.project.domain.Order;
import au.edu.uts.project.service.OrderService;
import au.edu.uts.project.utils.DatabaseConnection;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao dao = new OrderDaoImpl(new DatabaseConnection().getConnection());

    @Override
    public int createOrder(Order order){
        int reuslt = 0;
        try {
            reuslt = dao.createOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public int updateOrder(Order order) {
        int result = 0;
        try {
            result = dao.updateOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Order> getListByEmail(String email) {
        List<Order> result = null;
        try {
            result = dao.getListByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int removeOrder(int id) {
        int result = 0;
        try {
            result = dao.removeOrder(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Order> filterList(String email, int id, String date) {
        List<Order> result = null;
        try {
            result = dao.filterList(email, id, date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
