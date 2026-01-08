package attendance.service;

import attendance.domain.OneAttendance;
import attendance.repository.AttendanceRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class AttendanceService {
    private final AttendanceRepository repository;

    public AttendanceService(AttendanceRepository repository){
        this.repository=repository;
    }

    //출석 확인
    public void checkAttendance(String nickname, LocalDateTime today, LocalTime time){

    }

    //출석 수정



    //출석 기록 확인
//    public List<OneAttendance> checkAttendanceRecord(String nickname){
//        List<OneAttendance> list=repository.findByNickname(nickname);
//        //날짜, 시간, 출석/지각/결석 여부, 각 횟수
//    }
}
