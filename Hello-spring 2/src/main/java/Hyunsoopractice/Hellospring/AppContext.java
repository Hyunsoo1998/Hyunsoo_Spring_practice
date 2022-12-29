package Hyunsoopractice.Hellospring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configurartion어노테이션은 해당클래스를 스프링 설정 클래스로 지정한다.
@Configuration
public class AppContext {


    //@Bean 애노테이션을 메서드에 붙이면 해당메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록한다.
    //@Bean 애노테이션을 붙인 메서드의 이름은 빈 객체를 구분할 때 사용한다.

    //@Bean 애노테이션을 붙인 메서드는 객체를 생성하고 알맞게 초기화해야 한다.
    @Bean
    public Greeter greeter() {
        Greeter g = new Greeter();
        g.setFormat("%s, 안녕하세요!");

        return g;
    }
}
