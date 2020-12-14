package com.unknown.commons.base.repo;

import com.unknown.commons.base.data.BaseProfile;
import com.unknown.commons.implemented.Email;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface BaseProfileRepo<T extends BaseProfile<ID>, ID extends Serializable> extends CrudRepository<T, ID> {
    List<T> findByProfile_Email(Email email);

    List<T> findAllByProfile_Email(Email email);
}
