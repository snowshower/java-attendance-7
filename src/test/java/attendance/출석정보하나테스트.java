package attendance;

import attendance.domain.Info;
import attendance.domain.OneAttendance;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class 출석정보하나테스트 {
    private String nickname="이든";
    private LocalDate today=LocalDate.of(2024,12,10);
    private LocalTime time=LocalTime.of(10,4);

    @Test
    void 출석정보하나테스트(){
        OneAttendance oneAttendance=new OneAttendance(nickname, today, time);

        System.out.println(oneAttendance.getAttInfo());
        System.out.println(oneAttendance.getInfo());

        Assertions.assertThat(Info.ATTENDANCE).isEqualTo(oneAttendance.getInfo());
    }
}
