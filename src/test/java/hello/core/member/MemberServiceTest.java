package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    public void join(){
        //given : 환경
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when : 작업
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then : 결과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
