package hello.core_self_practice.order;

import hello.core_self_practice.discount.DiscountPolicy;
import hello.core_self_practice.discount.FixDiscountPolicy;
import hello.core_self_practice.member.Member;
import hello.core_self_practice.member.MemberRepository;
import hello.core_self_practice.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
