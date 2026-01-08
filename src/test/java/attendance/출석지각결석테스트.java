package attendance;

import attendance.domain.Info;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class 출석지각결석테스트 {
    private final LocalDateTime fixTime=LocalDateTime.of(2024,12,10,10,0);
    private final LocalDateTime attTime=LocalDateTime.of(2024,12,10,9,58);
    private final LocalDateTime perTime=LocalDateTime.of(2024,12,10,10,6);
    private final LocalDateTime absTime=LocalDateTime.of(2024,12,10,10,34);

    @Test
    void 출석인지확인테스트(){
        Assertions.assertThat(Info.ATTENDANCE).isEqualTo(Info.checkInfo(fixTime, attTime));
    }

    @Test
    void 지각인지확인테스트(){
        Assertions.assertThat(Info.LATENESS).isEqualTo(Info.checkInfo(fixTime, perTime));
    }

    @Test
    void 결석인지확인테스트(){
        Assertions.assertThat(Info.ABSENCE).isEqualTo(Info.checkInfo(fixTime, absTime));
    }
}
