package game;

/********************************************************
*
*  Project :  <A01 Student>
*  File    :  <GameIO.java>
*  Name    :  <Dirk Andersen>
*  Date    :  <1/23/2014 >
*
*  Description :
*
*    1) This Class Runs the hangman game.
*
*    2) n/a
*
*    3) n/a
*
*  Changes : n/a
*
********************************************************/

import infastructure.IO;

import java.util.List;

public class GameIO {
	private GameState gs = new GameState();
	
	public GameIO(){
	
	}
	
	private void promptForCharacter(){
		String tempString = IO.promptForString("Please enter a letter that you might think is in the word.");
		char tempChar = tempString.toLowerCase().charAt(0);
		
		gs.addToGuessedCharacters(tempChar);
	}
	
	private void showWordAsGuessed(){
		for(char el : gs.getWord()){
			if(gs.getGuessedCharacters().contains(el)){
				System.out.print(el + " ");
			}
			else{
				System.out.print("_ ");
			}
		}
		System.out.print("    ");
	}
	
	private void showNumberOfLivesLeft(){
		int livesLeft = gs.getMaxNumberofWrongGuess() - gs.calcNumberOfWrongGuessesMade();
		System.out.println("Number of Lives Left: " + livesLeft);
	}
	
	public void gameLoop(){
		showWordAsGuessed();
		showNumberOfLivesLeft();
		
		while(!gs.hasGameEnded()){
			promptForCharacter();
			showWordAsGuessed();
			showNumberOfLivesLeft();
		}
		System.out.println(gs.hasWon() ? "Congrats you have one!" : "Sorry you loose");
	}
	
	public static void main(String[] args){
		GameIO gio = new GameIO();
		gio.gameLoop();
	}
}
