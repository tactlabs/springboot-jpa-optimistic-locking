package com.gmm.services;
//Author: Muthu Mariyappan G

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmm.entities.Games;
import com.gmm.repositories.GameRepository;

@Transactional //Spring dynamically creates a proxy that implements the same interface(s) as the class that gets annotated
@Service("gameService")
class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Override
	public Optional<Games> find(Integer id) {
		
		return this.gameRepository.findById(id);
	}

	@Override
	public Games update(Games game) {
		
		return this.gameRepository.save(game);
	}
}
