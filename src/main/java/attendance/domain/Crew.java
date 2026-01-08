package attendance.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Crew {
    private final String nickname;
    private final LocalDate attDate;
    private final LocalTime attTime;
    private final LocalDateTime attInfo;

    public Crew(String nickname, LocalDate attDate, LocalTime attTime){
        this.nickname=nickname;
        this.attDate=attDate;
        this.attTime=attTime;
        this.attInfo=LocalDateTime.of(attDate, attTime);
    }

    public String getNickname(){
        return nickname;
    }

    public LocalDateTime getAttInfo(){
        return attInfo;
    }
}
