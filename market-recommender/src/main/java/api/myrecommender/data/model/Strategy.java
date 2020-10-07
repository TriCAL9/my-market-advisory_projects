/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.myrecommender.data.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author CalAF
 */
@Data
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class Strategy {

    String Strategy_Name;
    String Strategy_Researcher;
    String Strategy_Summary;
    String Strategy_Source_URL;
}
