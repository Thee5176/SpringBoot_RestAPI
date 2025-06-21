package com.thee5176.SpringBootCrudRestAPI.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thee5176.SpringBootCrudRestAPI.Entity.Score;

@RestController
// Code Smell: CORS setting is usually done in Hosting Server along with other Security Setup
//@CrossOrigin
public class ScoreController {
	
	Score score = new Score(10,20,30);
	
	@GetMapping("/score/{scoreType}")
	public int getWinsLossesTies(@PathVariable String scoreType) {
		if (scoreType.equalsIgnoreCase("wins")) {
			return score.getWins();
		} 
		else if (scoreType.equalsIgnoreCase("losses")) {
			return score.getLosses();
		}
		else {
			return score.getTies();
		}
	}
	
	@GetMapping("/score")
	public Score getScore() {
		return score;
	}
	
	@PostMapping("/{result}")
	public Score statusReport(@PathVariable String result) {
		if (result.equalsIgnoreCase("win")) {
			score.winScore();
		} 
		else if (result.equalsIgnoreCase("lose")) {
			score.lossScore();
		}
		else {
			score.tieScore();
		}
		return score;
	}
	
	@PutMapping("/score/reset")
	public Score resetScore() {
		// Code Smell: Think of the Performance and Memory Usage 
		// - Set the new variable means change location of the memory which cause unwanted overhead overhead processing load
		// score = new Score();
		score.reset();
		return score;
	}
	
	@PutMapping("/score/set")
	public Score setScore(@RequestBody Score newScore) {
		score = newScore;
		return score;
	}
	
	@PatchMapping("/score/set/{status}")
	public Score setScore(@PathVariable String status, @RequestParam int update) {
		if (status.equalsIgnoreCase("wins")) {
			score.setWins(update);
		} 
		else if (status.equalsIgnoreCase("losses")) {
			score.setLosses(update);
		}
		else {
			score.setTies(update);
		}
		return score;
	}
	
// Code Smell: Parallel request and 
//	@DeleteMapping
//	public void deleteScore() {
//		score = null;
//	}
	
}
