package attendance.controller;

import attendance.service.AttendanceService;
import attendance.util.FileReader;
import attendance.view.InputView;
import attendance.view.OutputView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AttendanceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final AttendanceService attendanceService;
    private final FileReader fileReader=new FileReader();

    public AttendanceController(InputView inputView, OutputView outputView, AttendanceService attendanceService){
        this.inputView=inputView;
        this.outputView=outputView;
        this.attendanceService=attendanceService;
    }

    public void run(){
        dataLoad();
        while(true){
            outputView.outputFunction();
            String s=inputView.inputFunction();
            LocalDate today=LocalDate.of(2024,12,13);

            //출석확인
            if(s.equals("1")){
                String nickname=inputView.inputNickname();
                LocalTime time=LocalTime.parse(inputView.inputStartTime());
                attendanceService.checkAttendance(nickname, today, time);
            }

            //출석수정
            if(s.equals("2")){
                String nickname=inputView.inputNickname();
                int date= inputView.inputUpdateDate();
                LocalTime time=LocalTime.parse(inputView.inputUpdateTime());
                attendanceService.updateAttendance(nickname, date, time);
            }

            //출석기록확인
            if(s.equals("3")){
                String nickname=inputView.inputNickname();
                outputView.outputRecord(attendanceService.formatAttendanceRecord(nickname));
            }

            //종료
            if(s.equals("Q")){
                break;
            }
        }
    }

    private void dataLoad(){
        List<String> data=fileReader.readFile("src/main/resources/attendances.csv");

        for (String s : data) {
            if(s.startsWith("nickname")) continue;

            String[] parts=s.split(",");
            String nickname=parts[0];
            String[] datetime=parts[1].split(" ");
            LocalDate date=LocalDate.parse(datetime[0]);
            LocalTime time=LocalTime.parse(datetime[1]);

            attendanceService.checkAttendance(nickname, date, time);
        }
    }
}
