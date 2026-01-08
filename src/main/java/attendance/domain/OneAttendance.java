package attendance.domain;

import java.time.LocalDateTime;

public class OneAttendance {
    private final Crew crew;
    private final LocalDateTime time;
    private Info info;

    public OneAttendance(Crew crew, LocalDateTime time){
        this.crew=crew;
        this.time=time;
        this.info=setInfo();
    }

    private Info setInfo(){
        return Info.checkInfo(time, crew.getAttInfo());
    }

    public Crew getCrew(){
        return crew;
    }

    public LocalDateTime getTime(){
        return time;
    }

    public Info getInfo(){
        return info;
    }
}
