package com.persistantcoder.msscbeerservice.repositories;

import com.persistantcoder.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Created by Evans K F C on Nov ,2019
 **/
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
