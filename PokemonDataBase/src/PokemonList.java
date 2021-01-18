import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PokemonList 
{
	ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
	ArrayList<Pokemon> partyList = new ArrayList<Pokemon>();
	
	PokemonList()
	{
		readCSVData();
	}
	
	private void readCSVData()
	{
		String csvFile = "/Users/tomclappsy/eclipse-workspace/PokemonDataBase/src/pokemon.csv";
		String line = "";
		String csvSplitBy = ",";
		int lineCount = 0;
		
		try(BufferedReader br = new BufferedReader(new FileReader(csvFile)))
		{
			while((line = br.readLine()) != null)
			{
				String[] lineElements = line.split(csvSplitBy);
				
				if(lineCount > 0)
				{
					int id = Integer.parseInt(lineElements[0]);
					int totalStats = Integer.parseInt(lineElements[4]);
					int hP = Integer.parseInt(lineElements[5]);
					int attack = Integer.parseInt(lineElements[5]);
					int defense = Integer.parseInt(lineElements[6]);
					int specialAttack = Integer.parseInt(lineElements[7]);
					int specialDefense = Integer.parseInt(lineElements[8]);
					int speed = Integer.parseInt(lineElements[9]);
					int gen = Integer.parseInt(lineElements[10]);
					boolean legendary = Boolean.parseBoolean(lineElements[12]);
					
					Pokemon p = new Pokemon (id,
											lineElements[1],
											lineElements[2],
											lineElements[3],
											totalStats,
											hP, 
											attack,
											defense,
											specialAttack,
											specialDefense,
											speed,
											gen,
											legendary);
					pokemonList.add(p);
				}
				lineCount++;
			}
			}catch(IOException e)
			{
				e.printStackTrace();
			}		
	}



	public Pokemon printPokemonInfo(String name)
	{
		Pokemon foundPokemon = null;
		
		for(Pokemon pokemon: pokemonList)
		{
			if(pokemon.getName().equalsIgnoreCase(name))
			{
				foundPokemon = pokemon;
				foundPokemon.printPokemon();
				
			}
		}
		return foundPokemon;
	}
	
	public void printLegendary()
	{
		for(Pokemon pokemon: pokemonList)
		{
			if(pokemon.getLegendary() == true)
			{
				System.out.println(pokemon.printLegendarys());
			}
		}
	}
	
	
	public Pokemon findPokemonByType(String type)
	{
		Pokemon foundPokemon = null;
		
		for(Pokemon pokemon: pokemonList)
		{
			if(pokemon.getType1().equalsIgnoreCase(type) || pokemon.getType2().equalsIgnoreCase(type))
			{
				foundPokemon = pokemon;
				System.out.println(foundPokemon.printType());
			}
		}
		
		return foundPokemon;
	}
	
	public Integer printDexSize()
	{
		return pokemonList.size();
	}
	
	public Pokemon createParty(String name)
	{
		Pokemon foundPokemon = null;
		
		for(Pokemon pokemon: pokemonList)
		{
			if(pokemon.getName().equalsIgnoreCase(name) && partyList.size() <= 5)
			{
				foundPokemon = pokemon;
				partyList.add(foundPokemon);
			}

		}
		
		return foundPokemon;
	}
	
	public void printParty()
	{
		for(Pokemon pokemonParty: partyList)
		{
			System.out.println(pokemonParty.printParty());
		}
	}
	
	public int getSizeOfParty()
	{
		return partyList.size();
	}
	
	public Pokemon removePokemonFromParty(String name)
	{
		Pokemon foundPokemon = null;
		
		for(Pokemon pokemon: pokemonList)
		{
			if(pokemon.getName().equalsIgnoreCase(name))
			{
				foundPokemon = pokemon;
				partyList.remove(foundPokemon);
			}
		}
		
		return foundPokemon;
		
		
	}
	
	
	
}


