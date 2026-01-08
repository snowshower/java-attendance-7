//package attendance.domain;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Crew {
//    private final String nickname;
//    private final LocalDate attDate;
//    private final LocalTime attTime;
//    private final LocalDateTime attInfo;
//    private List<Integer> count;
//
//    public Crew(String nickname, LocalDate attDate, LocalTime attTime){
//        this.nickname=nickname;
//        this.attDate=attDate;
//        this.attTime=attTime;
//        this.attInfo=LocalDateTime.of(attDate, attTime);
//        this.count=new ArrayList<>(List.of(0,0,0));
//    }
//
//    public String getNickname(){
//        return nickname;
//    }
//
//    public LocalDateTime getAttInfo(){
//        return attInfo;
//    }
//
//    public List<Integer> getCount(){
//        return count;
//    }
//}
