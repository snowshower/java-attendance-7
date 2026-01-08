package attendance;

import attendance.domain.Crew;
import attendance.domain.OneAttendance;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class 출석정보하나테스트 {
    private LocalDate date=LocalDate.of(2024,12,10);
    private LocalTime time=LocalTime.of(10,4);
    private Crew crew=new Crew("이든", date, time);
    private LocalDateTime today=LocalDateTime.of(2024,12,10,10,0);

    @Test
    void 출석정보하나테스트(){
        OneAttendance oneAttendance=new OneAttendance(crew, today);

        System.out.println("이름: "+oneAttendance.getCrew().getNickname());
        System.out.println("출석시간: "+oneAttendance.getCrew().getAttInfo());
        System.out.println("출석여부: "+oneAttendance.getInfo().getInfoName());
    }
}
