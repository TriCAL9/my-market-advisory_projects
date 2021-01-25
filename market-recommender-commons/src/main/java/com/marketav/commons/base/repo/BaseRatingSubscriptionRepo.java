package com.marketav.commons.base.repo;

import com.marketav.commons.base.data.BaseRatingSubscription;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BaseRatingSubscriptionRepo<R extends BaseRatingSubscription<ID, Integer>, ID> extends CrudRepository<R, ID> {

    Optional<R> findRatingSubscriptionByMemberRatingSubscriptionAndMemberId(ID sub, int memberId);
}
