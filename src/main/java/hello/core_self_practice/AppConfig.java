package hello.core_self_practice;

import hello.core_self_practice.discount.FixDiscountPolicy;
import hello.core_self_practice.member.MemberService;
import hello.core_self_practice.member.MemberServiceImpl;
import hello.core_self_practice.member.MemoryMemberRepository;
import hello.core_self_practice.order.OrderService;
import hello.core_self_practice.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
