package JUnitTests.logic;

import static org.junit.Assert.*;
import logic.Board;
import logic.BoardInterface;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Board testBoard;
	
	@Before
	public void setUp() throws Exception {
	this.testBoard= new Board();
	
	
	}

	@After
	public void tearDown() throws Exception {
	this.testBoard=null;
	}



	@Test
	public void testSetBubble() {
		for (int i =0; i< 6; i++)for(int j=0; j<5; j++)this.testBoard.setBubble(i,j, (((i%2)==0)&&((j%2)==0))? 1 :4);
		for (int i =0; i< 6; i++)for(int j=0; j<5; j++)assertEquals((((i%2)==0)&&((j%2)==0))? 1 :4, this.testBoard.getBubbleValue(i,j));
	}

	@Test
	public void testTouch() {
		
		
		for (int i =0; i< 6; i++)for(int j=0; j<5; j++){assertEquals(5,this.testBoard.getBubbleValue(i, j)); }
	}

	@Test
	public void testGetBubbleValue() {
		assertTrue(true);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(this.testBoard.isEmpty());
	}

	@Test
	public void testCopy() {
		BoardInterface copyBoard;
		
		//this.testBoard.setBubble(0, 0, 1);
		//this.testBoard.touch(0, 0);
		for (int i =0; i< 6; i++)for(int j=0; j<5; j++)this.testBoard.setBubble(i, j, 1);
		for (int i =0; i< 6; i++)for(int j=0; j<5; j++)assertTrue(this.testBoard.getBubbleValue(i, j) == 1);
		
		
		copyBoard=this.testBoard.copy();
		
		copyBoard.touch(0, 0);
		assertFalse(this.testBoard.getBubbleValue(0,0)==copyBoard.getBubbleValue(0, 0));
		
		
		
		//copyBoard.setBubble(0, 0, 5);
		//assertEquals(5, copyBoard.getBubbleValue(0, 0));
		//assertFalse( copyBoard.getBubbleValue(0, 0)==testBoard.getBubbleValue(0, 0));
		
	}
	
	@Test
	public void testBoard(){
	BoardInterface copyBoard;
		
		
		for (int i =0; i< 6; i++)for(int j=0; j<5; j++)this.testBoard.setBubble(i, j, 1);
		for (int i =0; i< 6; i++)for(int j=0; j<5; j++)assertTrue(this.testBoard.getBubbleValue(i, j) == 1);
		
		
		copyBoard=new Board(this.testBoard);
		
		copyBoard.touch(0, 0);
		assertFalse(this.testBoard.getBubbleValue(0,0)==copyBoard.getBubbleValue(0, 0));
		
	}

}
