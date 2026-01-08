package attendance.repository;

import attendance.domain.OneAttendance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AttendanceRepository {
    private final Map<String, List<OneAttendance>> attendanceSheet=new HashMap<>();

    //출석정보 저장
    public void save(OneAttendance oneAttendance){
        attendanceSheet.computeIfAbsent(oneAttendance.getNickname(), k->new ArrayList<>()).add(oneAttendance);
    }

    //닉네임,날짜로 출석정보 불러오기
    public OneAttendance findByDate(String name, int day){
        List<OneAttendance> list=findByNickname(name);

        return list.stream()
                .filter(oneAttendance -> oneAttendance.getAttInfo().getDayOfMonth()==day)
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 객체"));
    }

    //닉네임에 해당하는 출석정보 전부 반환
    public List<OneAttendance> findByNickname(String name){
        if(!attendanceSheet.containsKey(name)){
            throw new IllegalArgumentException("존재하지 않는 객체");
        }
        return attendanceSheet.get(name);
    }

    public Map<String, List<OneAttendance>> getAttendanceSheet(){
        return Collections.unmodifiableMap(attendanceSheet);
    }
}
