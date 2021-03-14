package com.marketav.commons.implemented.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymbolNonEmbeddedId implements Serializable {
    String profileEmail;
    Integer memberId;
    Integer marketId;
    LocalDate marketTransactionDate;
}
