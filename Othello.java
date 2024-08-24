import java.util.*;

public class Othello {

  public static void main(String[] args) {

    // Board board = new Board();
    // AIPlayer AI = new AIPlayer(1);
    // Player player = new Player(-1);
    //
    // board.printBoard();
    //
    // player.updatePossibleMoves(board);
    // player.placeTile(board, player.getPossibleMoves().get(0));
    //
    // board.printBoard();
    //
    // AI.updatePossibleMoves(board);
    //
    // for (Square square : AI.getPossibleMoves()) {
    //   AI.negaMax(square, board, 10, AI.getColor());
    // }

    Board board = new Board();

    Scanner console = new Scanner(System.in);
    System.out.println("Choose color: White (1) or Black (-1)");
    int playerColor = console.nextInt();

    Player player = new Player(playerColor);
    AIPlayer computer = new AIPlayer(-playerColor);

    board.printBoard();

    while (!board.isFull()) {

      if (computer.getColor() == -1) {
        computer.updatePossibleMoves(board);
        Square bestTile = computer.findBestMove(board);
        computer.placeTile(board, bestTile.getRow(), bestTile.getColumn());
        System.out.println("After computer's move:");
        board.printBoard();
      }

      player.updatePossibleMoves(board);
      System.out.println("Pick a tile from these options:");
      for (Square square : player.getPossibleMoves()) {
        System.out.print("(" + (square.getRow() + 1) + ", " + (square.getColumn() + 1) + ") ");
      }
      System.out.print("\nRow (1-8): ");
      int tileRow = console.nextInt() - 1;
      System.out.print("Column (1-8): ");
      int tileColumn = console.nextInt() - 1;
      player.placeTile(board, tileRow, tileColumn);
      board.printBoard();

      if (computer.getColor() == 1) {
        computer.updatePossibleMoves(board);
        Square bestTile = computer.findBestMove(board);
        computer.placeTile(board, bestTile.getRow(), bestTile.getColumn());
        System.out.println("\nAfter computer's move:");
        board.printBoard();
      }

    }



  }
}
