/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknown.jpa.model;

import com.unknown.commons.base.data.BaseProfile;
import com.unknown.commons.implemented.Email;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author CalAF
 */
@Entity
@Data
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class Profile implements BaseProfile<Email> {
    String Profile_Name;
    @Id
    @NonNull
    Email Profile_Email;
    String Profile_Password;

}
