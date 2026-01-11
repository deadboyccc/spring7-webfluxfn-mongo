package dev.dead.spring7webfluxfnmongo.repositories;

import dev.dead.spring7webfluxfnmongo.domain.Beer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BeerRepository extends ReactiveMongoRepository<Beer, Integer> {
}
