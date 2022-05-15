package au.edu.uts.project.service.impl;

import au.edu.uts.project.dao.OrderLineDao;
import au.edu.uts.project.domain.OrderLine;
import au.edu.uts.project.domain.OrderLineVO;
import au.edu.uts.project.service.OrderLineService;
import au.edu.uts.project.utils.OrderLineSingleton;

import java.sql.SQLException;
import java.util.List;

public class OrderLineServiceImpl implements OrderLineService {
    @Override
    public List<OrderLineVO> getOrderLineById(int id) {
        OrderLineDao dao = OrderLineSingleton.getInstance();
        List<OrderLineVO> list = null;
        try {
            list = dao.getOrderLineById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int removeOrderLine(int orderId, int devId) {
        OrderLineDao dao = OrderLineSingleton.getInstance();
        int result = 0;
        try {
            result = dao.removeOrderLine(orderId, devId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int createOrderLine(OrderLine orderLine) {
        OrderLineDao dao = OrderLineSingleton.getInstance();
        int result = 0;
        try {
            result = dao.createOrderLine(orderLine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
