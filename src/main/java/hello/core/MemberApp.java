package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        /*AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/

        //모든 스프링의 시작 = 스프링 컨테이너 = ApplicationContext
        //파라미터 : AppConfig에 @Bean이라 적힌 메서드를 모두 호출해서 반환된 객체를 스프링 컨테이너에 등록
        //이렇게 등록된 객체 = 스프링 빈
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //스프링 컨테이너 내 존재하는 Bean을 불러와야 함 ( =appConfig.memberService())
        //첫번째 파라미터 "name" : 스프링 빈은 기본적으로 @Bean이 붙은 메소드 이름으로 등록, 두 번째 파라미터 : 반환 타입
        //@Bean(name = "name")으로 변경은 가능하지만 가능한 한 관례
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
