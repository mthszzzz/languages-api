package com.mths.linguagensapi;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> { // <do que é esse repositório e tipo do id>
    List<Linguagem> findByOrderByRanking(); // ordernar pelo ranking
}
