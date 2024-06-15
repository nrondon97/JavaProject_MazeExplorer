/**
 * Name: Naylene Rondon
 * 
 * Florida Tech CIS 2503
 * 6.2 Programming Assignment
 * 
 * Date Last Modified: 2/17/24
 * 
 * Purpose:
 * Creates a random horror Maze
 * There's two sets of locations and some additional can be added when exploring. 
 * If the stack runs empty before escape, there's a message letting the user know
 * If the escape was successful the loop will break.
 */
//imports
import java.util.*;

public class MazeExplorer 
{
	
	private static ArrayList <String > locationCheck = new ArrayList <String> (); //Allows locations to checked for repeats 
	
	public static void main (String[]args)
	{
		//Variables 
		String [] locations = {"Maze's Exit","Gargoyle Statue", "Scarecrow", "Dead End", "Dead Tree", "A Circle of lit Candles","Abandoned Manor", "Axe on the floor"};
		String [] bonusLocations = {"Clown Statue", "Faceless Baby Doll", "Covered Well", "A Rocking Chair", "Dead End"};
		Stack <String> stackLocations = new Stack<String>();
		boolean succesfulEscape = false;
		Random random = new Random();
		
		stackLocations.push(locations[0]); //Make sure that the Exit is first in so it will be the last one out
		for (int i = 0; i < 20; i++) // Allows some locations to be duplicated to create the feeling of being lost in a maze
		{
			int randomIndex = random.nextInt(locations.length); //Adding values to the stack in random order.
			if (randomIndex != 0)
			{
				stackLocations.push(locations[randomIndex]);
			}
		}
		
		System.out.println("I woke up in the middle of this weird corn maze. It's dark and cold outside.\n"+
		"I think I can hear rustling in the distance. I need to get out of here.");
		try { //Using try and catch to catch empty stack error
			while (stackLocations.empty() == false)
			{
				if(stackLocations.peek().equals("Maze's Exit")) 
				{
					System.out.println();
					System.out.println("I finally found the Maze's Exit. I'm safe now!");
					succesfulEscape = true;
					break;
				}
				else if (repeatedLocation(stackLocations.pop()) == false)
				{
					for (int i = 0; i < 2; i++) //After exploring to new locations get added to the stack
					{
						int randomIndex = random.nextInt(bonusLocations.length); //Adding values to the stack in random order.
						stackLocations.push(bonusLocations[randomIndex]);
					}
				}
				else
				{
					System.out.println("Let me go back and try a different way.");
				}
			}
			
			if(stackLocations.empty() == true && succesfulEscape == false) //This is the stack somehow empty's before triggering the escape
			{
				System.out.println();
				System.out.println("I think I can hear something breathing behind me. I'm not going to escape this Maze...");
			}
			
		}
		catch(EmptyStackException e)
		{
			
		}
	}
	

	
	public static boolean repeatedLocation (String poppedLocation) //Checks if it's a repeatedLocated and triggers a true or false
	{
		if (locationCheck.contains(poppedLocation))
		{
			System.out.println();
			System.out.println("This is "+ poppedLocation +". I've been here before.");
			return true;
		}
		else
		{
			locationCheck.add(poppedLocation);
			System.out.println();
			System.out.println("I've found a " + poppedLocation +". Let me explore and see where else I can go.");
			return false;
		}
	}
	
	
}
