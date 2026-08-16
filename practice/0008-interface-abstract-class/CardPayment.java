public class CardPayment extends PaymentMethod /* TODO: PaymentMethod를 extends해라 */ {

    public CardPayment(String accountId) {
        // TODO: super(accountId)를 호출해라.
        super(accountId);
    }

    // TODO: process(double amount)를 override해라.
    //       내용: "카드 결제: " + amount + "원 (계좌 " + accountId + ")" 형태로 출력.
    @Override
    public void process(double amount) {
        System.out.println("카드 결제: " + amount + "원 (계좌 " + accountId + ")");
    }
}
