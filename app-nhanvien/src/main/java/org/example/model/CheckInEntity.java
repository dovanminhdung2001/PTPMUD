package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.utils.DateUtils;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckInEntity {
    private Integer id;
    private Integer userId;
    private Date checkin;
    private Date goOut1;
    private Date goIn1;
    private Date goOut2;
    private Date goIn2;
    private Date goOut3;
    private Date goIn3;
    private Date checkout;

    public Integer goOutTimes() {
        if (goOut1 == null) return 0;
        if (goOut2 == null) return 1;
        if (goOut3 == null) return 2;
        return 3;
    }

    public Integer goInTimes() {
        if (goIn1 == null) return 0;
        if (goIn2 == null) return 1;
        if (goIn3 == null) return 2;
        return 3;
    }

    public Long totalGoOutMilliSecond() {
        if (goIn1 == null)
            return 0L;
        Long sum =   goIn1.getTime() - goOut1.getTime() ;
        if (goIn2 != null)
            sum +=  goIn2.getTime() - goOut2.getTime() ;
        if (goIn3 != null)
            sum +=  goIn3.getTime() - goOut3.getTime() ;
        return sum;
    }

    public Long totalWorkMilliSecond() {
        if (checkout != null)
            return checkout.getTime() - checkin.getTime() - totalGoOutMilliSecond();
        if (goIn3 == null && goOut3 != null)
            return goOut3.getTime() - checkin.getTime() - totalGoOutMilliSecond();
        if (goIn2 == null && goOut2 != null)
            return goOut2.getTime() - checkin.getTime() - totalGoOutMilliSecond();
        if (goIn1 == null && goOut1 != null)
            return goOut1.getTime() - checkin.getTime() - totalGoOutMilliSecond();
        return 0L;
    }

    public String totalGoOutStr() {
        int total = (int) (totalGoOutMilliSecond()/1000);
        int second = total % 60;
        int minute = (total / 60) % 60;
        int hour = total / 3600;
        return  String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String totalWorkStr () {
        int total = (int) (totalWorkMilliSecond()/1000);
        int second = total % 60;
        int minute = (total / 60) % 60;
        int hour = total / 3600;
        return  String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
