package hello.core_self_practice;

import hello.core_self_practice.discount.DiscountPolicy;
import hello.core_self_practice.discount.FixDiscountPolicy;
import hello.core_self_practice.member.MemberRepository;
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
        //1번
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        //1번
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
//        return null;
    }

    @Bean
    public MemberRepository memberRepository() {
        //2번? 3번?
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
