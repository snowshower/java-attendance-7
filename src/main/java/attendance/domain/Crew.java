package attendance.domain;

import java.time.LocalDateTime;

public class Crew {
    private final String nickname;
    private final LocalDateTime time;

    public Crew(String nickname, LocalDateTime time){
        this.nickname=nickname;
        this.time=time;
    }

    public String getNickname(){
        return nickname;
    }

    public LocalDateTime getTime(){
        return time;
    }
}
