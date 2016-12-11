import java.util.List;

/**
 * Created by konstantin on 11.12.16.
 */
public class FinanceSort {
    public static void main(String[] args) {
        List<DepositDto> sortedDepositDto = DepositUtils.sortDeposits(DepositData.getListDeposit());
    }
}
