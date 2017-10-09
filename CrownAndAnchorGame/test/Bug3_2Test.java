package test;

import java.util.Random;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import src.Dice;
import src.DiceValue;
import src.Game;
import src.Player;

public class Bug3_2Test {
	
	DiceValue sut;
	
	
	@Test
	public void testRandom() {
		//using this test to figure out how the Random works. 
		Random RANDOM = new Random();
		
		int random = RANDOM.nextInt(6);   //if we place in 6, same number of values in Hashmap
		
		for(int i = 0; i < 100; i++) {
			random = RANDOM.nextInt(6);
			assertTrue(random <= 5);
		}
		
	}
	
	@Test
	public void testBugPart1() {
		//running test 100 times, seeing if it ever equals SPADE
		for(int i = 0; i < 100; i++) {
			sut.getRandom();
			assertTrue(sut != DiceValue.SPADE);
		}
		
		
		
	}
	//bug3.2 and bug3.1 solving also solves the overall Bug3

}
