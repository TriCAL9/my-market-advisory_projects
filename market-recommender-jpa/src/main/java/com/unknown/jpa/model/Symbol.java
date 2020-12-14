/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknown.jpa.model;

import com.unknown.commons.base.data.BaseSymbol;
import com.unknown.commons.implemented.Asset;
import lombok.*;

import javax.persistence.Id;

/**
 * @author CalAF
 */
@Data
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class Symbol implements BaseSymbol {
    @Id
    @NonNull
    Asset Symbol_Type;
    String Symbol_Rating;
    String Symbol_Sign;
}
