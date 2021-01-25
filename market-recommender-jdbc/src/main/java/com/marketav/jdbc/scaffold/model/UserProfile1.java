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
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

/**
 * @author CalAF
 */

@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table("user_profile1")
public class UserProfile1 implements BaseUserProfile1<String> {
    @NonNull
    @Column("Profile_Name")
    String profileName;
    @Id
    @NonNull
    @Column("Profile_Email")
    String profileEmail;
    @NonNull
    @Column("Profile_Password")
    String profilePassword;
    @MappedCollection(keyColumn = "Signed_in")
    Map<LocalDate, UserProfile2> userProfile1Map;
    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    Set<Member> member;
}
