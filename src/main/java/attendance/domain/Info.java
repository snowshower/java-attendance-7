package attendance.domain;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public enum Info {
    ATTENDANCE("출석"),PERCEPTION("지각"),ABSENCE("결석");

    private final String infoName;

    Info(String infoName){
        this.infoName=infoName;
    }

    public static Info checkInfo(LocalDateTime fixTime, LocalDateTime attTime){
        if(attTime==null) return ABSENCE;
        LocalTime start=fixTime.toLocalTime();
        LocalTime end=attTime.toLocalTime();
        Duration diff=Duration.between(start, end);
        long diffMin=diff.toMinutes();
        if(diffMin>30) return ABSENCE;
        if(diffMin>5) return PERCEPTION;
        return ATTENDANCE;
    }

    public String getInfoName(){
        return infoName;
    }
}
