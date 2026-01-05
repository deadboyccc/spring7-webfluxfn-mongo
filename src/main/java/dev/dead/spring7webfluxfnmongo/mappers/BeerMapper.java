package dev.dead.spring7webfluxfnmongo.mappers;

import dev.dead.spring7webfluxfnmongo.domain.Beer;
import dev.dead.spring7webfluxfnmongo.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDTO beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDTO beerDTO);

}
