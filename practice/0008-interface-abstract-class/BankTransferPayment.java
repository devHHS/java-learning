public class BankTransferPayment extends PaymentMethod/* TODO: PaymentMethod를 extends해라 */ {

    public BankTransferPayment(String accountId) {
        // TODO: super(accountId)를 호출해라.
        super(accountId);
    }

    // TODO: process(double amount)를 override해라.
    //       내용: "계좌이체: " + amount + "원 (계좌 " + accountId + ")" 형태로 출력.
    @Override
    public void process(double amount) {
        System.out.println("계좌이체: " + amount + "원 (계좌 " + accountId + ")");
    }
}
