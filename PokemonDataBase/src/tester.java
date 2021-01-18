import java.util.ArrayList;
import java.util.Scanner;

public class tester {
	
	
	private static PokemonList pokemon = new PokemonList();
	

	public static void main(String[] args) 
	{	
		System.out.println("--------------------------------");
		System.out.println("Welcome to Toms Pokemon Project");
		System.out.println("Short-cuts:");
		System.out.println("Q - quits app" + "\n" + "S - searches for Pokemon" + "\n" + "L - lists legendaries" + "\n" + "T - lists Pokemon by types" + "\n" + "X - size of PokeDex" + "\n" + "A - adds Pokemon to party" +"\n" + "R - removes Pokemon from party" + "\n" + "P - prints party" +  "\n" + "Size - Size of party" + "\n" + "Help - prints short cuts");
		System.out.println("--------------------------------");
		
		Scanner userInput = new Scanner(System.in);
		String action = "";
		boolean quit = false;
		
		do {
			action = userInput.nextLine();
			action = action.toLowerCase();
			
			switch(action)
			{
			case"q":
				quit = true;
				break;
				
			case"s":
				listPokemon(userInput);
				System.out.println("\n" + "Enter short-cuts or Q to quit");
				break;
			
			case"l":
				listLegendarys();
				System.out.println("\n" + "Enter short-cuts or Q to quit");
				break;
			
			case"t":
				findByTyping(userInput);
				System.out.println("\n" + "Enter short-cuts or Q to quit");
				break;
			
			case"x":
				sizeOfDex();
				System.out.println("\n" + "Enter short-cuts or Q to quit");
				break;
			
			case"a":
				createParty(userInput);
				System.out.println("\n" + "Enter short-cuts or Q to quit");
				break;
				
			case"p":
				printParty();
				System.out.println("\n" + "Enter short-cuts or Q to quit");
				break;
				
			case"r":
				removeFromParty(userInput);
				System.out.println("\n" + "Enter short-cuts or Q to quit");
				break;
				
			case"size":
				sizeOfParty();
				break;
				
			case"help":
				printShortCuts();
				break;
	
			default:
				System.out.println("oops!");
			}
			
			
		}while(!quit);
		System.out.println("Goodbye");
		userInput.close();

	}
	
	public static void listPokemon(Scanner userInput)
	{
		
		System.out.println("Enter Pokemon");
		String name = userInput.nextLine();
		
		Pokemon p = pokemon.printPokemonInfo(name);
		
		if(p != null)
		{
			System.out.println(p.printPokemon());
		}
		else
		{
			System.out.println("Pokemon not found");
		}	
	}
	
	public static void listLegendarys()
	{
		pokemon.printLegendary();
	}
	
	public static void findByTyping(Scanner userInput)
	{
		System.out.println("Enter type for Pokemon");
		String type = userInput.nextLine();
		
		Pokemon poke = pokemon.findPokemonByType(type);
		
		if(poke != null)
		{
			poke.printType();
		}
		else
		{
			System.out.println("Type not found");
		}
	}
	
	public static void sizeOfDex()
	{
		System.out.println("Size of PokeDex: " + pokemon.printDexSize() + " Pokemon");
	}
	
	public static void createParty(Scanner userInput)
	{
		System.out.println("Enter Pokemon to add to party");
		String name = userInput.nextLine();
		
		Pokemon p = pokemon.createParty(name);
		
		if(p!= null && pokemon.getSizeOfParty() <= 6)
		{
			System.out.println("Added pokemon");
		}
		else if (pokemon.getSizeOfParty() >= 6)
		{
			System.out.println("Party is full!");
			
		}
		else
		{
			System.out.println("Pokemon not found!");
		}
	}
	
	public static void printParty()
	{
		System.out.println("-------------PARTY--------------");
		pokemon.printParty();
	}
	
	public static void printShortCuts()
	{
		System.out.println("--------------------------------");
		System.out.println("Q - quits app" + "\n" + "S - searches for Pokemon" + "\n" + "L - lists legendaries" + "\n" + "T - lists Pokemon by types" + "\n" + "X - size of PokeDex" + "\n" + "A - adds Pokemon to party" + "\n" + "P - prints party" + "\n" + "Help - prints short cuts");
		System.out.println("--------------------------------");

	}
	
	public static void removeFromParty(Scanner userInput)
	{
		System.out.println("Enter pokemon name to remove them from current party");
		String name = userInput.nextLine();
		
		Pokemon p = pokemon.removePokemonFromParty(name);
		
		if(p!= null && pokemon.getSizeOfParty() >= 1)
		{
			System.out.println("Removed: " + name);
		}
		else if (pokemon.getSizeOfParty() == 0)
		{
			System.out.println("No Pokemon In Party");
		}
		else
		{
			System.out.println("Pokemon not found");
		}
	}
	
	public static void sizeOfParty()
	{
		System.out.println("Size of party: " + pokemon.getSizeOfParty());
	}

}


