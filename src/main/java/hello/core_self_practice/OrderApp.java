package hello.core_self_practice;

import hello.core_self_practice.member.Grade;
import hello.core_self_practice.member.Member;
import hello.core_self_practice.member.MemberService;
import hello.core_self_practice.order.Order;
import hello.core_self_practice.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }

}
