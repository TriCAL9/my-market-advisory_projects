/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknown.jpa.model;

import com.unknown.commons.base.data.BaseTradeReceipt;
import lombok.*;

/**
 * @author CalAF
 */
@Data
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class TradeReceipt implements BaseTradeReceipt {
    @NonNull
    String Trade_Owner;
    String Trade_Price;
    String Trade_Type;
    String Trade_Opening_Date;
    String Trade_Closing_Date;
    String Trade_Strategy_Name;
    String Trade_Transaction_Symbol;
}
