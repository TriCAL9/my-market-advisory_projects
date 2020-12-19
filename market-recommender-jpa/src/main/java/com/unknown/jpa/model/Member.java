/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unknown.jpa.model;

import com.unknown.commons.base.data.BaseMember;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author CalAF
 */
@Entity
@Data
public class Member implements BaseMember<Integer> {
    @Id
    Integer Member_id;
    String Member_First_Name;
    String Member_Last_Name;
    String Member_Recomm_Sub_Name;
}
