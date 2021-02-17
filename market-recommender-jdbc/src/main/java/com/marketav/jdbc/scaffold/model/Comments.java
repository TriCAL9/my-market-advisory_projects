package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseComments;
import com.marketav.jdbc.scaffold.model.id.CommentsNonEmbeddedId;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Access(AccessType.FIELD)
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@Table(name = "COMMENTS")
@Entity
@IdClass(CommentsNonEmbeddedId.class)
public class Comments implements BaseComments<String, Integer>, Serializable {

    @Id
    @NonNull
    @Column(name = "Member_Comment")
    String memberComments;

    @Id
    @NonNull
    @Column(name = "Member_Id")
    Integer memberId;

    @Id
    @NonNull
    @Column(name = "Profile_Email")
    String profileEmail;

    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "Member_Id")
    Member member;

}
