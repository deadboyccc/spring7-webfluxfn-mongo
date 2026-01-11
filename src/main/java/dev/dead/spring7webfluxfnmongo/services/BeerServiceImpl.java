package dev.dead.spring7webfluxfnmongo.services;

import dev.dead.spring7webfluxfnmongo.domain.Beer;
import dev.dead.spring7webfluxfnmongo.mappers.BeerMapper;
import dev.dead.spring7webfluxfnmongo.model.BeerDTO;
import dev.dead.spring7webfluxfnmongo.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public Mono<BeerDTO> save(Mono<BeerDTO> beerDTO) {
        return beerDTO
                .map(beerMapper::beerDtoToBeer)
                .flatMap(beerRepository::save)
                .map(beerMapper::beerToBeerDto);


    }

    @Override
    public Mono<BeerDTO> getById(Integer id) {
        return null;
    }
}
