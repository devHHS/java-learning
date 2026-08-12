public class Money {


    private String currency;
    private int amountInCents;

    public Money() {}

    public Money(String currency, int amountInCents) {
        if ( amountInCents < 0 ) {
            throw new IllegalArgumentException();
        }
        this.currency = currency;
        this.amountInCents = amountInCents;
    }

    public Money add(Money other) {
        if (currency.equals(other.currency)) {
            return new Money(currency, amountInCents + other.amountInCents);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmountInCents() {
        return amountInCents;
    }
    public static void main(String[] args) {

        Money money1 = new Money("USD", 1);
        Money money2 = new Money("EUR", 3);
        Money money3 = new Money("EUR", 4);
        //Money money4 = new Money("EUR", -10);

        System.out.print(money2.add(money3).getAmountInCents());
        //System.out.print(money2.add(money4).getAmountInCents());
        //System.out.print((money2.add(money1)));

    }

}
