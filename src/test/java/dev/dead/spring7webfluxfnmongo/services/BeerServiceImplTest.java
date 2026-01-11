package dev.dead.spring7webfluxfnmongo.services;

import dev.dead.spring7webfluxfnmongo.domain.Beer;
import dev.dead.spring7webfluxfnmongo.mappers.BeerMapper;
import dev.dead.spring7webfluxfnmongo.model.BeerDTO;
import dev.dead.spring7webfluxfnmongo.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BeerServiceImplTest {
    @Autowired
    BeerService beerService;

    @Autowired
    BeerMapper beerMapper;

    BeerDTO beerDTO;

    @BeforeEach
    void setUp() {
        beerDTO = beerMapper.beerToBeerDto(getBeer());

    }

    @Test
    void testSave() {
        Mono<BeerDTO> beerDTOMono = Mono.just(beerDTO);
        beerService.save(beerDTOMono)
                .subscribe(beerDTO1 -> log.info("{}", beerDTO1));
        StepVerifier.create(beerDTOMono)
                .expectNextCount(1)
                .verifyComplete();
    }

    Beer getBeer() {
        return Beer.builder()
                .beerName("test")
                .beerStyle("test")
                .quantityOnHand(10)
                .price(BigDecimal.valueOf(10))
                .upc("1234567890")
                .build();
    }

}