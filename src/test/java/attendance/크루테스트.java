package attendance;

import attendance.domain.Crew;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class 크루테스트 {

    @Test
    void 크루생성테스트(){
        LocalDate date=LocalDate.of(2024,12,10);
        LocalTime time=LocalTime.of(10,4);

        Crew crew=new Crew("이든", date, time);

        Assertions.assertThat(LocalDateTime.of(2024,12,10,10,4)).isEqualTo(crew.getAttInfo());
    }
}
