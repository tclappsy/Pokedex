
public class Pokemon 
{
	private int id;
	private String name;
	private String type1;
	private String type2;
	private int totalStats;
	private int hP;
	private int attack;
	private int defense;
	private int specialAttack;
	private int specialDefense;
	private int speed;
	private int gen;
	private boolean legendary;
	
	public Pokemon(int id, String name, String type1, String type2, int totalStats, int hP, int attack, int defense, int specialAttack, int specialDefense, int speed, int gen, boolean legendary)
	{
		this.id = id;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.totalStats = totalStats;
		this.hP = hP;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
		this.gen = gen;
		this.legendary = legendary;
	}
	
	public int getID()
	{
		return id;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public boolean getLegendary()
	{
		if(legendary == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String getType1()
	{
		return type1;
	}
	
	public String getType2()
	{
		return type2;
	}
	
	public String printPokemon()
	{
		return "Name: " + name + "\n" + "Type: " + type1 + " " + type2 + "\n" + "Total Stats: " + totalStats + "\n" + "HP: " + hP + "\n" 
				+ "Attack: " + attack + "\n" + "Defense: " + defense + "\n" + "Special Attack: " +  specialAttack + "\n" + "Special Defense: " +  specialDefense + "\n" 
				+ "Speed: " + speed;
	}
	
	public String printLegendarys()
	{
		return "Name: " + name + "\n" + "Type: " + type1 + " " + type2 + "\n";
	}
	
	public String printType()
	{
		return "Name: " + name + "\n" + "Type: " + type1 + " " + type2;
	}
	
	public String printParty()
	{
		
		return name;
	}
	
}
