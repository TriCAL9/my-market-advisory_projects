/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseUserProfile2;
import com.marketav.jdbc.scaffold.model.id.UserProfile2NonEmbeddedId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author CalAF
 */


@Data
@IdClass(value = UserProfile2NonEmbeddedId.class)
@Access(AccessType.FIELD)
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table(name = "USER_PROFILE2")
@Entity
public class UserProfile2 implements BaseUserProfile2, Serializable {

    @Column(name = "Logged_Out")
    LocalDate loggedOut;

    @Column(name = "Currently_Signed_In")
    boolean status;

    @Id
    @NonNull
    @Column(name = "Profile_Email")
    String profileEmail;

    @Id
    @NonNull
    @Column(name = "Signed_in")
    LocalDate signedIn;

    @ManyToOne
    @JoinColumn(name = "Profile_Email", updatable = false, insertable = false)
    UserProfile1 user_profile1;
}
