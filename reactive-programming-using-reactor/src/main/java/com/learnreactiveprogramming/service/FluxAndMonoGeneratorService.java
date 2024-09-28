package com.learnreactiveprogramming.service;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxAndMonoGeneratorService {

    Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe")).log();
    }

    Mono<String> namesMono() {
        return Mono.just("alex").log();
    }

    Flux<String> namesFluxMap() {
        return Flux.fromIterable(List.of("alex", "ben", "chloe"))
                .map(String::toUpperCase)
                .log();
    }

    Flux<String> namesFluxMap_inmutablility() {
        Flux<String> namesFlux=  Flux.fromIterable(List.of("alex", "ben", "chloe"));

        namesFlux
                .map(String::toUpperCase)
                .log();

        return namesFlux;
    }


    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

        fluxAndMonoGeneratorService.namesFlux()
        .subscribe(name -> {
            System.out.println("Name: " + name);
        });

        fluxAndMonoGeneratorService.namesMono()
        .subscribe(name -> {
            System.out.println("Name mono : " + name);
        });
    }

}
