import java.math.BigDecimal;

/**
 * Created by Ram on 25-Dec-19.
 */
public class Pay {
    private String cardHolderName;
    private BigDecimal cardNumber;

    public Pay(String cardHolderName, BigDecimal cardNumber) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public BigDecimal getCardNumber() {
        return cardNumber;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setCardNumber(BigDecimal cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "Pay{" +
                "cardHolderName='" + cardHolderName + '\'' +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
