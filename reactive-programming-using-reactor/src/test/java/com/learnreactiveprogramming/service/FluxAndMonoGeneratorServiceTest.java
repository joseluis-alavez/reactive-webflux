package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {

        Flux<String> names = fluxAndMonoGeneratorService.namesFlux();

        StepVerifier.create(names)
        //.expectNext("alex", "ben", "chloe")
                .expectNextCount(3)
        .verifyComplete();
        
    }

    @Test
    void namesFluxMap() {
        Flux<String> names = fluxAndMonoGeneratorService.namesFluxMap();
        StepVerifier.create(names)
                .expectNext("ALEX", "BEN", "CHLOE")
                .verifyComplete();
    }

    @Test
    void namesFluxMap_inmutablility() {

        Flux<String> names = fluxAndMonoGeneratorService.namesFluxMap_inmutablility();
        StepVerifier.create(names)
                .expectNext("alex", "ben", "chloe")
                .verifyComplete();
    }
}