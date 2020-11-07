package hangman;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class HM {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		File dictionary = new File("/Users/clark/newworkspace/Hangman/src/dictionary.txt");
		
		Scanner textScanner = new Scanner(dictionary);
		Scanner input = new Scanner(System.in);
		
		ArrayList<String> words = new ArrayList<>();
		
		while(textScanner.hasNextLine())
		{
			words.add(textScanner.nextLine());
		}
		
		
		String getWord = words.get((int) (Math.random() * words.size()));
		
		char[] wordArray = getWord.toCharArray();
		char[] userAnswers = new char[wordArray.length];
		
		for(int i = 0; i < wordArray.length; i++)
		{
			userAnswers[i] = '?';
		}
 	
		boolean finished = false;
		int lives = 6;
		
		while(finished == false)
		{
			String letter = input.next();
			
			while(letter.length() != 1 || Character.isDigit(letter.charAt(0)))
			{
				System.out.println("Error Input - Try Again");
				letter = input.next();
			}
			
			boolean correct = false;
			for(int i = 0; i < wordArray.length; i++)
			{
				if(letter.charAt(0) == wordArray[i])
				{
					userAnswers[i] = wordArray[i];
					correct = true;
				}
			}
			
			if(!correct)
			{
				lives--;
				
				System.out.println("Incorrect");
			}
			
			boolean complete = true;
			for(int i = 0; i < userAnswers.length; i++)
			{
				if(userAnswers[i]=='?')
				{
					System.out.print(" _");
					complete = false;
				}
				else
				{
					System.out.print(" " + userAnswers[i]);
				}
			}
			
			System.out.println("\n" + "You have " + lives + " left.");
			
			if(complete)
			{
				System.out.println("YOU WIN!");
				finished = true;
			}
			
			if(lives <= 0)
			{
				System.out.println("You lose! Try Again");
			}
			
		}

	}

}
