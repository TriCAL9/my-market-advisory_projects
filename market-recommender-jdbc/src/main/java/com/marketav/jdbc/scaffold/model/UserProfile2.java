/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseUserProfile2;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

/**
 * @author CalAF
 */


@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table("User_Profile2")
public class UserProfile2 implements BaseUserProfile2 {
    @Column("Logged_Out")
    LocalDate loggedOut;

    @Column("Currently_Signed_In")
    boolean currentlySignedIn;

    @NonNull
    @Column("Profile_Email")
    String profileEmail;

    @Id
    @NonNull
    @Column("Signed_in")
    LocalDate signedIn;
}
