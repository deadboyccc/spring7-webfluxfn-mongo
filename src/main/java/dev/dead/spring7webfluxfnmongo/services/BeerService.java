package dev.dead.spring7webfluxfnmongo.services;

import dev.dead.spring7webfluxfnmongo.domain.Beer;
import dev.dead.spring7webfluxfnmongo.model.BeerDTO;
import reactor.core.publisher.Mono;

public interface BeerService {
    Mono<BeerDTO> save(Mono<BeerDTO> beerDTO);

    Mono<BeerDTO> getById(Integer id);
}
