import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<DiscountPolicy> policies = new ArrayList<>();
        policies.add(new PercentageDiscount(10));
        policies.add(new FixedDiscount(500));
        for (DiscountPolicy p : policies) {
            System.out.println(p.apply(10000));
        }

        List<PaymentMethod> methods = new ArrayList<>();
        methods.add(new CardPayment("card-001"));
        methods.add(new BankTransferPayment("acct-002"));
        for (PaymentMethod m : methods) {
            System.out.println("validate: " + m.validate()); // 공통 코드 — 부모 것 그대로 사용
            m.process(30000);                                 // 각자 다른 동작
        }
    }
}
