package game;

/********************************************************
*
*  Project :  <A01 Student>
*  File    :  <GameState.java>
*  Name    :  <Dirk Andersen>
*  Date    :  <1/23/2014 >
*
*  Description :
*
*    1) This Class keeps track of the games state.
*
*    2) n/a
*
*    3) n/a
*
*  Changes : n/a
*
********************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import infastructure.*;

public class GameState {
	private List<Character> guessedCharacters;
	private int maxNumberofWrongGuess = 6;
	private List<Character> word = Arrays.asList('u', 't', 'a',	'h');
	

	public int getMaxNumberofWrongGuess() {
		return maxNumberofWrongGuess;
	}

	public GameState(){
		guessedCharacters = new ArrayList<>();		
	}
	
	public List<Character> getGuessedCharacters() {
		return guessedCharacters;
	}

	public List<Character> getWord() {
		return word;
	}

	public int calcNumberOfWrongGuessesMade(){
		List<Character> temp = new ArrayList(guessedCharacters);
		temp.removeAll(word);
		return temp.size();
	}
	
	public boolean hasWon(){
		return guessedCharacters.containsAll(word);
	}
	
	public boolean hasLost(){
		return calcNumberOfWrongGuessesMade() >= 6;
	}
	
	public boolean hasGameEnded(){
		return hasWon() || hasLost();
	}
	
	public void addToGuessedCharacters(char guess){
		guessedCharacters.add(guess);
	}
}
