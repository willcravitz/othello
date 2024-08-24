import java.util.*;
import java.lang.Math;

public class Player {

  ArrayList<Square> possibleMoves;
  int color;

  public Player(int color) {
    this.color = color;
    this.possibleMoves = new ArrayList<Square>();
  }

  public int getColor() {
    return this.color;
  }

  public ArrayList<Square> getPossibleMoves() {
    return this.possibleMoves;
  }

  public void updatePossibleMoves(Board board) {
    this.possibleMoves.clear();
    for (Square square : board.findTiles(this.color)) {
      for (int r = Math.max(square.getRow() - 1, 0); r <= Math.min(square.getRow() + 1, 7); r++) {
        for (int c = Math.max(square.getColumn() - 1, 0); c <= Math.min(square.getColumn() + 1, 7); c++) {
          if (board.getSquares()[r][c].getColor() == -this.color) {
            int newr = r;
            int newc = c;
            int dr = newr - square.getRow();
            int dc = newc - square.getColumn();
            while (board.getSquares()[newr][newc].getColor() == -this.color && newr > 0 && newr < 7 && newc > 0 && newc < 7) {
              newr += dr;
              newc += dc;
            } if (board.getSquares()[newr][newc].getColor() == 0) {
              this.possibleMoves.add(board.getSquares()[newr][newc]);
            }
          }
        }
      }
    }
  }

  public int placeTile(Board board, int row, int column) {
    int initialTiles = board.countTiles(this.color);
    board.changeSquare(this.color, row, column);
    for (int r = Math.max(row - 1, 0); r <= Math.min(row + 1, 7); r++) {
      for (int c = Math.max(column - 1, 0); c <= Math.min(column + 1, 7); c++) {
        if (board.getSquares()[r][c].getColor() == -this.color) {
          int newr = r;
          int newc = c;
          int dr = newr - row;
          int dc = newc - column;
          while (board.getSquares()[newr][newc].getColor() == -this.color && newr > 0 && newr < 7 && newc > 0 && newc < 7) {
            newr += dr;
            newc += dc;
          } if (board.getSquares()[newr][newc].getColor() == this.color) {
            newr -= dr;
            newc -= dc;
            while (board.getSquares()[newr][newc].getColor() == -this.color) {
              board.changeSquare(this.color, newr, newc);
              newr -= dr;
              newc -= dc;
            }
          }
        }
      }
    }
    return board.countTiles(this.color) - initialTiles;
  }

}
