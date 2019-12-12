import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class HW5Tester
{
  /**
   * Test for the Gomoku class
   * @author Ishaan Gupta
   */
  
  
  @Test
  public void testNumberInLine()
  {
    /**
     * Test 0, 1 & many
     */
    
    //Test 0 (There is only no element which you start searching in a particular direction)
    int array12 [][] = {{5,2,3,4,1},{2,7,6,1,8},{4,5,1,9,6}};
    int row12 = 0;
    int column12 = 4;
    Gomoku g12 = new Gomoku();    
    int c12 = g12.numberInLine(array12,row12,column12,Gomoku.Direction.DN);
    assertEquals("Testing the numberInLine method for test 0",c12,1);
    
    //Test 1 (There is only one element along with the element you start searching in a particular direction
    int array13 [][] = {{5,2,3,4,1},{2,7,6,1,1},{4,5,1,9,6}};
    int row13 = 0;
    int column13 = 4;
    Gomoku g13 = new Gomoku();    
    int c13 = g13.numberInLine(array13,row13,column13,Gomoku.Direction.DN);
    assertEquals("Testing the numberInLine method for test 1",c13,2);
    
    //Test Many (There are more than one element along with the element you start searching in a particular direction
    int array14 [][] = {{5,2,3,4,1},{2,7,6,1,1},{4,5,1,9,1}};
    int row14 = 0;
    int column14 = 4;
    Gomoku g14 = new Gomoku();    
    int c14 = g14.numberInLine(array14,row14,column14,Gomoku.Direction.DN);
    assertEquals("Testing the numberInLine method for test Many",c14,3);
    
    /**
     * Test First,Middle and last
     */
    
    //Wrong element found on the very first step of searching in a partiucular direction
    int array15 [][] = {{5,2,3,4,1},{2,7,6,1,0},{4,5,1,9,6}};
    int row15 = 0;
    int column15 = 4;
    Gomoku g15 = new Gomoku();    
    int c15 = g15.numberInLine(array15,row15,column15,Gomoku.Direction.DN);
    assertEquals("Testing the numberInLine method for test First",c15,1);
    
    //Wrong element found in the middle of searching in a partiucular direction
    int array16 [][] = {{5,2,3,4,1},{2,7,6,1,1},{4,5,1,9,6},{49,56,11,92,1}};
    int row16 = 0;
    int column16 = 4;
    Gomoku g16 = new Gomoku();    
    int c16 = g16.numberInLine(array16,row16,column16,Gomoku.Direction.DN);
    assertEquals("Testing the numberInLine method for test Last",c16,2);
    
    //Wrong element found in the last of searching in a partiucular direction
    int array17 [][] = {{5,2,3,4,1},{2,7,6,1,1},{4,5,1,9,1},{49,56,11,92,0}};
    int row17 = 0;
    int column17 = 4;
    Gomoku g17 = new Gomoku();    
    int c17 = g17.numberInLine(array17,row17,column17,Gomoku.Direction.DN);
    assertEquals("Testing the numberInLine method for test Last",c17,3);  
        
    
    /**
     * Test for all possible directions
     */
    //Test for LDD
    int array [][] = {{5,2,3,4,1},{2,7,6,1,8},{4,5,1,9,6}};
    int row = 0;
    int column = 4;
    Gomoku g = new Gomoku();   
    int c = g.numberInLine(array,row,column,Gomoku.Direction.LDD);
    assertEquals("Testing the numberInLine method for left diagonal up direction",c,3);
    
    //Test for RDD
    int array1 [][] = {{1,2,3,4,5},{2,1,6,7,8},{4,5,1,9,6}};
    int row1 = 0;
    int column1 = 0;
    Gomoku g1 = new Gomoku();
    int c1 = g1.numberInLine(array1,row1,column1,Gomoku.Direction.RDD);
    assertEquals("Testing the numberInLine method for left diagonal down direction",c1,3);
    
    //Test for RDU
    int array2 [][] = {{5,2,3,4,1},{2,7,6,1,8},{4,5,1,9,6}};
    int row2 = 2;
    int column2 = 2;
    Gomoku g2 = new Gomoku();
    int c2 = g2.numberInLine(array2,row2,column2,Gomoku.Direction.RDU);
    assertEquals("Testing the numberInLine method for left diagonal down direction",c2,3);
    
    //Test for LDU
    int array3 [][] = {{1,20,50,40,10},{10,2,3,4,5},{2,6,1,7,8},{4,5,9,1,6}};
    int row3 = 3;
    int column3 = 3;
    Gomoku g3 = new Gomoku();
    int c3 = g3.numberInLine(array3,row3,column3,Gomoku.Direction.LDU);
    assertEquals("Testing the numberInLine method for left diagonal down direction",c3,2);
    
    //Test for LT
    int array4 [][] = {{1,20,50,40,10},{20,4,20,20,20},{2,6,1,7,8},{4,5,9,1,6}};
    int row4 = 1;
    int column4 = 4;
    Gomoku g4 = new Gomoku();
    int c4 = g4.numberInLine(array4,row4,column4,Gomoku.Direction.LT);
    assertEquals("Testing the numberInLine method for left direction",c4,3);
    
    //Test for RT
    int array5 [][] = {{1,20,50,40,10},{20,20,20,4,20},{2,6,1,7,8},{4,5,9,1,6}};
    int row5 = 1;
    int column5 = 0;
    Gomoku g5 = new Gomoku();
    int c5 = g5.numberInLine(array5,row5,column5,Gomoku.Direction.RT);
    assertEquals("Testing the numberInLine method for right direction",c5,3);
    
    //Test for UP
    int array6 [][] = {{1,20,50,40,10},{2,20,23,4,20},{2,1,1,7,8},{4,20,9,1,6}};
    int row6 = 1;
    int column6 = 1;
    Gomoku g6 = new Gomoku();
    int c6 = g6.numberInLine(array6,row6,column6,Gomoku.Direction.UP);
    assertEquals("Testing the numberInLine method for Up direction",c6,2);
  
    //Test for DN
    int array7 [][] = {{1,20,50,40,10},{2,20,23,4,20},{2,1,1,7,8},{4,20,9,1,6}};
    int row7 = 0;
    int column7 = 1;
    Gomoku g7 = new Gomoku();
    int c7 = g7.numberInLine(array7,row7,column7,Gomoku.Direction.DN);
    assertEquals("Testing the numberInLine method for down direction",c7,2);
  }
  
  @Test
  public void testIsOpen()
  {    
    
    /**
     * Test 0,1 and Many
     */
    
    //Test 0: No open space 
    int array21 [][] = {{5,2,3,4,1},{2,7,6,1,8},{4,5,10,9,6}};
    int row21 = 0;
    int column21 = 0;
    Gomoku g21 = new Gomoku();
    boolean c21 = g21.isOpen(array21,row21,column21,Gomoku.Direction.LDD);
    assertEquals("Testing the isOpen method for Test 0",c21,false);
    
    //Test 1 and Many: They will have same meaning for a boolean return statement
    int array22 [][] = {{10,2,3,4,1},{0,7,6,1,8},{0,5,10,9,6}};
    int row22 = 0;
    int column22 = 0;
    Gomoku g22 = new Gomoku();
    boolean c22 = g22.isOpen(array22,row22,column22,Gomoku.Direction.DN);
    assertEquals("Testing the isOpen method for Test Many",c22,true);
    
    /**
     * Test First,Middle and Last
     */
    
    //Test First: Open space found on first step of searching
    int array23 [][] = {{10,2,3,4,1},{0,7,6,1,8},{20,5,10,9,6}};
    int row23 = 0;
    int column23 = 0;
    Gomoku g23 = new Gomoku();
    boolean c23 = g23.isOpen(array23,row23,column23,Gomoku.Direction.DN);
    assertEquals("Testing the isOpen method for Test First",c23,true);
    
    //Test Middle: Open space found on Middle step of searching
    int array24 [][] = {{10,2,3,4,1},{10,7,6,1,8},{0,5,10,9,6},{9,2,3,4,6}};
    int row24 = 0;
    int column24 = 0;
    Gomoku g24 = new Gomoku();
    boolean c24 = g24.isOpen(array24,row24,column24,Gomoku.Direction.DN);
    assertEquals("Testing the isOpen method for Test Middle",c24,true);
    
    //Test Last: Open space found on Last step of searching
    int array25 [][] = {{10,2,3,4,1},{10,7,6,1,8},{10,5,10,9,6},{0,2,3,4,23}};
    int row25 = 0;
    int column25 = 0;
    Gomoku g25 = new Gomoku();
    boolean c25 = g25.isOpen(array25,row25,column25,Gomoku.Direction.DN);
    assertEquals("Testing the isOpen method for Test Last",c25,true);
    
    /**
     * Test for all possible directions
     */
    //Test for LDD (no open space)
    int array [][] = {{5,2,3,4,1},{2,7,6,1,8},{4,5,10,9,6}};
    int row = 0;
    int column = 0;
    Gomoku g = new Gomoku();
    boolean c = g.isOpen(array,row,column,Gomoku.Direction.LDD);
    assertEquals("Testing the isOpen method for left diagonal up direction",c,false);
    
    //Test for LDD (open space present)
    int array0 [][] = {{1,2,3,4,5},{2,1,6,5,8},{4,5,0,9,6}};
    int row0 = 0;
    int column0 = 4;
    Gomoku g0 = new Gomoku();
    boolean c0 = g0.isOpen(array0,row0,column0,Gomoku.Direction.LDD);
    assertEquals("Testing the isOpen method for left diagonal up direction",c0,true);
    
    //Test for RDD(no open space)
    int array1 [][] = {{1,2,3,4,5},{2,1,6,7,8},{4,5,1,9,6}};
    int row1 = 0;
    int column1 = 0;
    Gomoku g1 = new Gomoku();
    boolean c1 = g1.isOpen(array1,row1,column1,Gomoku.Direction.RDD);
    assertEquals("Testing the isOpen method for right diagonal down direction",c1,false);
    
    //Test for RDD (open space present)
    int array10 [][] = {{1,2,3,4,5},{2,0,6,7,8},{4,5,1,9,6}};
    int row10 = 0;
    int column10 = 0;
    Gomoku g10 = new Gomoku();
    boolean c10 = g10.isOpen(array10,row10,column10,Gomoku.Direction.RDD);
    assertEquals("Testing the isOpen method for right diagonal down direction",c10,true);
    
    //Test for RDU (no open space)   
    int array2 [][] = {{5,2,3,4,1},{2,7,6,1,8},{4,5,1,9,6}};
    int row2 = 2;
    int column2 = 2;
    Gomoku g2 = new Gomoku();
    boolean c2 = g2.isOpen(array2,row2,column2,Gomoku.Direction.RDU);
    assertEquals("Testing the isOpen method for right diagonal down direction",c2,false);
    
    //Test for RDU (open space present)
    int array20 [][] = {{5,2,3,4,0},{2,7,6,1,8},{4,5,1,9,6}};
    int row20 = 2;
    int column20 = 2;
    Gomoku g20 = new Gomoku();
    boolean c20 = g20.isOpen(array20,row20,column20,Gomoku.Direction.RDU);
    assertEquals("Testing the isOpen method for right diagonal down direction",c20,true);
    
    //Test for LDU (no open space)   
    int array3 [][] = {{1,20,50,40,10},{10,2,3,4,5},{2,6,1,7,8},{4,5,9,1,6}};
    int row3 = 3;
    int column3 = 3;
    Gomoku g3 = new Gomoku();
    boolean c3 = g3.isOpen(array3,row3,column3,Gomoku.Direction.LDU);
    assertEquals("Testing the isOpen method for left diagonal down direction",c3,false);
    
    //Test for LDU (open space present)   
    int array30 [][] = {{1,20,50,40,10},{10,2,3,4,5},{2,6,0,7,8},{4,5,9,1,6}};
    int row30 = 3;
    int column30 = 3;
    Gomoku g30 = new Gomoku();
    boolean c30 = g3.isOpen(array30,row30,column30,Gomoku.Direction.LDU);
    assertEquals("Testing the isOpen method for left diagonal down direction",c3,false);
    
    
    //Test for LT (no open space)   
    int array4 [][] = {{1,20,50,40,10},{20,4,20,20,20},{2,6,1,7,8},{4,5,9,1,6}};
    int row4 = 1;
    int column4 = 4;
    Gomoku g4 = new Gomoku();
    boolean c4 = g4.isOpen(array4,row4,column4,Gomoku.Direction.LT);
    assertEquals("Testing the isOpen method for left direction",c4,false);
    
    //Test for LT (open space present)  
    int array40 [][] = {{1,20,50,40,10},{20,4,0,20,20},{2,6,1,7,8},{4,5,9,1,6}};
    int row40 = 1;
    int column40 = 4;
    Gomoku g40 = new Gomoku();
    boolean c40 = g40.isOpen(array40,row40,column40,Gomoku.Direction.LT);
    assertEquals("Testing the isOpen method for left direction",c40,true);
    
    
    //Test for RT (no open space)   
    int array5 [][] = {{1,20,50,40,10},{20,20,20,4,20},{2,6,1,7,8},{4,5,9,1,6}};
    int row5 = 1;
    int column5 = 0;
    Gomoku g5 = new Gomoku();
    boolean c5 = g5.isOpen(array5,row5,column5,Gomoku.Direction.RT);
    assertEquals("Testing the isOpen method for right direction",c5,false);
    
    //Test for RT (open space present)   
    int array50 [][] = {{1,20,50,40,10},{20,20,20,0,20},{2,6,1,7,8},{4,5,9,1,6}};
    int row50 = 1;
    int column50 = 0;
    Gomoku g50 = new Gomoku();
    boolean c50 = g50.isOpen(array50,row50,column50,Gomoku.Direction.RT);
    assertEquals("Testing the isOpen method for right direction",c50,true);
    
    //Test for UP (no open space) 
    int array6 [][] = {{1,20,50,40,10},{2,20,23,4,20},{2,20,1,7,8},{4,20,9,1,6}};
    int row6 = 3;
    int column6 = 1;
    Gomoku g6 = new Gomoku();
    boolean c6 = g6.isOpen(array6,row6,column6,Gomoku.Direction.UP);
    assertEquals("Testing the numberInLine method for Up direction",c6,false);
    
   //Test for UP (open space present) 
    int array60 [][] = {{1,0,50,40,10},{2,20,23,4,20},{2,20,1,7,8},{4,20,9,1,6}};
    int row60 = 3;
    int column60 = 1;
    Gomoku g60 = new Gomoku();
    boolean c60 = g60.isOpen(array60,row60,column60,Gomoku.Direction.UP);
    assertEquals("Testing the isOpen method for Up direction",c60,true);
  
    //Test for DN (no open space) 
    int array7 [][] = {{1,20,50,40,10},{2,20,23,4,20},{2,1,1,7,8},{4,20,9,1,6}};
    int row7 = 0;
    int column7 = 1;
    Gomoku g7 = new Gomoku();
    boolean c7 = g7.isOpen(array7,row7,column7,Gomoku.Direction.DN);
    assertEquals("Testing the numberInLine method for down direction",c7,false);
    
    //Test for DN (open space present) 
    int array70 [][] = {{1,20,50,40,10},{2,20,23,4,20},{2,0,1,7,8},{4,20,9,1,6}};
    int row70 = 0;
    int column70 = 1;
    Gomoku g70 = new Gomoku();
    boolean c70 = g70.isOpen(array70,row70,column70,Gomoku.Direction.DN);
    assertEquals("Testing the numberInLine method for down direction",c70,true);    
    
  }
  @Test
  public void testCheckLessThanStrike()
  {
    //When all conditions gets false
    int array[][] = {{10,20,0,0,0},{20,0,0,0,0}};
    int row70 = 0;
    int column70 = 1;
    Gomoku g70 = new Gomoku();
    g70.setBoard(array);
    boolean c70 = g70.checkLessThanStrike(row70,column70);
    assertEquals("Testing the checkLessThanStrike method",c70,false); 
    
    //When condition gets true for one direction (any)
    int array71[][] = {{10,10,10,0},{20,0,0,0,0}};
    int row71 = 0;
    int column71 = 3;
    Gomoku g71 = new Gomoku();
    g71.setBoard(array71);
    boolean c71 = g71.checkLessThanStrike(row71,column71);
    assertEquals("Testing the checkLessThanStrike method",c71,false); 
    
    //When condition gets true for two direction (any)
    int array72[][] = {{10,10,10,10},{0,0,0,10},{0,0,0,10},{0,0,0,10}};
    int row72 = 0;
    int column72 = 3;
    Gomoku g72 = new Gomoku();
    g72.setBoard(array72);
    boolean c72 = g72.checkLessThanStrike(row72,column72);
    assertEquals("Testing the checkLessThanStrike method",c72,true); 
    
    //When condition gets true for more than two direction (any)
    int array73[][] = {{10,10,10,10},{0,0,10,10},{0,10,0,10},{10,0,0,10}};
    int row73 = 0;
    int column73 = 3;
    Gomoku g73 = new Gomoku();
    g73.setBoard(array73);
    boolean c73 = g73.checkLessThanStrike(row73,column73);
    assertTrue("Testing the checkLessThanStrike method",c73);     
  }
  
  @Test
  public void testCheckTwoLessThanStrike()
  {
    /**
     * All conditions get false
     */
    
    //When all conditions gets false
    int array[][] = {{10,20,0,0,0},{20,0,0,0,0}};
    int row70 = 0;
    int column70 = 1;
    Gomoku g70 = new Gomoku();
    g70.setBoard(array);
    boolean c70 = g70.checkTwoLessThanStrike(row70,column70);
    assertEquals("Testing the checkTwoLessThanStrike method",c70,false); 
    
    //When all conditions gets false (left statement gets true and right statement gets false of &&)
    int array1[][] = {{10,10,10,0,0},{20,0,0,0,0}}; //No open space available on all 4 sides
    int row71 = 0;
    int column71 = 2;
    Gomoku g71 = new Gomoku();
    g71.setBoard(array1);
    boolean c71 = g71.checkTwoLessThanStrike(row71,column71);
    assertEquals("Testing the checkTwoLessThanStrike method",c71,false); 
    
    /**
     * All condition gets false except one
     */    
    
    //3 same pieces and Open space available for 10 at (1,3) position
    int array2[][] = {{0,0,0,0,0},{0,10,10,10,0,0},{20,0,0,0,0}};
    int row2 = 1;
    int column2 = 3;
    Gomoku g2 = new Gomoku();
    g2.setBoard(array2);
    boolean c2 = g2.checkTwoLessThanStrike(row2,column2);
    assertEquals("Testing the checkTwoLessThanStrike method",c2,false);
    
    /**
     * Two conditions get true
     */  
    //3 same pieces available on second row and fourth column along with open space on all four sides
    int array3[][] = {{0,0,0,0,0},{0,10,10,10,0,0},{20,0,0,10,0},{20,0,0,10,0},{20,0,0,0,0}};
    int row3 = 1;
    int column3 = 3;
    Gomoku g3 = new Gomoku();
    g3.setBoard(array3);
    boolean c3 = g3.checkTwoLessThanStrike(row3,column3);
    assertEquals("Testing the checkTwoLessThanStrike method",c3,true);
    
    /**
     * More than Two conditions get true
     */  
    
    //
    int array73[][] = {{0,0,0,0,0},{0,10,10,10,0},{0,0,10,10,0},{0,10,0,10,0},{0,0,0,0,0}};
    int row73 = 1;
    int column73 = 3;
    Gomoku g73 = new Gomoku();
    g73.setBoard(array73);
    boolean c73 = g73.checkTwoLessThanStrike(row73,column73);
    assertEquals("Testing the checkTwoLessThanStrike method",c73,true);    
  }
  
  /**
   * Tests the getter and setter methods of playerCounter field
   * Tests the getter and setter methods of board field
   */
  @Test
  public void testButtonIsPressed()
  {
    //playerCounter = 0. Hence white player plays
    int array73[][] = {{0,0,0,0,0},{0,10,10,10,0},{0,0,10,10,0},{0,10,0,10,0},{0,0,0,0,0}};
    int row73 = 0;
    int column73 = 3;
    Gomoku g73 = new Gomoku();
    g73.setBoard(array73);
    g73.buttonIsPressed(row73,column73);
    
    int arrayFinal[][] = {{0,0,0,10,0},{0,10,10,10,0},{0,0,10,10,0},{0,10,0,10,0},{0,0,0,0,0}};
    assertArrayEquals("Test ButtonIsPressed method",arrayFinal,g73.getBoard());
    
    //playerCounter = 1. Hence black player plays
    g73.setPlayerCounter(g73.getPlayerCounter() + 1);
    int row74 = 0;
    int column74 = 1;    
    g73.buttonIsPressed(row74,column74);
    
    int arrayFinal2[][] = {{0,20,0,10,0},{0,10,10,10,0},{0,0,10,10,0},{0,10,0,10,0},{0,0,0,0,0}};
    assertArrayEquals("Test ButtonIsPressed method",arrayFinal2,g73.getBoard());
  }
  
  @Test
  public void testIsEmpty()
  {
    int array73[][] = {{0,0,0,0,0},{0,10,10,10,0},{0,0,10,10,0},{0,10,0,10,0},{0,0,0,0,0}};    
    Gomoku g73 = new Gomoku();
    g73.setBoard(array73);
    
    //The position is empty
    assertEquals("Tests isEmpty method",true,g73.isEmpty(0,0));
    
    //The position is non-empty
    assertEquals("Tests isEmpty method",false,g73.isEmpty(1,1));
  }
  
  //Tests getter and setter methods of isWinner field
  @Test 
  public void testIsWinner()
  {
    //There is a winner in a particular direction
    int array73[][] = {{0,0,0,0,0},{10,10,10,10,10},{0,0,10,10,0},{0,10,0,10,0},{0,0,0,0,0}};    
    Gomoku g73 = new Gomoku();
    g73.setBoard(array73);
    g73.isWinner(array73,1,0,'w');
    assertEquals("Testing isWinner method",'w',g73.getIsWinner());
    
    //There is no winner in any particular direction
    int array74[][] = {{0,0,0,0,0},{10,20,10,10,10},{0,0,10,10,0},{0,10,0,10,0},{0,0,0,0,0}};    
    Gomoku g74 = new Gomoku();
    g74.setBoard(array74);
    g74.isWinner(array74,1,0,'w');
    assertEquals("Testing isWinner method",'c',g74.getIsWinner());
  }
    
                 
    
    
    
    
    
    
}