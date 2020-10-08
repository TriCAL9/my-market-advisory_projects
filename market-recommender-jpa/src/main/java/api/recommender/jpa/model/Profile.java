/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.recommender.jpa.model;

import lombok.*;

/**
 * @author CalAF
 */
@Data
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class Profile {
    String Profile_Name;
    @NonNull
    String Profile_Email;
    String Profile_Password;
}
