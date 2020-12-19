/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknown.jpa.model;

import com.unknown.commons.base.data.BaseMarket;
import com.unknown.commons.base.data.BaseMember;
import com.unknown.commons.implemented.Asset;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Id;
import java.sql.Date;

/**
 * @author CalAF
 */
@Data
public class Market implements BaseMarket<BaseMember<Integer>, Date> {
    @Id
    @NonNull
    Date Market_Transaction_Date;
    @Id
    @NonNull
    String Market_Portfolio_Name;
    String Market_Technical_Condition;
    Asset Market_Asset_Type;
}
