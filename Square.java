import java.util.*;

public class Square {

  private int color; // 0 is empty, 1 is white, -1 is black
  private int score; // determines how valuable the square is to occupy
  private int r;
  private int c;

  int[] scoreBiases = {-4, -2, 1, 4, 7};

  public Square(int startColor, int r, int c) {
    this.color = startColor;
    this.r = r;
    this.c = c;
    this.score = calcScore(r, c);
  }

  public int getColor() {
    return this.color;
  }

  public int getScore() {
    return this.score;
  }

  public int getRow() {
    return this.r;
  }

  public int getColumn() {
    return this.c;
  }

  public void changeColor(int newColor) {
    this.color = newColor;
  }

  public int calcScore(int r, int c) {
    if ((r == 0 || r == 7) && (c == 0 || c == 7)) {
      return scoreBiases[4];
    } else if (2 <= c && c <= 5) {
      if (r == 0 || r == 7) {
        return scoreBiases[3];
      } else if (r == 1 || r == 6) {
        return scoreBiases[1];
      } else { // 2 <= r && r <= 5
        return scoreBiases[2];
      }
    } else if (2 <= r && r <= 5) {
      if (c == 0 || c == 7) {
        return scoreBiases[3];
      } else if (c == 1 || c == 6) {
        return scoreBiases[1];
      } else { // 2 <= c && c <= 5
        return scoreBiases[2];
      }
    } else {
      return scoreBiases[0];
    }
  }
}
