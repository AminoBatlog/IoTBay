package au.edu.uts.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int orderId;
    private String email;
    private String status;
    private String deliveryDate;
    private String deliveryTime;
}
