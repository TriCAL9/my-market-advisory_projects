package com.marketav.jdbc;

import api.recomm.test.BaseTradeRepoTest;
import com.marketav.commons.implemented.id.TradeNonEmbeddedId;
import com.marketav.jdbc.scaffold.model.Trade;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.testng.annotations.BeforeMethod;

import java.math.BigDecimal;
import java.time.LocalDate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TradeRepoTest extends BaseTradeRepoTest<Trade, TradeNonEmbeddedId> {
    @Override
    protected Trade createTrade(String profileEmail,
                                Integer memberId,
                                LocalDate marketTransactionDate,
                                Integer marketId,
                                BigDecimal tradePrice,
                                LocalDate tradeClosingDate,
                                String tradeType,
                                LocalDate tradeOpeningDate,
                                String memberFirstName,
                                String memberLastName) {
        return Trade.of(profileEmail, memberId, marketTransactionDate, marketId, tradePrice, tradeClosingDate, tradeType, tradeOpeningDate,
                memberFirstName, memberLastName);
    }

    @BeforeMethod
    @Override
    protected void clearData() {
        this.getBaseTradeRepo().deleteAll();
    }
}
