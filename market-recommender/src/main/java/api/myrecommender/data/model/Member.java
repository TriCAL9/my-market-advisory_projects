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
public class Member {
    @NonNull
    Integer Member_id;
    String Member_First_Name;
    String Member_Last_Name;
    String Member_Recomm_Sub_Name;
}
