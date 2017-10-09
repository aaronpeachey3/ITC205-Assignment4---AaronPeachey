package test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.*;

import src.Dice;
import src.DiceValue;
import src.Game;
import src.Player;

public class bug1Test {
	
	Player player;
	DiceValue pick;
	Dice dice1;
	Dice dice2;
	Dice dice3;
	Game sut;
	
	@Before
	public void setUp() throws Exception {

	}
	
	//pick is what the player roles, our dice object then can be mocked maybe. 
	
	@Test
	public void testBugpart1() {
		player = mock(Player.class);
		//set the players pick to SPADE
		pick = DiceValue.SPADE;
		
		dice1 = mock(Dice.class);
		dice2 = mock(Dice.class);
		dice3 = mock(Dice.class);
		
		//create our sut
		sut = new Game(dice1, dice2, dice3);

		//dice1 returns SPADE, dice2 CLUB, dice3 DIAMOND
		when(dice1.getValue()).thenReturn(DiceValue.SPADE);
		when(dice2.getValue()).thenReturn(DiceValue.CLUB);
		when(dice3.getValue()).thenReturn(DiceValue.DIAMOND);
		
		//players pick is SPADE, one SPADE is rolled by the dealer. 
		//Winnings due to bug will be 5

		int winnings = sut.playRound(player, pick, 5);
		
		assertFalse(winnings == 5);
		assertTrue(winnings == 10);
	
	}
	
	@Test //test for 2:1 win
	public void testBugpart2() {
		player = mock(Player.class);
		//set the players pick to SPADE
		pick = DiceValue.SPADE;
		
		dice1 = mock(Dice.class);
		dice2 = mock(Dice.class);
		dice3 = mock(Dice.class);
		
		//create our sut
		sut = new Game(dice1, dice2, dice3);

		//dice1 returns SPADE, dice2 SPADE, dice3 DIAMOND
		when(dice1.getValue()).thenReturn(DiceValue.SPADE);
		when(dice2.getValue()).thenReturn(DiceValue.SPADE);
		when(dice3.getValue()).thenReturn(DiceValue.DIAMOND);
		
		//players pick is SPADE, one SPADE is rolled by the dealer. 
		//Winnings due to bug will be 5

		int winnings = sut.playRound(player, pick, 5);
		
		assertTrue(winnings == 15);

	}
	
	@Test //test for 3:1 win
	public void testBugpart3() {
		player = mock(Player.class);
		//set the players pick to SPADE
		pick = DiceValue.SPADE;
		
		dice1 = mock(Dice.class);
		dice2 = mock(Dice.class);
		dice3 = mock(Dice.class);
		
		//create our sut
		sut = new Game(dice1, dice2, dice3);

		//dice1 returns SPADE, dice2 SPADE, dice3 SPADE
		when(dice1.getValue()).thenReturn(DiceValue.SPADE);
		when(dice2.getValue()).thenReturn(DiceValue.SPADE);
		when(dice3.getValue()).thenReturn(DiceValue.SPADE);
		
		//players pick is SPADE, one SPADE is rolled by the dealer. 
		//Winnings due to bug will be 5

		int winnings = sut.playRound(player, pick, 5);
		
		assertTrue(winnings == 20);

	}

	


}
