package attendance;

import attendance.controller.AttendanceController;
import attendance.repository.AttendanceRepository;
import attendance.service.AttendanceService;
import attendance.view.InputView;
import attendance.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView=new InputView();
        OutputView outputView=new OutputView();
        AttendanceRepository attendanceRepository=new AttendanceRepository();
        AttendanceService attendanceService=new AttendanceService(attendanceRepository);
        AttendanceController attendanceController=new AttendanceController(inputView, outputView, attendanceService);

        attendanceController.run();
    }
}
