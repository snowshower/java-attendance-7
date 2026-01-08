package attendance;

import attendance.domain.Crew;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class 크루테스트 {

    @Test
    void 크루생성테스트(){
        LocalDate date=LocalDate.of(2024,12,10);
        LocalDateTime time=date.atTime(10,10);
        Crew crew1=new Crew("이든", time);
        Crew crew2=new Crew("이든", LocalDateTime.of(2024,12,10,10,10));
        Assertions.assertThat(crew1.getTime()).isEqualTo(crew2.getTime());
    }
}
