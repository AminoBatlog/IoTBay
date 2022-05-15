package au.edu.uts.project.service;

import au.edu.uts.project.domain.OrderLine;
import au.edu.uts.project.domain.OrderLineVO;

import java.util.List;

public interface OrderLineService {

    List<OrderLineVO> getOrderLineById(int id);

    int removeOrderLine(int orderId, int devId);

    int createOrderLine(OrderLine orderLine);

}
