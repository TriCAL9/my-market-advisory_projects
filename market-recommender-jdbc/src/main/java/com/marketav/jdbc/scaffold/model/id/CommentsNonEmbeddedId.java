package com.marketav.jdbc.scaffold.model.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsNonEmbeddedId implements Serializable {
    String memberComments;
    Integer memberId;
    String profileEmail;
}
