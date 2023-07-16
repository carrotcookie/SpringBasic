package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.TestConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SingletonTest {

    @Autowired
    ApplicationContext ac;

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        AnnotationConfigApplicationContext ac1 = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1_1 = ac1.getBean("memberService", MemberService.class);
        MemberService memberService1_2 = ac1.getBean("memberService", MemberService.class);

//        String[] beanDefinitionNames = ac1.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            BeanDefinition beanDefinition = ac1.getBeanDefinition(beanDefinitionName);
//
//            // ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
//            // ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
//            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
//                Object bean = ac1.getBean(beanDefinitionName);
//                System.out.println("name = " + beanDefinitionName + " || object = " + bean);
//            }
//        }

        String[] beanDefinitionNames = ac1.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac1.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " || object = " + bean);
        }
    }
}
