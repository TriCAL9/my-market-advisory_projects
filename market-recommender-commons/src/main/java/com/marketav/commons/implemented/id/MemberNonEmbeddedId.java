package com.marketav.commons.implemented.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberNonEmbeddedId implements Serializable {
    private Integer memberId;
    private String profileEmail;
}
