
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author Michael Gunn
 */
public class GameBoard {
    private char[][] gameBoard;
    private boolean gameOnGoing = true;
    
    public GameBoard(){
        gameBoard = new char [3][3];
        
        for (int row=0; row<gameBoard.length; row++){
            Arrays.fill(gameBoard[row], ' ');
        }
    } 
    
    //This Method Displays the gameboard 
    public void displayBoard (){
        for (int row=0; row<gameBoard.length; row++){
            for (int col=0; col < gameBoard[0].length; col++) {
                System.out.print("\t" +gameBoard[row][col]);
                if (col==0 || col==1){
                    System.out.print("|");
                }
            }
            if (row==0 || row==1){
                System.out.println("\n-------------------------------\n");
            }
        }
        System.out.println();
    }
    
    //This Method will check if a players move is allowed
    //and return true if the move was completed
    public boolean makeMove (char player, int row, int col){
        if (row>=0 && row<=2 && col>=0 && col<=2){
            if (gameBoard[row][col] != ' '){
                return false;
            }
            else{
                gameBoard[row][col] = player;
                return true;
            }
        }
        
        else
            return false;
    }
    
    //this method will return true if the game is still active
    public boolean gameActive(){
        return gameOnGoing;
    }
    
    //Checks if the input place is empty
    public boolean isEmpty (int row, int col){
        if (gameBoard[row-1][col-1]==' ')
            return true;
        else{
            System.out.print("That position is take.\n");
            return false;
        }
    }
    
    //this method will ask the user to pick a row and column
    //validate the inputs and call the method makeMove()
    public void askPlayer (char player){
        Scanner keyboard = new Scanner (System.in);
        int row;
        int col;
        do{
            System.out.printf ("Player %s please enter a row (1-3) : ", player);
            row = keyboard.nextInt();
            
            System.out.printf ("Player %s please enter a column (1-3): ", player);
            col = keyboard.nextInt();
            
        } while (notValid(row,col));
        
        makeMove (player,row-1,col-1);
    }
    
    //This method will validate if the row and column are between 1-3
    //and if the position is curently empty
    public boolean notValid(int row, int col){
        if (row>3 || row<1 || col>3 || col<1 || !isEmpty (row,col))
            return true;
     
        else
            return false;
    }
    
    //this method will check to see if there are 3 x's or 0's in a row
    //and return true if there is a winner, false otherwise
    
    public boolean checkForWinner(){
        //loop over each row and check for a winner
        for (int row=0; row<gameBoard.length; row++){
            if (gameBoard [row][0]==gameBoard[row][1]&& gameBoard[row][1]==gameBoard[row][2]
                    &&gameBoard[row][0]!=' '){
                System.out.print("The winner is " + gameBoard[row][0]+"\n");
                gameOnGoing=false;
            }
        }
        //loop over columns
        for (int col=0; col<gameBoard[0].length; col++){
            if (gameBoard [0][col]==gameBoard[1][col]&& gameBoard[1][col]==gameBoard[2][col]
                    &&gameBoard[0][col]!=' '){
                System.out.print("The winner is "+gameBoard[0][col]+"\n");
                gameOnGoing=false;
            }
        }
        
        //check the diagonals
        if (gameBoard[0][0]==gameBoard[1][1] && gameBoard [1][1]== gameBoard[2][2] &&gameBoard[1][1]!=' '){
            System.out.print("The winner is "+gameBoard[0][0]+"\n");
            gameOnGoing=false;
        }
        
        if (gameBoard[2][0]==gameBoard[1][1] && gameBoard [1][1]== gameBoard[0][2] &&gameBoard[0][2]!=' '){
            System.out.print("The winner is "+gameBoard[2][0]+"\n");
            gameOnGoing=false;
        }
        return false;
        
    }

}

