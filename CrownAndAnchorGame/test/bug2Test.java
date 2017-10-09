package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import src.Dice;
import src.DiceValue;
import src.Game;
import src.Player;

public class bug2Test {
	
	Player sut;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test //this test shows that the system fails consistently when limit hits 0
	public void testBugPart1() {
		
		sut = new Player("Aaron", 10);
		
		//method should return true until balance - the next amount is less than the limit
		//balance = 10
		//limit = 0
		//amount = 5
		//reusult should be true
		boolean result = sut.balanceExceedsLimitBy(5);
		assertTrue(result == true);
		
		//balance = 10
		//limit = 0
		//amount = 10
		//result should be true still, since balance can equal 0 but not go below
		result = sut.balanceExceedsLimitBy(10);
		assertTrue(result == true);
		
		
		//balance = 10
		//limit = 0
		//amount = 15
		//result should be true still, since balance can equal 0 but not go below
		result = sut.balanceExceedsLimitBy(15);
		assertFalse(result == true);

	}

}
