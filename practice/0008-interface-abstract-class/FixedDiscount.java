public class FixedDiscount implements DiscountPolicy {

    private double amountOff;

    public FixedDiscount(double amountOff) {
        this.amountOff = amountOff;
    }

    @Override
    public double apply(double amount) {
        double result = amount - amountOff;
        return result < 0 ? 0 : result;
    }
}
