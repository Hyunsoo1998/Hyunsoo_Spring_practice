package Hyunsoopractice.Hellospring;


//세터메서드를 이용해서 의존 객체를 주입받는 코드.
//이 클래스는 지정한 이메일을 갖는 Member를 찾아서 정보를 콘솔에 출력한다.


public class MemberInfoPrinter {

    private MemberDao memDao;
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memDao.selectByEmail(email);

        if(member == null) {
            System.out.println("데이터 없음 \n");

            return;
        }
        printer.print(member);
        System.out.println();
    }

    public void setMemberDao(MemberDao memberDao) {

        this.memDao = memberDao;

    }
    public void setPrinter(MemberPrinter printer) {

        this.printer = printer;

    }
}
