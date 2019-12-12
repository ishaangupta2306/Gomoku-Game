import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.geometry.Insets;
import java.util.*;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.geometry.Insets;

/** 
 * A Class representing Gomoku Game
 * @author Ishaan Gupta
 */
public class Gomoku extends Application {
  //Stores address of stage
  private Stage stage;
  //Stores address of borderPane
  private BorderPane pane;
  //Stores address of Scene
  private Scene scene;
  //Stores address of textArea
  private TextArea warningMessage;
  //Stores number of rows of the board
  private int rows ;
  //Stores number of columns of the board
  private int columns ;  
  //Stores address of Integer array of board
  private int board[][]; 
  //Stores address of array of button
  private Button buttonS[][];
  //Stores value of spacing on the GUI board
  private int spacing = 40;
  //Tracks which player is playing
  private int playerCounter = 0;
  //Tracks the winner
  private char isWinner = 'c';
  //Tracks the number of rows to win 
  private int strike = 5;
  //Field used for background of board
  private static BackgroundFill baseBackground = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY,new Insets(1,1,1,1));
  //Field used for background of White player
  private static BackgroundFill fillWhite = new BackgroundFill(Color.WHITE, new CornerRadii(50),new Insets(5,5,5,5));
  //Field used for background of black player
  private static BackgroundFill fillBlack = new BackgroundFill(Color.BLACK, new CornerRadii(50),new Insets(5,5,5,5));
  //Field used as text area for game
  private TextArea text;
  
  /**
   * Represents the 8 directions on the board   
   * Left,right,up,down,Left diagonal up, right diagonal up, left diagonal down,right diagonal down
   */
  public enum Direction{LT,RT,UP,DN,LDU,RDU,LDD,RDD};
  
  /** 
   * Overrides the start method of Application to create the GUI of the Gomoku game
   * @param primaryStage the JavaFX main window
   */
  public void start(Stage primaryStage) 
  {
    //Local variable to store the list of parameters
    List<String> list = getParameters().getRaw();
    //Local variable to store the iterator of list
    Iterator<String> listIterator = list.listIterator();    
    //Local variable to store the content of the list
    int array[] = new int[4];
    //Local variable used a counter
    int k = 0;
  
    try{  
      //Looping over the elements stored in list
     while(listIterator.hasNext())
      {
        array[k] = Integer.parseInt(listIterator.next());   
        k++;
     }
     //When user passes the number required in a row to win
     if(array[2] != 0)
     {
       if(! (array[0] >= 5))
       {
         System.out.println("Number for winning can't be less than 5 " );
         throw new ArrayIndexOutOfBoundsException();
       }
       else{
       strike = array[0];
       rows = array[1];
       columns = array[2];
       System.out.println("Launching the game with row = " + rows + " columns = " + columns + " and number for winning = " + strike);
       }
     }
     //When user only passes the number of rows and columns
     else if(array[1] != 0)
     {
       strike = 5;
       rows = array[0];
       columns = array[1];
       System.out.println("Launching the game with row = " + rows + " columns = " + columns + " and number for winning = " + strike);
     }
     //When user passes no input
     else
     {
       strike = 5;
       rows = 19;
       columns = 19;
       System.out.println("Launching the game with default values");
     }      
    }
    catch(ArrayIndexOutOfBoundsException a)
    {
      System.out.println("Invalid input....play with default board!");
      strike = 5;
      rows = 19;
      columns = 19;
    }
    catch(NumberFormatException n)
    {
      System.out.println("Invalid input....play with default board!");
      strike = 5;
      rows = 19;
      columns = 19;
    }
    
    //Initialization of board array
    board = new int[rows][columns];
    //Initialization of button array
    buttonS = new Button [rows][columns];
    //Initialization of border pane
    pane = new BorderPane();
    
    //-------------------------------------------Extra Credit-----------------------------------------------------
    //Initialization of starting button
    Button buttonStart = new Button("Fun is just one Click away");
    
    //Anonymous class for handle method of starting button
    buttonStart.setOnAction( a -> { 
                                     //Initialization of GridPane
                                     GridPane gridPane = new GridPane();
                                     
                                     //Initialization of the array of buttons 
                                     this.buttonS = new Button[rows][columns];
                                     
                                     /**
                                      * Loop to iterate through the array of buttons
                                      * Sets the background
                                      * Sets Min and Max width
                                      * Puts the buttons on GridPane
                                      * Finally,makes each button clickable
                                      */
                                   for(int i = 0; i< rows; i++)
                                     for(int j=0;j < columns; j++)
                                   {
                                       buttonS[i][j] = new Button();      
                                       buttonS[i][j].setBackground(new Background(baseBackground));
                                       buttonS[i][j].setMinWidth(spacing);
                                       buttonS[i][j].setMinHeight(spacing);
                                       gridPane.add(buttonS[i][j], i+1, j+1);        
                                       buttonS[i][j].setOnAction(new ButtonAction());   
                                   }
                                   //Local variable to append string on textArea
                                   String sen = "WELCOME!\n";
                                   //Initialization of textArea
                                   text = new TextArea(sen);                                   
                                   //Font of text set
                                   text.setFont(new Font(30));                                  
                                   text.setBackground(new Background(new BackgroundImage(new Image("/Sketchpad.png",true),2,1,3),BackgroundFill(Color.YELLOW,new CornerRadii(100),new Insets(100))));
                                   text.setBackground(new Background(new BackgroundFill(Color.YELLOW,new CornerRadii(100),new Insets(100))));
                                   //textArea placed on right of game
                                   pane.setRight(text);
                                   //Game(gridPane) placement
                                   pane.setLeft(gridPane);
                                   stage = primaryStage;      
                                   stage.setTitle("GOMOKU player vs Computer"); 
                                   // Create a "scene" that contains this border area 
                                   Scene scene = new Scene(pane);   
                                   // Add the "scene" to the main window   
                                   stage.setScene(scene);          
                                   //Stage is presented
                                   stage.show();
                                   
                                   });
     //Scene of start button
     Scene startScene = new Scene(buttonStart);
     stage = primaryStage;
     // Add the "scene" to the main window   
     stage.setScene(startScene);
     //Stage is presented
     stage.show();
     //-----------------------------------------------------------------------------------------------------------
    
  }
   
  /**
   * Class for Making button do some action
   * @author Ishaan Gupta
   */
  public class ButtonAction implements EventHandler<ActionEvent> 
  {   
    char ch; 
    //Method overriden to perform action on button click
    public void handle(ActionEvent e)
    {
      //Local variable to store the address of the clicked button
      Button b = (Button)e.getSource(); 
      //Checks if none is a winner
      if(getIsWinner()!= 'w' && getIsWinner() != 'b')
      {
        //Loop to find the clicked button
        for(int i = 0; i < rows; i++)
          for(int j = 0; j < columns; j++) 
          //Checks if the found button is not already clicked
          if(b == buttonS[i][j] && isEmpty(i,j))  
        {          
          buttonIsPressed(i,j);
          
          //Checks the condition for four-four and three-three rule
          if(checkLessThanStrike(i,j) == true || checkTwoLessThanStrike(i,j)== true)
          {
            board[i][j] = 0;
            if(checkLessThanStrike(i,j) == true)
              showMove(4);
            else 
              showMove(3);
            
          }
          
          //Executes if all rules followed
          else{
            showMove(0);
            //If player is Black
            if(playerCounter % 2 == 0)
            {
              b.setBackground(new Background(baseBackground,fillBlack));
              playerCounter++;
              isWinner(board,i,j,'b');  
                
              if(getIsWinner() != 'c')        
                showWinner();
              
            }
            //Player is White
            else
            {
              b.setBackground(new Background(baseBackground,fillWhite));
              playerCounter++;
              isWinner(board,i,j,'w');   
                
              if(getIsWinner() != 'c')        
                showWinner();
            }         
          }
        }
      }  
     
    }
  }
  
  /**
   * Helper method to put the value in Integer array where button is clicked
   * @param buttonRow row position of button
   * @param buttonColumn column position of button
   */
  public void buttonIsPressed(int buttonRow, int buttonColumn)
  {
   
    if(playerCounter % 2 == 0)
      board[buttonRow][buttonColumn] = 10;  //B
    else
      board[buttonRow][buttonColumn] = 20;  //W    
  }
  
  
  /**
   * Helper method to check if the button isn't already clicked
   * @param buttonRow row position of button
   * @param buttonColumn column position of button
   * @return boolean true: if not clicked else false returned
   */
  public boolean isEmpty(int buttonRow, int buttonColumn)
  {    
     if(board[buttonRow][buttonColumn] == 0)    
       return true;    
     return false;
  }
  
  
   /**
    * Helper method to determine the number of pieces in a particular direction of same color
    * @param array integer array for buttons
    * @param buttonRow row position of button
    * @param buttonColumn column position of button
    * @param direction Direction to go in
    * @return int number of pieces including the piece 
    */
   public int numberInLine(int array[][],int buttonRow,int buttonColumn,Direction direction)
   {
     //Local variable used as counter
     int count = 1; 
     //Local variables used to change rows and columns according to direction
     int x = 0,y = 0;         
     //Local variable storing the number of rows of array
     int maxRow = array.length;
     //Local variable storing the number of columns of array
     int maxColumn = array[0].length;
     
     //Initialization of declared variables according to the direction
     switch(direction)
     {
       case LDU: x = -1; y = -1; break;
       case RDU: x = -1; y = 1; break;
       case LDD: x =  1; y = -1; break;
       case RDD: x =  1; y = 1; break;
       case LT : x =  0; y = -1; break;
       case RT : x = 0; y = 1; break;
       case UP : x = -1; y = 0;break;
       case DN : x =  1; y = 0; break;       
     }
     //Local Variable storing the element to be searched
     int temp = array[buttonRow][buttonColumn]; 
     //Local Variable used as flag
     char flag = 'y';
     //Local variables used to increase/decrease to go in the particular direction
     int x1 = x, y1 = y;
     
     //Loop to move in particular direction till you encounter a different piece/ space
     while(flag == 'y')
     {
       //Check to make sure movement within the array
       if(buttonRow + x > -1 && buttonColumn + y > -1)
       {
         //Check to make sure movement within the array
         if(buttonRow + x < maxRow && buttonColumn + y < maxColumn)
         {
           //Checking of the number being searched
           if(temp == array[buttonRow + x][buttonColumn + y])
           {      
             count++;
             x += x1;
             y += y1;
           }
       
           else
             //Changing of flag to exit loop
             flag = 'f';
         }
         else
           //Changing of flag to exit loop
             flag = 'f';
       }
       else
         //Changing of flag to exit loop
         flag = 'f';
     }      
     //Return the number of pieces found
     return count;    
    
   }
   
   /**
    * Helper method to determine presence open spaces in a particular direction of same color
    * @param array integr array of buttons
    * @param buttonRow row position of button
    * @param buttonColumn column position of button
    * @param direction Direction to go in
    * @return boolean found or not found 
    */
   public boolean isOpen(int array[][],int buttonRow,int buttonColumn,Direction direction)
   {
     //Local variable used as counter
     int count = 1; 
     //Local variables used to change rows and columns according to direction
     int x = 0,y = 0;         
     //Local variable storing the number of rows of array
     int maxRow = array.length;
     //Local variable storing the number of columns of array
     int maxColumn = array[0].length;
    
     //Initialization of declared variables according to the direction
     switch(direction)
     {
       case LDU: x = -1; y = -1; break;
       case RDU: x = -1; y = 1; break;
       case LDD: x =  1; y = -1; break;
       case RDD: x =  1; y = 1; break;
       case LT : x =  0; y = -1; break;
       case RT : x = 0; y = 1; break;
       case UP : x = -1; y = 0;break;
       case DN : x = 1; y = 0; break;       
     }
     
     //Local Variable storing the element to be searched
     int temp = array[buttonRow][buttonColumn]; 
     //Local Variable used as flag
     char flag = 'y';
     //Local variables used to increase/decrease to go in the particular direction
     int x1 = x, y1 = y;     
     
     //Loop to move in particular direction till you encounter a piece/ space
     while( flag == 'y')
     {
       //Check to make sure movement within the array
       if(buttonRow + x > -1 && buttonColumn + y > -1)
       {
         //Check to make sure movement within the array
         if(buttonRow + x < maxRow && buttonColumn + y < maxColumn)
         {
           //Comparison of the number being searched
           if(temp == array[buttonRow + x][buttonColumn + y])
           { 
             x += x1;
             y += y1;
           }
           //Open space found
           else if(array[buttonRow + x][buttonColumn + y] == 0)
             flag = 't';
           
           else
             //Changing of flag to exit loop
             flag = 'f';
         }
         else
           //Changing of flag to exit loop
           flag = 'f';
       }
       else
         //Changing of flag to exit loop
         flag = 'f';
     }
     //Space found...return true
     if(flag == 't')
       return true;    
     return false;
   }
   
   /**
    * Helper method to determine the winner
    * @param array integer array board 
    * @param buttonRow row position of button
    * @param buttonColumn column position of button
    * @param winner name of the winner
    */
   public void isWinner(int array[][],int buttonRow,int buttonColumn, char winner)
   {
      
     if(numberInLine(array,buttonRow,buttonColumn,Direction.LT) + numberInLine(array,buttonRow,buttonColumn,Direction.RT) == strike +1)
       setIsWinner(winner); 
     
     else if(numberInLine(array,buttonRow,buttonColumn,Direction.UP) + numberInLine(array,buttonRow,buttonColumn,Direction.DN) == strike + 1)
       setIsWinner(winner);     
     
     else if(numberInLine(array,buttonRow,buttonColumn,Direction.LDU) + numberInLine(array,buttonRow,buttonColumn,Direction.RDD)== strike + 1)
       setIsWinner(winner);     
     
     else if(numberInLine(array,buttonRow,buttonColumn,Direction.RDU) + numberInLine(array,buttonRow,buttonColumn,Direction.LDD)== strike + 1)
       setIsWinner(winner);
     
   }
   
   /**
    * Getter Method for isWinner field
    * @return char isWinner
    */
   public char getIsWinner()
   {
     return isWinner;
   }
   
   /**
    * Setter method for isWinner field
    * @param winner  the character denoting the player
    */
   public void setIsWinner(char winner)
   {
     isWinner = winner;
   }
   
   /**
    * Helper method to check the four-four rule(specifically one less than number of same pieces needed in a row to win)
    * @param buttonRow Row Position of the button
    * @param buttonColumn Column Position of the button
    * @return boolean descripting rule holds true or not
    */
   public boolean checkLessThanStrike(int buttonRow, int buttonColumn)
   {
     //Local variable to store the one less than number of same pieces needed in a row to win
     int temp = strike - 1;
     //Local Variable used as counter
     int counter = 0;     
     //Condition checking number of same pieces in a row in all four directions
     if(numberInLine(board,buttonRow,buttonColumn,Direction.LT) + numberInLine(board,buttonRow,buttonColumn,Direction.RT) == strike)
       counter++;
     if(numberInLine(board,buttonRow,buttonColumn,Direction.UP) + numberInLine(board,buttonRow,buttonColumn,Direction.DN) == strike)
       counter++;
     if(numberInLine(board,buttonRow,buttonColumn,Direction.RDD) + numberInLine(board,buttonRow,buttonColumn,Direction.LDU) == strike)
       counter++;
     if(numberInLine(board,buttonRow,buttonColumn,Direction.RDU) + numberInLine(board,buttonRow,buttonColumn,Direction.LDD) == strike)
       counter++;
 
     //If two or more than such rows found
     if(counter >= 2)
       return true;
     return false;
   }
   
   /**
    * Helper method to check the three-three rule(specifically two less than number of same pieces needed in a row to win)
    * @param buttonRow Row Position of the button
    * @param buttonColumn Column Position of the button
    * @return boolean descripting rule holds true or not
    */
   public boolean checkTwoLessThanStrike(int buttonRow, int buttonColumn)
   {
     //Local variable to store the two less than number of same pieces needed in a row to win
     int temp = strike - 2;
     //Local Variable used as counter
     int counter = 0;
    
     //Condition checking number of same pieces in a row and availability of open spaces in all four directions
     if(numberInLine(board,buttonRow,buttonColumn,Direction.UP) + numberInLine(board,buttonRow,buttonColumn,Direction.DN) -1 == temp && isOpen(board,buttonRow,buttonColumn,Direction.UP) == true && isOpen(board,buttonRow,buttonColumn,Direction.DN) == true)
       counter++;
     if(numberInLine(board,buttonRow,buttonColumn,Direction.LT) + numberInLine(board,buttonRow,buttonColumn,Direction.RT) -1 == temp && isOpen(board,buttonRow,buttonColumn,Direction.LT) == true && isOpen(board,buttonRow,buttonColumn,Direction.RT) == true)
       counter++;
     if(numberInLine(board,buttonRow,buttonColumn,Direction.LDD) + numberInLine(board,buttonRow,buttonColumn,Direction.RDU) -1 == temp && isOpen(board,buttonRow,buttonColumn,Direction.LDD) == true && isOpen(board,buttonRow,buttonColumn,Direction.RDU) == true)
       counter++;
     if(numberInLine(board,buttonRow,buttonColumn,Direction.LDU) + numberInLine(board,buttonRow,buttonColumn,Direction.RDD) -1 == temp && isOpen(board,buttonRow,buttonColumn,Direction.LDU) == true && isOpen(board,buttonRow,buttonColumn,Direction.RDD) == true)
       counter++;
    
     
     //If two or more than such rows found
     if(counter >= 2)
       return true;
     return false;
   }
   
    /**
    * Setter method for integer board field
    * @param array  new integer 2d array
    */
   public void setBoard(int array[][])
   {
     board = array;
   }
   
   /**
    * Getter method for integer board field
    * @return int[][] integer 2d array
    */
   public int[][] getBoard()
   {
     return board;
   }
   
   /**
    * Getter method for playerCounter field
    * @return int playerCounter
    */
   public int getPlayerCounter()
   {
     return playerCounter;
   }
   
   /**
    * Setter method for playerCounter field
    * @param counter new value of playerCounter
    */
   public void setPlayerCounter(int counter)
   {
     playerCounter = counter;
   }
   
    //-------------------------------------------Extra Credit-----------------------------------------------------
   /**
    * Method to show the winner on the textArea of game
    */
   public void showWinner()
   {
     //Local variable used to store string and append on textArea
     String sen = "";
     
     //If white player is the winner
     if(getIsWinner() == 'w')    
       sen = "Congratulations WHITE PLAYER....You Nailed it";
    
     //If black player is the winner
     else 
       sen = "Congratulations Black PLAYER....You Nailed it";
     
     text.appendText("\n\n\n"+sen);  
     
   }
    //-----------------------------------------------------------------------------------------------------------
   
    //-------------------------------------------Extra Credit-----------------------------------------------------
   /**
    * Method to show the violation of any rule on the textArea of game
    * @param condition Number denoting the rule (three-three or four-four)
    */
   public void showMove(int condition)
   {
     //Local variable used to store string and append on textArea
     String sen = "";     
     
     //violation of four-four rule
     if(condition == 4)       
     {
       sen = "Violating rule....Play another move";
       text.appendText("\n\n\n" + sen);       
     }
     
     //violation of three-three rule
     else if (condition == 3) 
     {
       sen = "Violating rule....Play another move";
       text.appendText("\n\n\n" + sen);         
     }
     
     //no violation
     else if(condition == 0) 
     {
       text.setText("WELCOME!");      
       text.setFont(new Font(30));
       
     }
   }
    //-----------------------------------------------------------------------------------------------------------
   
   
   
   /**
    * The method to launch the program.
    * @param args  The command line arguments.  The arguments are passed on to the JavaFX application.
    */
   public static void main(String[] args) 
   {
     Application.launch(args);
   }
}