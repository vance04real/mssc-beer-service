package com.persistantcoder.msscbeerservice.web.mappers;

import com.persistantcoder.msscbeerservice.services.BeerInventoryService;

/**
 * Created by Evans K F C on Nov ,2019
 **/
public abstract class BeerMapperDecorator implements BeerMapper{

    private BeerInventoryService beerInventoryService;
    private BeerMapper beerMapper;


}
