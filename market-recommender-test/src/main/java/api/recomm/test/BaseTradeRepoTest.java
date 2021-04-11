package api.recomm.test;

import com.marketav.commons.base.data.BaseTrade;
import com.marketav.commons.base.repo.BaseTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class BaseTradeRepoTest<T extends BaseTrade, ID> extends AbstractTestNGSpringContextTests {
    @Autowired
    BaseTradeRepo<T, ID> baseTradeRepo;

    protected abstract T createTrade(String profileEmail, Integer memberId, LocalDate marketTransactionDate,
                                     Integer marketId, BigDecimal tradePrice, LocalDate tradeClosingDate,
                                     String tradeType, LocalDate tradeOpeningDate, String memberFirstName, String memberLastName);

    @BeforeMethod
    protected abstract void clearData();

    public BaseTradeRepo<T, ID> getBaseTradeRepo() {
        return baseTradeRepo;
    }

    @Test(alwaysRun = true)
    public void testOperation() {
        T initialTrade = createTrade("cartworld@shopping.com", 1, LocalDate.now(), 1,
                BigDecimal.valueOf(12.50), LocalDate.ofYearDay(LocalDate.now().getYear(),
                        LocalDate.now().getDayOfYear()), "BUY", LocalDate.now(),
                "cobol", "fortran");
        baseTradeRepo.save(initialTrade);

        Assert.assertEquals(baseTradeRepo.count(), 1);

        T secondTrade = createTrade("lookatusbunch@outlook.com", 2, LocalDate.now(), 2,
                BigDecimal.valueOf(11.50), LocalDate.now().plusDays(2), "BUY", LocalDate.now().plusDays(1),
                "go", "assembly");
        baseTradeRepo.save(secondTrade);

        Assert.assertEquals(baseTradeRepo.count(), 2);
    }
}