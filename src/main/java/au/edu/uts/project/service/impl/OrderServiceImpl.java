package au.edu.uts.project.service.impl;

import au.edu.uts.project.dao.OrderDao;
import au.edu.uts.project.dao.daoImpl.OrderDaoImpl;
import au.edu.uts.project.domain.Order;
import au.edu.uts.project.service.OrderService;
import au.edu.uts.project.utils.DatabaseConnection;
import au.edu.uts.project.utils.OrderDaoSingleton;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {


    @Override
    public long createOrder(Order order){
        OrderDao dao = OrderDaoSingleton.getInstance();
        long reuslt = 0;
        try {
            reuslt = dao.createOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reuslt;
    }

    @Override
    public int updateOrder(Order order) {
        OrderDao dao = OrderDaoSingleton.getInstance();
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
        OrderDao dao = OrderDaoSingleton.getInstance();
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
        OrderDao dao = OrderDaoSingleton.getInstance();
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
        OrderDao dao = OrderDaoSingleton.getInstance();
        List<Order> result = null;
        try {
            result = dao.filterList(email, id, date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateStatusById(String status, int id) {
        OrderDao dao = OrderDaoSingleton.getInstance();
        int result = 0;
        try {
            result = dao.updateStatusById(id, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
