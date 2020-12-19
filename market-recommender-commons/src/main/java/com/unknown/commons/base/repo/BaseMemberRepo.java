package com.unknown.commons.base.repo;

import com.unknown.commons.base.data.BaseMember;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface BaseMemberRepo<T extends BaseMember<ID>, ID extends Serializable> extends CrudRepository<T, ID> {

}
