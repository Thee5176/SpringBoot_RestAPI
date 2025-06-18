package com.thee5176.SpringBootCrudRestAPI.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class Score {
	private int wins;
	private int losses;
	private int ties;

	public Score() {}
	
	public Score(int wins, int losses, int ties) {
		this.wins   = wins;
		this.losses = losses;
		this.ties   = ties;
	}

	public void reset() {
		this.wins   = 0;
		this.losses = 0;
		this.ties   = 0;
	}	
	
	public void winScore() {
		this.wins++;
	}	
	
	public void lossScore() {
		this.losses++;
	}	
	
	public void tieScore() {
		this.ties++;

	}
}
