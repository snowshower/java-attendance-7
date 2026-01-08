package attendance.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OneAttendance {
    private final String nickname;
    private final LocalDate today;
    private final LocalTime time;
    private LocalDateTime attInfo;
    private Info info;

    public OneAttendance(String nickname, LocalDate today, LocalTime time){
        this.nickname=nickname;
        this.today=today;
        this.time=time;
        this.attInfo=LocalDateTime.of(today, time);
        this.info=Info.checkInfo(LocalDateTime.of(today, TimeByDay.from(today.getDayOfWeek().getValue()).getTime()), attInfo);
    }

    public String getNickname(){
        return nickname;
    }

    public LocalDateTime getAttInfo(){
        return attInfo;
    }

    public Info getInfo(){
        return info;
    }
}
