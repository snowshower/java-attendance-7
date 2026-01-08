package attendance;

import attendance.domain.OneAttendance;
import attendance.repository.AttendanceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class 출석부테스트 {
    private LocalDate date1=LocalDate.of(2024,12,9);
    private LocalDate date2=LocalDate.of(2024,12,10);
    private LocalDate date3=LocalDate.of(2024,12,11);
    private LocalDate date4=LocalDate.of(2024,12,12);
    private LocalTime time1=LocalTime.of(9,58);
    private LocalTime time2=LocalTime.of(10,4);
    private LocalTime time3=LocalTime.of(10,7);
    private LocalTime time4=LocalTime.of(10,34);

    private OneAttendance oneAttendance1=new OneAttendance("이든", date1, time1);
    private OneAttendance oneAttendance2=new OneAttendance("이든", date2, time2);
    private OneAttendance oneAttendance3=new OneAttendance("빙티", date3, time3);
    private OneAttendance oneAttendance4=new OneAttendance("밤티", date4, time4);


    private AttendanceRepository attendanceRepository=new AttendanceRepository();

    @Test
    void 출석부저장테스트(){
        attendanceRepository.save(oneAttendance1);
        attendanceRepository.save(oneAttendance2);
        attendanceRepository.save(oneAttendance3);
        attendanceRepository.save(oneAttendance4);

    }

    @Test
    void 출석정보불러오기테스트(){
        attendanceRepository.save(oneAttendance1);
        attendanceRepository.save(oneAttendance2);
        attendanceRepository.save(oneAttendance3);
        attendanceRepository.save(oneAttendance4);

        System.out.println(attendanceRepository.findByDate("이든", 10).getAttInfo());
    }

    @Test
    void 닉네임으로출석정보전부불러오기테스트(){
        attendanceRepository.save(oneAttendance1);
        attendanceRepository.save(oneAttendance2);
        attendanceRepository.save(oneAttendance3);
        attendanceRepository.save(oneAttendance4);

        List<OneAttendance> list=attendanceRepository.findByNickname("이든");
        for (OneAttendance oneAttendance : list) {
            System.out.println(oneAttendance.getAttInfo());
        }
    }
}
