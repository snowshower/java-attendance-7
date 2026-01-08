package attendance;

import attendance.domain.Crew;
import attendance.domain.OneAttendance;
import attendance.repository.AttendanceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class 출석부테스트 {
    private LocalDateTime today=LocalDateTime.of(2024,12,10,10,0);
    private LocalDate date=LocalDate.of(2024,12,10);
    private LocalTime time1=LocalTime.of(9,58);
    private LocalTime time2=LocalTime.of(10,4);
    private LocalTime time3=LocalTime.of(10,7);
    private LocalTime time4=LocalTime.of(10,34);

    private Crew crew1=new Crew("갑", date, time1);
    private Crew crew2=new Crew("을", date, time2);
    private Crew crew3=new Crew("갑", date, time3);
    private Crew crew4=new Crew("정", date, time4);

    private OneAttendance oneAttendance1=new OneAttendance(crew1, today);
    private OneAttendance oneAttendance2=new OneAttendance(crew2, today);
    private OneAttendance oneAttendance3=new OneAttendance(crew3, today);
    private OneAttendance oneAttendance4=new OneAttendance(crew4, today);

    private AttendanceRepository attendanceRepository=new AttendanceRepository();

    @Test
    void 출석부저장테스트(){
        attendanceRepository.save(oneAttendance1);
        attendanceRepository.save(oneAttendance2);
        attendanceRepository.save(oneAttendance3);
        attendanceRepository.save(oneAttendance4);

        for (OneAttendance oneAttendance : attendanceRepository.getAttendanceSheet()) {
            System.out.println(oneAttendance.getCrew().getNickname()+oneAttendance.getCrew().getAttInfo()+oneAttendance.getInfo());
        }
        Assertions.assertThat(attendanceRepository.getAttendanceSheet().contains(oneAttendance1)).isTrue();
    }

    @Test
    void 출석정보불러오기테스트(){
        attendanceRepository.save(oneAttendance1);
        attendanceRepository.save(oneAttendance2);
        attendanceRepository.save(oneAttendance3);
        attendanceRepository.save(oneAttendance4);

        System.out.println(attendanceRepository.findByDate(crew1.getNickname(), crew1.getAttInfo()).getCrew().getNickname());

        Assertions.assertThat(oneAttendance1).isEqualTo(attendanceRepository.findByDate(crew1.getNickname(), crew1.getAttInfo()));
    }

    @Test
    void 닉네임으로출석정보전부불러오기테스트(){
        attendanceRepository.save(oneAttendance1);
        attendanceRepository.save(oneAttendance2);
        attendanceRepository.save(oneAttendance3);
        attendanceRepository.save(oneAttendance4);

        List<OneAttendance> list=attendanceRepository.findByNickname("갑");

        for (OneAttendance oneAttendance : list) {
            System.out.println(oneAttendance.getCrew().getNickname());
        }
    }
}
