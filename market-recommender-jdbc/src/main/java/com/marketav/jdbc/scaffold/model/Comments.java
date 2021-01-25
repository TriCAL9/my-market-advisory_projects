package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseComments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor(staticName = "of")
@Table("Comments")
public class Comments implements BaseComments<String, Integer> {
    @Id
    @NonNull
    @Column("Member_Comment")
    String memberComments;

    @NonNull
    @Column("Member_Id")
    Integer memberId;

    @NonNull
    @Column("Profile_Email")
    String profileEmail;
}
