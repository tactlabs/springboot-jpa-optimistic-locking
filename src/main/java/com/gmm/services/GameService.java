package com.gmm.services;
//Author: Muthu Mariyappan G

import java.util.Optional;

import com.gmm.entities.Games;

public interface GameService {
	public Optional<Games> find(Integer id);
	public Games update(Games game);
}
