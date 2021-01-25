package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseUserProfile2;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

public interface BaseUserProfile2Repo<T extends BaseUserProfile2, ID extends Serializable> extends CrudRepository<T, ID> {
    @Query("SELECT FROM P.* WHERE user_profile2 "
            + "P.Currently_Signed_in = :status")
    List<T> findByStatus(@Param(":status") boolean signedIn);

}
