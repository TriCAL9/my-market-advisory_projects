package com.marketav.jdbc.scaffold.model.id;

import java.io.Serializable;
import java.time.LocalDate;

public class UserProfile2NonEmbeddedId implements Serializable {
    String profileEmail;
    LocalDate signedIn;
}
