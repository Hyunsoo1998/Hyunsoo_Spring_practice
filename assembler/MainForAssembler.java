package assembler;


import java.io.*;
import assembler.Assembler;
import Hyunsoopractice.Hellospring.ChangePasswordService;
import Hyunsoopractice.Hellospring.DuplicateMemberException;
import Hyunsoopractice.Hellospring.MemberNotFoundException;
import Hyunsoopractice.Hellospring.MemberRegisterService;
import Hyunsoopractice.Hellospring.RegisterRequest;
import Hyunsoopractice.Hellospring.WrongPasswordException;

public class MainForAssembler {


    //processNewCommand()메서드와 processChangeCommand()메서드에 전달되는 값은 문자열 배열이다.

    private static Assembler assembler = new Assembler();

    private static void processNewCommand(String[]arg) {
        if(arg.length != 5 ) {
            printHelp();
            return;
        }
        MemberRegisterService regSvc = assembler.getMemberRegisterService();
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if(!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호와 확인이 일치하지 않습니다. \n");
            return;
        }

        try {
            regSvc.regist(req);
            System.out.println("등록했습니다. \n");
        }catch(DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다. \n");
        }
    }

    private static void processChangeCommand(String[]arg) {
        if(arg.length != 4 ) {
            printHelp();
            return;
        }
        ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
        try {
            changePwdSvc.changePassword(arg[1] , arg[2] , arg[3]);
            System.out.println("암호를 변경했습니다. \n");
        }
        catch(MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다. \n");
        }
        catch(WrongPasswordException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다. \n");
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("명령어를 입력하세요");
            String command = br.readLine();
            if(command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }
            if(command.startsWith("new")) {
                processNewCommand(command.split(""));
                continue;
            }else if(command.startsWith("change")) {
                processChangeCommand(command.split(" "));
                continue;
            }
            printHelp();
        }

    }
}
