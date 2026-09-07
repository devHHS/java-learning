package p0014;

import java.util.HashMap;
import java.util.Map;

public class OrderService {
    private final Map<Long, Order> store;

    public OrderService() {
        store = new HashMap<>();
    }

    public Order save(Order order){
        store.put(order.getId(), order);
        return order;
    }

    public Order findByIdOrThrow(Long id) {
        if (!store.containsKey(id)) {
            throw new OrderNotFoundException(String.format("Order with id %d does not exist", id));
        }
        return store.get(id);
    }

    public void validate(Long id, double paymentAmount) throws InsufficientBalanceException {
        if (findByIdOrThrow(id).getAmount() > paymentAmount) {
            throw new InsufficientBalanceException(String.format("Insufficient balance for order with id %d", id));
        }
    }

}
