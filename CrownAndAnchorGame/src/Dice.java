package src;
public class Dice {
			
	private DiceValue value;
	
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return value;
	}

	public void roll() {
		this.value = DiceValue.getRandom();
	}		
	
	public String toString() {
		return value.toString();
	}
}
