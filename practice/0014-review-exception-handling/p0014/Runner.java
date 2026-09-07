package p0014;


public class Runner {
    public static void main(String[] args) {

        OrderService orderService = new OrderService();

        Order order1 = new Order(1L, "Starbucks", 3000);
        Order order2 = new Order(2L, "Adidas", 3000);

        orderService.save(order1);

        System.out.println(orderService.findByIdOrThrow(order1.getId()).getAmount());

        try {
            orderService.findByIdOrThrow(order2.getId());
        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            orderService.validate(1L, 1000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

    }
}



