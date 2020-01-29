package com.persistantcoder.msscbeerservice.web.mappers;

import com.persistantcoder.msscbeerservice.domain.Beer;
import com.persistantcoder.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by Evans K F C on Nov ,2019
 **/

@Mapper(uses={DateMapper.class})
public interface BeerMapper {

    BeerDto convertToBeerDto (Beer beer);
    Beer convertToBeer (BeerDto beerDto);
}
