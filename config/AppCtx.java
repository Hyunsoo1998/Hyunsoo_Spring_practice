package config;


import Hyunsoopractice.Hellospring.MemberDao;
import Hyunsoopractice.Hellospring.MemberRegisterService;
import Hyunsoopractice.Hellospring.ChangePasswordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }
    @Bean
    public MemberRegisterService memberRegSvc() {

        return new MemberRegisterService(memberDao());
    }

    @Bean
    public ChangePasswordService changePwdSvc() {

        ChangePasswordService pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao());
        return pwdSvc;

    }
}
