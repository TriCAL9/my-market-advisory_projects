package api.recomm.test;

import com.marketav.commons.base.data.BaseTrade;
import com.marketav.commons.base.repo.BaseTradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

@Test(groups = "testTrade", dependsOnGroups = {"testMemberOperation"})
public abstract class BaseTradeRepoTest<T extends BaseTrade, ID> extends AbstractTestNGSpringContextTests {
    @Autowired
    BaseTradeRepo<T, ID> baseTradeRepo;

    protected abstract T createTrade(String profileEmail, Integer memberId, LocalDate marketTransactionDate,
                                     Integer marketId, BigDecimal tradePrice, LocalDate tradeClosingDate,
                                     String tradeType, LocalDate tradeOpeningDate, String memberFirstName, String memberLastName);

    @Test
    public void testOperation() {
        T initialTrade = createTrade("cartworld@shopping.com", 1, LocalDate.now(), 1,
                BigDecimal.valueOf(12.50), LocalDate.ofYearDay(LocalDate.now().getYear(),
                        LocalDate.now().getDayOfYear()), "BUY", LocalDate.now(),
                "Suck", "Dick");
        baseTradeRepo.save(initialTrade);

        Assert.assertEquals(baseTradeRepo.count(), 1);

        T secondTrade = createTrade("lookatusbunch@outlook.com", 2, LocalDate.now().plusDays(1), 2,
                BigDecimal.valueOf(11.50), LocalDate.now().plusDays(2), "BUY", LocalDate.now().plusDays(1),
                "Little", "Bitch");
        baseTradeRepo.save(secondTrade);

        Assert.assertEquals(baseTradeRepo.count(), 2);
    }
}