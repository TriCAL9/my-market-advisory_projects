package com.marketav.jdbc.scaffold.model.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarketplaceWatchlist1NonEmbeddedId implements Serializable {
    LocalDate marketTransactionDate;
    Integer marketId;
}
