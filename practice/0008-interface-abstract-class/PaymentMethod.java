public abstract class PaymentMethod {

    protected String accountId;

    public PaymentMethod(String accountId) {
        this.accountId = accountId;
    }

    public boolean validate() {
        return accountId != null && !accountId.isBlank();
    }

    public abstract void process(double amount);
}
