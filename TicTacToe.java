import java.util.Scanner;
 
public class TicTacToe 
{
  public static final int BOARD_SIZE = 3;
  public static final char X_SYMBOL = 'X';
  public static final char O_SYMBOL = 'O';
  public static char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
  public static char currentPlayerSymbol;
  public static Scanner scanner = new Scanner(System.in);
 
  public static void main(String[] args) 
  {
    initGame();
    do {
      printBoard();
      makeMove();
      switchPlayer();
    } 
    while (!isGameOver());
    printBoard();
    announceWinner();
  }
 
  public static void initGame() 
  {
    for (int i=0; i<BOARD_SIZE; i++) {
      for (int j=0; j<BOARD_SIZE; j++) {
        board[i][j] = '-';
      }
    }
     currentPlayerSymbol = X_SYMBOL;
 
    System.out.println("Game started! Player " + currentPlayerSymbol + " goes first.");
  }
 
  public static void printBoard() 
  {
    for (int i=0; i<BOARD_SIZE; i++) {
      for (int j=0; j<BOARD_SIZE; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
 
  public static void makeMove() 
  {
    System.out.println("Player " + currentPlayerSymbol + " enter a row and column to place your mark:");
    int row = scanner.nextInt() - 1;
    int col = scanner.nextInt() - 1;
 
    while (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE || board[row][col] != '-') {
      System.out.println("Invalid input, please try again:");
      row = scanner.nextInt() - 1;
      col = scanner.nextInt() - 1;
    }
 
    board[row][col] = currentPlayerSymbol;
  }
 
  public static void switchPlayer() 
  {
    if (currentPlayerSymbol == X_SYMBOL)
      currentPlayerSymbol = O_SYMBOL;
    else
      currentPlayerSymbol = X_SYMBOL;
  }
 
  public static boolean isGameOver() 
  {
    if (hasWon(X_SYMBOL)) 
    {
      System.out.println("Player X has won!");
      return true;
    }
    else if (hasWon(O_SYMBOL)) 
    {
      System.out.println("Player O has won!");
      return true;
    }
    else if (isDraw()) 
    {
      System.out.println("Draw!");
      return true;
    }
    return false;
  }
 
  public static boolean hasWon(char symbol) 
  {
    for (int i=0; i<BOARD_SIZE; i++) 
    {
      if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
        return true;
    }

    for (int j=0; j<BOARD_SIZE; j++) 
    {
      if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol)
        return true;
    }
 
    if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
      return true;
    if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
      return true;
 
    return false;
  }
 
  public static boolean isDraw() 
  {
    for (int i=0; i<BOARD_SIZE; i++) {
      for (int j=0; j<BOARD_SIZE; j++) {
        if (board[i][j] == '-')
          return false;
      }
    }
    return true;
  }
 
  public static void announceWinner() 
  {
    if (hasWon(X_SYMBOL))
      System.out.println("Player X has won!");
    else if (hasWon(O_SYMBOL))
      System.out.println("Player O has won!");
    else
      System.out.println("It's a draw!");
  }
 
}