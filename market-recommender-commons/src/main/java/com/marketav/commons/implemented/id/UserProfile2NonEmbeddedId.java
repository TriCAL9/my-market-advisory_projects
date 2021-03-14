package com.marketav.commons.implemented.id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile2NonEmbeddedId implements Serializable {
    String profileEmail;
    LocalDate signedIn;
}
