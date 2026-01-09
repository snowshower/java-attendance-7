package attendance.controller;

import attendance.service.AttendanceService;
import attendance.view.InputView;
import attendance.view.OutputView;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final AttendanceService attendanceService;

    public AttendanceController(InputView inputView, OutputView outputView, AttendanceService attendanceService){
        this.inputView=inputView;
        this.outputView=outputView;
        this.attendanceService=attendanceService;
    }

    public void run(){
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
}
