package attendance.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    //기능선택
    public String inputFunction(){
        return Console.readLine();
    }

    //출석확인, 출석기록확인
    public String inputNickname(){
        System.out.println("닉네임을 입력해 주세요.");
        return Console.readLine();
    }

    public String inputStartTime(){
        System.out.println("등교 시간을 입력해 주세요.");
        return Console.readLine();
    }

    //출석수정
    public String inputUpdateNickname(){
        System.out.println("출석을 수정하려는 크루의 닉네임을 입력해 주세요.");
        return Console.readLine();
    }

    public int inputUpdateDate(){
        System.out.println("수정하려는 날짜(일)를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public String inputUpdateTime(){
        System.out.println("언제로 변경하겠습니까?");
        return Console.readLine();
    }
}
