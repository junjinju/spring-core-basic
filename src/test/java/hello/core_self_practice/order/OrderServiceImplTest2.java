package hello.core_self_practice.order;

import hello.core_self_practice.discount.RateDiscountPolicy;
import hello.core_self_practice.member.Grade;
import hello.core_self_practice.member.Member;
import hello.core_self_practice.member.MemberServiceImpl;
import hello.core_self_practice.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest2 {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();

        MemberServiceImpl memberService = new MemberServiceImpl(memberRepository);
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        memberService.join(member);
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}