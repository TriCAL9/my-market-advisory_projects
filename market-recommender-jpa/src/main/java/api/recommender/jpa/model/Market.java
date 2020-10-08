/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.recommender.jpa.model;

import lombok.*;

import java.sql.Date;

/**
 * @author CalAF
 */
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
@Data
public class Market {
    @NonNull
    Date Market_Transaction_Date;
    @NonNull
    String Market_Portfolio_Name;
    String Market_Technical_Condition;
    String Market_Asset_Type;


}
