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
public class Symbol {
    @NonNull
    String Symbol_Type;
    String Symbol_Rating;
    String Symbol_Sign;
}
