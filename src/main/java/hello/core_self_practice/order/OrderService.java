package hello.core_self_practice.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
