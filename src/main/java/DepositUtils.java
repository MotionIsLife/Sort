import java.util.ArrayList;
import java.util.List;

/**
 * Created by konstantin on 11.12.16.
 */
public class DepositUtils {
    public static List<DepositDto> getOpenDeposits(List<DepositDto> deposits, boolean isClosed) {
        List<DepositDto> foundDeposits = new ArrayList<DepositDto>();
        for(DepositDto deposit: deposits) {
            if(deposit.isClosed() == !isClosed) {
                foundDeposits.add(deposit);
            }
        }
        return foundDeposits;
    }

    public static List<DepositDto> getClosedOnlyDeposits(List<DepositDto> deposits) {
        List<DepositDto> foundDeposists = new ArrayList<DepositDto>();
        for(DepositDto deposit: deposits) {
            if(deposit.isClosedOnly() && !deposit.isClosed()) {
                foundDeposists.add(deposit);
            }
        }
        return foundDeposists;
    }

    public static List<DepositDto> getBlockedDeposits(List<DepositDto> deposits) {
        List<DepositDto> foundDeposits = new ArrayList<DepositDto>();
        for(DepositDto deposit: deposits) {
            if(deposit.isBlocked() && !deposit.isClosedOnly()) {
                foundDeposits.add(deposit);
            }
        }
        return foundDeposits;
    }

    public static List<DepositDto> getAnotherDeposits(List<DepositDto> deposits) {
        List<DepositDto> foundDeposists = new ArrayList<DepositDto>();
        for(DepositDto deposit: deposits) {
            if(!deposit.isClosedOnly() && !deposit.isBlocked()) {
                foundDeposists.add(deposit);
            }
        }
        return foundDeposists;
    }

    //===========================Sort by p3

    public static List<DepositDto> getCurrencyDepositsNotMc(List<DepositDto> deposits, Currency currency) {
        List<DepositDto> foundDeposit = new ArrayList<DepositDto>();
        for(DepositDto deposit: deposits) {
            if(deposit.getCurrency().equals(currency) && deposit.getAgreemtNum() == null) {
                foundDeposit.add(deposit);
            }
        }
        return foundDeposit;
    }

    public static List<DepositDto> getMcDeposits(List<DepositDto> deposits) {
        List<DepositDto> foundDeposits = new ArrayList<DepositDto>();
        for(DepositDto deposit: deposits) {
            if(deposit.getAgreemtNum() != null) {
                foundDeposits.add(deposit);
            }
        }
        return foundDeposits;
    }

    public static List<DepositDto> getGroupDeposits(List<DepositDto> deposits) {
        List<DepositDto> rubDeposits = DepositUtils.getCurrencyDepositsNotMc(deposits, Currency.RUB);
        List<DepositDto> mcDeposits = DepositUtils.getMcDeposits(deposits);
        List<DepositDto> eurDeposits = DepositUtils.getCurrencyDepositsNotMc(deposits, Currency.EUR);
        List<DepositDto> usdDeposits = DepositUtils.getCurrencyDepositsNotMc(deposits, Currency.USD);
        List<DepositDto> concatDeposits = new ArrayList<DepositDto>();
        concatDeposits.addAll(rubDeposits);
        concatDeposits.addAll(mcDeposits);
        concatDeposits.addAll(eurDeposits);
        concatDeposits.addAll(usdDeposits);
        return concatDeposits;
    }
    //==================

    public static List<DepositDto> sortDeposits(List<DepositDto> deposits) {
        List<DepositDto> openDeposits = DepositUtils.getOpenDeposits(deposits, true);
        List<DepositDto> closedDeposits = DepositUtils.getOpenDeposits(deposits, false);

        //====sort open deposits
        List<DepositDto> anotherDeposits = DepositUtils.getAnotherDeposits(openDeposits);
        List<DepositDto> sortDepositAnotherDeposit = DepositUtils.getGroupDeposits(anotherDeposits);

        List<DepositDto> depositIsCloseOnly = DepositUtils.getClosedOnlyDeposits(openDeposits);
        List<DepositDto> sortDepositIsCloseOnly = DepositUtils.getGroupDeposits(depositIsCloseOnly);

        List<DepositDto> depositIsBlocked = DepositUtils.getBlockedDeposits(openDeposits);
        List<DepositDto> sortBlockedDeposit = DepositUtils.getGroupDeposits(depositIsBlocked);


        //======sort closed deposits
        List<DepositDto> sortClosedDeposit = DepositUtils.getGroupDeposits(closedDeposits);

        List<DepositDto> sortedDeposit = new ArrayList<DepositDto>();
        sortedDeposit.addAll(sortDepositAnotherDeposit);
        sortedDeposit.addAll(sortDepositIsCloseOnly);
        sortedDeposit.addAll(sortBlockedDeposit);
        sortedDeposit.addAll(sortClosedDeposit);
        return sortedDeposit;
    }
}
