package hello.core_self_practice;

import hello.core_self_practice.discount.FixDiscountPolicy;
import hello.core_self_practice.member.MemberService;
import hello.core_self_practice.member.MemberServiceImpl;
import hello.core_self_practice.member.MemoryMemberRepository;
import hello.core_self_practice.order.OrderService;
import hello.core_self_practice.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
