package campusconnect.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventPaymentDTO {

    private double amount;

    private String paymentMethod;

    private String transactionId;
}