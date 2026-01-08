package attendance.domain;

import java.time.LocalTime;
import java.util.Arrays;

public enum TimeByDay {
    MON(1,"월", LocalTime.of(13,0)),
    TUE(2,"화", LocalTime.of(10,0)),
    WED(3,"수", LocalTime.of(10,0)),
    THU(4,"목", LocalTime.of(10,0)),
    FRI(5,"금", LocalTime.of(10,0)),
    SAT(6,"토", null),
    SUN(7,"일", null);

    private final int idx;
    private final String name;
    private final LocalTime time;

    TimeByDay(int idx, String name, LocalTime time){
        this.idx=idx;
        this.name=name;
        this.time=time;
    }

    public static TimeByDay from(int idx){
        return Arrays.stream(values())
                .filter(timeByDay -> timeByDay.idx==idx)
                .findFirst()
                .orElseThrow();
    }

    public String getName(){
        return name;
    }

    public LocalTime getTime(){
        return time;
    }
}
