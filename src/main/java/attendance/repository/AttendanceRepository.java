package attendance.repository;

import attendance.domain.OneAttendance;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AttendanceRepository {
    private final List<OneAttendance> attendanceSheet=new ArrayList<>();

    //출석정보 저장
    public void save(OneAttendance oneAttendance){
        attendanceSheet.add(oneAttendance);
    }

    //닉네임,날짜로 출석정보 불러오기
    public OneAttendance findByDate(String name, LocalDateTime time){
        List<OneAttendance> list=findByNickname(name);

        return list.stream()
                .filter(oneAttendance -> oneAttendance.getCrew().getAttInfo().equals(time))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 객체"));
    }

    //닉네임에 해당하는 출석정보 전부 반환
    public List<OneAttendance> findByNickname(String name){
        List<OneAttendance> list=new ArrayList<>();
        for (OneAttendance oneAttendance : attendanceSheet) {
            if(oneAttendance.getCrew().getNickname().equals(name)){
                list.add(oneAttendance);
            }
        }
        return list;
    }

    public List<OneAttendance> getAttendanceSheet(){
        return Collections.unmodifiableList(attendanceSheet);
    }
}
