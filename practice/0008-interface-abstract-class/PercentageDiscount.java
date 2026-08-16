public class PercentageDiscount implements DiscountPolicy {

    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double apply(double amount) {
        return amount - (amount * percent / 100);
    }
}
