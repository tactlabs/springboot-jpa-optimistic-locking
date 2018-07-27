package com.gmm.repositories;
//Author: Muthu Mariyappan G

import org.springframework.data.repository.CrudRepository;

import com.gmm.entities.Games;

public interface GameRepository extends CrudRepository<Games, Integer>{
	
}
