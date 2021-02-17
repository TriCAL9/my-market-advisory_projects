package com.marketav.jdbc.scaffold.model.id;

import java.io.Serializable;
import java.time.LocalDate;

public class SymbolNonEmbeddedId implements Serializable {
    String profileEmail;
    Integer memberId;
    Integer marketId;
    LocalDate marketTransactionDate;
}
