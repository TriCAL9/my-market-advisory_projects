/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marketav.jdbc.scaffold.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marketav.commons.base.data.BaseUserProfile1;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
@EqualsAndHashCode(exclude = {"userProfile2Set", "memberSet"})
@ToString(exclude = {"userProfile2Set", "memberSet"})
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

    @OneToMany(mappedBy = "user_profile1", fetch = FetchType.EAGER)
    @JsonIgnore
    Set<UserProfile2> userProfile2Set;

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade({org.hibernate.annotations.CascadeType.DELETE})
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    @JoinColumn(name = "Member_Id", updatable = false, insertable = false)
    Member memberSet;
}
