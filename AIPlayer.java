import java.util.*;
import java.lang.Math;

public class AIPlayer extends Player {

  public AIPlayer(int color) {
    super(color);
  }

  public int negaMax(Square square, Board board, int depth, int color) {
    Player player = new Player(this.color);
    if (depth == 0 || board.isFull()) {
      return color * square.getScore();
    } else {
      int value = -this.color * 10;
      Board newBoard = new Board(board.getSquares());
      int yield = placeTile(newBoard, square.getRow(), square.getColumn());
      player.updatePossibleMoves(newBoard);
      ArrayList<Square> currentMoves = player.getPossibleMoves();
      for (Square childSquare : currentMoves) {
        value = Math.max(value, -negaMax(childSquare, newBoard, depth - 1, -color));
      }
      return this.color * yield + value;
    }
  }

  public Square findBestMove(Board board) {
    int best = 0;
    for (int i = 1; i < this.possibleMoves.size(); i++) {
      if (negaMax(this.possibleMoves.get(i), board, 5, this.color) > negaMax(this.possibleMoves.get(best), board, 5, this.color)) {
        best = i;
      }
    }
    return this.possibleMoves.get(best);
  }

}
