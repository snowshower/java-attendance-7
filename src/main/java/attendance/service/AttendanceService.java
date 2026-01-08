package attendance.service;

import attendance.domain.Info;
import attendance.domain.OneAttendance;
import attendance.repository.AttendanceRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private final AttendanceRepository repository;

    public AttendanceService(AttendanceRepository repository){
        this.repository=repository;
    }

    //출석 확인
    public void checkAttendance(String nickname, LocalDate today, LocalTime time){
        OneAttendance oneAttendance=new OneAttendance(nickname, today, time);
        repository.save(oneAttendance);
    }

    //출석 수정
    public void updateAttendance(String nickname, int day, LocalTime time){
        repository.findByDate(nickname, day).changeTime(time);
    }

    //출석 기록 확인 출력용 포맷팅
    public List<String> formatAttendanceRecord(String nickname){

        List<String> result=new ArrayList<>();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM월 dd일 E요일 HH:mm");

        for (OneAttendance oneAttendance : checkAttendanceRecord(nickname)) {
            String dateString=oneAttendance.getAttInfo().format(formatter);
            String s=String.format("%s (%s)", dateString, oneAttendance.getInfo().getInfoName());
            result.add(s);
        }

        return result;
    }

    //출석 기록 확인
    private List<OneAttendance> checkAttendanceRecord(String nickname){
        return repository.findByNickname(nickname);
    }

    //출석지각결석 계산
    public List<Integer> calculateInfo(List<OneAttendance> oneAttendances){
        int att=0, per=0, abs=0;
        for (OneAttendance oneAttendance : oneAttendances) {

            if(oneAttendance.getInfo().equals(Info.ATTENDANCE)){
                att++;
            }
            if(oneAttendance.getInfo().equals(Info.LATENESS)){
                per++;
            }
            if(oneAttendance.getInfo().equals(Info.ABSENCE)){
                abs++;
            }
        }

        return List.of(att, per, abs);
    }
}
