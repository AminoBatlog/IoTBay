package au.edu.uts.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineVO {
    private int orderId;
    private int devId;
    private int quantity;
    private String devName;
    private double totalPrice;
}
