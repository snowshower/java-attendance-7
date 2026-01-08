package attendance;

import attendance.domain.OneAttendance;
import attendance.repository.AttendanceRepository;
import attendance.service.AttendanceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class 서비스테스트 {
    private LocalDate date1=LocalDate.of(2024,12,9);
    private LocalDate date2=LocalDate.of(2024,12,10);
    private LocalDate date3=LocalDate.of(2024,12,11);
    private LocalDate date4=LocalDate.of(2024,12,12);
    private LocalDate date5=LocalDate.of(2024,12,13);
    private LocalTime time1=LocalTime.of(9,58);
    private LocalTime time2=LocalTime.of(10,4);
    private LocalTime time3=LocalTime.of(10,7);
    private LocalTime time4=LocalTime.of(10,34);
    private LocalTime time5=LocalTime.of(11,0);

    private OneAttendance oneAttendance1=new OneAttendance("이든", date1, time1);
    private OneAttendance oneAttendance2=new OneAttendance("이든", date2, time2);
    private OneAttendance oneAttendance3=new OneAttendance("빙티", date3, time3);
    private OneAttendance oneAttendance4=new OneAttendance("부앙", date4, time4);
    private OneAttendance oneAttendance5=new OneAttendance("부앙", date5, time5);

    AttendanceRepository attendanceRepository=new AttendanceRepository();

    @Test
    void 출석확인테스트(){
        AttendanceService service=new AttendanceService(attendanceRepository);
        service.checkAttendance("이든", LocalDate.of(2024,12,9), LocalTime.of(9,58));

        System.out.println(attendanceRepository.getAttendanceSheet());
    }

    @Test
    void 출석수정테스트(){
        AttendanceService service=new AttendanceService(attendanceRepository);
        attendanceRepository.save(oneAttendance1);
        attendanceRepository.save(oneAttendance3);

        service.updateAttendance("빙티", 11, LocalTime.of(10,3));


        System.out.println(oneAttendance3.getAttInfo());
    }

    @Test
    void 출석기록확인테스트(){
        AttendanceService service=new AttendanceService(attendanceRepository);
        attendanceRepository.save(oneAttendance1);
        attendanceRepository.save(oneAttendance2);

        List<String> list=service.formatAttendanceRecord("이든");

        for (String s : list) {
            System.out.println(s);
        }
    }
}
