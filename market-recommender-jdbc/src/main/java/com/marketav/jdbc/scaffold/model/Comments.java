package com.marketav.jdbc.scaffold.model;

import com.marketav.commons.base.data.BaseComments;
import com.marketav.commons.implemented.id.CommentsNonEmbeddedId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Access(AccessType.FIELD)
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
@NoArgsConstructor()
@Table(name = "COMMENTS")
@Entity
@IdClass(CommentsNonEmbeddedId.class)
public class Comments implements BaseComments<String>, Serializable {

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
    @JoinColumns(value = {
            @JoinColumn(name = "Profile_Email", updatable = false, insertable = false),
            @JoinColumn(name = "Member_Id", updatable = false, insertable = false)
    })
    Member member;
}
