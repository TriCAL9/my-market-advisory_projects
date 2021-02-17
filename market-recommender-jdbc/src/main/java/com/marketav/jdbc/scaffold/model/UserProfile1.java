/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseUserProfile1;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author CalAF
 */

@Data
@Access(AccessType.FIELD)
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table(name = "USER_PROFILE1")
@Entity
public class UserProfile1 implements BaseUserProfile1<String>, Serializable {

    @NonNull
    @Column(name = "Profile_Name")
    String profileName;

    @Id
    @NonNull
    @Column(name = "Profile_Email")
    String profileEmail;

    @NonNull
    @Column(name = "Profile_Password")
    String profilePassword;

    @OneToMany(mappedBy = "user_profile1")
    Set<UserProfile2> userProfile2Set;

    @OneToMany(mappedBy = "user_profile1")
    Set<Member> memberSet;

}
