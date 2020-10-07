/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.myrecommender.data.model;

import lombok.*;

/**
 * @author CalAF
 */
@Data
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class Trade_Receipt {
    @NonNull
    String Trade_Owner;
    String Trade_Price;
    String Trade_Type;
    String Trade_Opening_Date;
    String Trade_Closing_Date;
    String Trade_Strategy_Name;
    String Trade_Transaction_Symbol;
}
