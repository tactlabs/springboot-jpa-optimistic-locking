package com.gmm.base.rest;
//Author: Muthu Mariyappan G

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmm.entities.Games;
import com.gmm.services.GameService;

@RestController
public class OptimisticLockingController {

	@Autowired
	private GameService gameService;
	
	//Finds Games details for the given id 
	@RequestMapping(value="/Games/find/{id}")
	public Map<String,String> find(@PathVariable Integer id){
		//@PathVariable takes the part of url as value here {id} taken as id value
		Map<String,String> message = new LinkedHashMap<>(); // to store Games details
		Games foundGames;
		//this.GamesService.find(id) returns Optional<> whose methods are isPresent and get()
		if(this.gameService.find(id).isPresent()) { // if the given Games id is present
			foundGames = this.gameService.find(id).get(); //fetches the Games record from the database
			//Getting Games detail with help of getter methods
			message.put("ID", foundGames.getId().toString());
			message.put("Name", foundGames.getName());
			message.put("Price", foundGames.getPrice().toString());
			message.put("Version[opt lock field]", foundGames.getVersion().toString()); 
			
		}
		else { 
			message.put("Error","Cannot find game with id "+id);
		}
		return message;
	}
	
	@RequestMapping(value="/Games/update") //Updates Games table
	public Map<String,String> updateGames(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("price") Integer price){
		System.out.println("\nrunning update");
		Map<String,String> message = new LinkedHashMap<>();
		Games newGames;
		if(this.gameService.find(id).isPresent()) {
			
				newGames = this.gameService.find(id).get();
				newGames.setName(name);
				newGames.setPrice(price);
				
				
				if(this.gameService.update(newGames)!=null) {
					message.put("Success", "Games details successfully updated");
					message.put("ID",newGames.getId().toString());
					message.put("Name", name);
					message.put("Price", price.toString());
					message.put("Version", newGames.getVersion().toString());
				}
				else
					message.put("Error", "Error cannot update Games");
		}
		else
			message.put("Error", "Games id "+id+" is not found");
		return message;
	}
}
