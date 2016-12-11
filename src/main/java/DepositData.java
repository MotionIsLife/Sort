import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by konstantin on 11.12.16.
 */
public class DepositData {
    public static List<DepositDto> getListDeposit() {
        List<DepositDto> depositDto = new ArrayList<DepositDto>();
        for(int i = 0; i < 20; i++) {
            DepositDto deposit = new DepositDto();
            deposit.setSum(new Random().nextInt(20)*100);
            if(i%5 == 0) {
                deposit.setAgreemtNum(i + "mc");
            }
            deposit.setCurrency(Currency.values()[new Random().nextInt(3)]);
            if(i%4==0) {
                deposit.setClosedOnly(true);
            }
            if(i%6==0) {
                deposit.setBlocked(true);
            }
            if(i%7==0) {
                deposit.setClosed(true);
            }
            depositDto.add(deposit);
        }

        return depositDto;
    }
}
