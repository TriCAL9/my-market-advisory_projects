package com.marketav.commons.base.data;

import java.time.LocalDate;

public interface BaseUserProfile2 {

    LocalDate getLoggedOut();

    void setLoggedOut(LocalDate Logged_Out);

    boolean isStatus();

    void setStatus(boolean Currently_Signed_In);
}
