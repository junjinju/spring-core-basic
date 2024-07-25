package hello.core_self_practice;

import hello.core_self_practice.discount.FixDiscountPolicy;
import hello.core_self_practice.member.MemberService;
import hello.core_self_practice.member.MemberServiceImpl;
import hello.core_self_practice.member.MemoryMemberRepository;
import hello.core_self_practice.order.OrderService;
import hello.core_self_practice.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy()
        );
    }

}
