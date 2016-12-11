/**
 * Created by konstantin on 11.12.16.
 */
public class DepositDto {
    private int sum;
    private boolean isClosed;
    private boolean isBlocked;
    private boolean isClosedOnly;
    private Currency currency;
    private String agreemtNum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public boolean isClosedOnly() {
        return isClosedOnly;
    }

    public void setClosedOnly(boolean closedOnly) {
        isClosedOnly = closedOnly;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getAgreemtNum() {
        return agreemtNum;
    }

    public void setAgreemtNum(String agreemtNum) {
        this.agreemtNum = agreemtNum;
    }
}
