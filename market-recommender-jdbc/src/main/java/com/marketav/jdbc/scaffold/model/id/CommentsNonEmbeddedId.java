package com.marketav.jdbc.scaffold.model.id;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CommentsNonEmbeddedId implements Serializable {
    String memberComments;
    Integer memberId;
    String profileEmail;
}
