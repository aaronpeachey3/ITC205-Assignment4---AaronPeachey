package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import src.Dice;
import src.DiceValue;
import src.Game;
import src.Player;

public class bug3_1Test {
	
	Dice sut;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testBugPart1() {
		//replicating behavour of the dice that will not randomize! 
		//specifically looking at the Dice method not changing the current value state
		
		//since we are looking at randomized numbers we need to run this test many times to make sure it isnt just 
		//chance that is making the v
		
		sut = new Dice();
		
		DiceValue value = sut.getValue();
		sut.roll();
		DiceValue value2 = sut.getValue();
		
		assertEquals(value, value2);
		
		
	}

}
