import java.util.*;
import java.lang.Character;

public class Board {

  private Square[][] squares;

  String whiteTile = "⚪️";
  String blackTile = "⚫️";

  public Board() {
    this.squares = new Square[8][8];
    for (int r = 0; r < this.squares.length; r++) {
      for (int c = 0; c < this.squares.length; c++) {
        this.squares[r][c] = new Square(0, r, c);
      }
    }
    this.squares[3][3].changeColor(1);
    this.squares[3][4].changeColor(-1);
    this.squares[4][3].changeColor(-1);
    this.squares[4][4].changeColor(1);
  }

  public Board(Square[][] existingBoard) {
    this.squares = existingBoard;
  }

  public Square[][] getSquares() {
    return this.squares;
  }

  public void changeSquare(int newColor, int r, int c) {
    this.squares[r][c].changeColor(newColor);
  }

  public ArrayList<Square> findTiles(int color) {
    ArrayList<Square> tiles = new ArrayList<Square>();
    for (int r = 0; r < this.squares.length; r++) {
      for (int c = 0; c < this.squares[0].length; c++) {
        if (this.squares[r][c].getColor() == color) {
          tiles.add(this.squares[r][c]);
        }
      }
    }
    return tiles;
  }

  public int countTiles(int color) {
    return findTiles(color).size();
  }

  public boolean isFull() {
    return countTiles(0) == 0;
  }

  public void printBoard() {
    System.out.print("  ");
    for (int j = 0; j < 8; j++) {
      System.out.print(j+1);
    }
    System.out.println("");
    for (int r = 0; r < this.squares.length; r++) {
      System.out.print(r+1 + " ");
      for (int c = 0; c < this.squares[0].length; c++) {
        if (this.squares[r][c].getColor() == 1) {
          System.out.print("O");
        } else if (this.squares[r][c].getColor() == -1) {
          System.out.print("X");
        } else {
          System.out.print("_");
        }
      }
      System.out.println("");
    }

  }

}
