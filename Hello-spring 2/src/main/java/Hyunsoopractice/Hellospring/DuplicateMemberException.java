package Hyunsoopractice.Hellospring;


//회원 가입 처리 관련 클래스
//회원 가입 처리에 필요한 클래스는 DuplicateMemberException , RegisterRequest, MemberRegisterService이다.
public class DuplicateMemberException extends RuntimeException{


    public DuplicateMemberException(String message) {
        super(message);
    }

}
