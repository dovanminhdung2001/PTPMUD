package org.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckInDTO {
    private Integer userId;
    private String username;
    private String checkin;
    private String goOut1;
    private String goIn1;
    private String goOut2;
    private String goIn2;
    private String goOut3;
    private String goIn3;
    private String checkout;
    private String checkinLate;
    private String checkoutEarly;
    private Integer goOutAmount;
    private String goOutTime;
    private String workTime;
}
