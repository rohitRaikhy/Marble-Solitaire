package cs5004.marblesolitaire.model;

/**
 * This class implements the IBoard interface.
 */
public class Board implements IBoard {

  private int armThickness;
  private int armLength;
  private int dimensions;
  private int row;
  private int column;
  protected IPiece[][] board;

  /**
   * constructor to create a board.
   */
  public Board() {
    this.armThickness = 3;
    this.armLength = armThickness - 1;
    this.dimensions = 2 * this.armLength + this.armThickness;
    this.board = new IPiece[dimensions][dimensions];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if ((i < 2 && j < 2) || (i > 4 && j < 2)) {
          board[i][j] = new InvalidPiece();
        } else if ((i < 2 && j > 4) || (i > 4 && j > 4)) {
          board[i][j] = new InvalidPieceTwo();
        } else if (i == 3 && j == 3) {
          board[i][j] = new EmptyPiece();
        } else {
          board[i][j] = new MarblePiece();
        }
      }
    }
  }

  /**
   * constructor to create a board.
   */
  public Board(int row, int column) throws IllegalArgumentException {
    this.row = row;
    this.column = column;
    this.armThickness = 3;
    this.armLength = armThickness - 1;
    this.dimensions = 2 * this.armLength + this.armThickness;
    this.board = new IPiece[dimensions][dimensions];
    if (this.row > board.length || this.row < 0 || this.column > board.length || this.column < 0) {
      throw new IllegalArgumentException("row or column is out of range of board");
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if ((i < 2 && j < 2) || (i > 4 && j < 2)) {
          board[i][j] = new InvalidPiece();
        } else if ((i < 2 && j > 4) || (i > 4 && j > 4)) {
          board[i][j] = new InvalidPieceTwo();
        } else if (i == row && j == column) {
          board[i][j] = new EmptyPiece();
        } else {
          board[i][j] = new MarblePiece();
        }
      }
    }
  }

  /**
   * constructor to create a board.
   */
  public Board(int armThickness) throws IllegalArgumentException {

    if (armThickness < 0 || armThickness % 2 == 0) {
      throw new IllegalArgumentException("row or column is out of range of board");
    }
    this.armThickness = armThickness;
    this.armLength = armThickness - 1;
    this.dimensions = 2 * this.armLength + armThickness;
    this.board = new IPiece[dimensions][dimensions];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (j < this.armLength && i < this.armLength || i > this.armLength + armThickness - 1
                && j < this.armLength) {
          board[i][j] = new InvalidPiece();
        } else if (j > this.armLength + armThickness - 1 && i > this.armLength + armThickness - 1
                || j > armThickness + this.armLength - 1 && i < this.armLength) {
          board[i][j] = new InvalidPieceTwo();
        } else if (j == Math.ceil(board.length / 2) && i == Math.ceil(board.length / 2)) {
          board[i][j] = new EmptyPiece();
        } else {
          board[i][j] = new MarblePiece();
        }
      }
    }
  }

  /**
   * constructor to create a board.
   */
  public Board(int armThickness, int row, int column) throws IllegalArgumentException {

    this.armThickness = armThickness;
    this.row = row;
    this.column = column;
    this.armLength = armThickness - 1;
    this.dimensions = 2 * this.armLength + armThickness;
    if (armThickness < 0 || armThickness % 2 == 0 || (this.row < armLength
            && this.column < armLength)
            || (this.row > armThickness + armLength - 1
            && this.column > armThickness + armLength - 1)
            || (this.row < armLength && this.column > armThickness + armLength - 1)
            || (this.row > armThickness + armLength - 1 && this.column < armLength)) {
      throw new IllegalArgumentException("row or column is out of range of board");
    }
    this.board = new IPiece[dimensions][dimensions];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (j < this.armLength && i < this.armLength || i > this.armLength + armThickness - 1
                && j < this.armLength) {
          board[i][j] = new InvalidPiece();
        } else if (j > this.armLength + armThickness - 1 && i > this.armLength + armThickness - 1
                || j > armThickness + this.armLength - 1 && i < this.armLength) {
          board[i][j] = new InvalidPieceTwo();
        } else if (i == row && j == column) {
          board[i][j] = new EmptyPiece();
        } else {
          board[i][j] = new MarblePiece();
        }
      }
    }
  }

  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (board[i][j].identity().equals("Marble Piece")) {
          score += 1;
        }
      }
    }
    return score;
  }

  // line 148 changed to .equals to check.
  // line 151 changed to .equals to check junit style.
  @Override
  public boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol) {
    return !(invalidBoardConstraints(fromRow, fromCol, toRow, toCol)
            || !(board[fromRow][fromCol].identity().equals("Marble Piece"))
            || !(board[toRow][toCol].identity().equals("Empty Piece"))
            || isInvalidTwoSpacesApart(fromRow, fromCol, toRow, toCol)
            || isMarbleInMiddle(fromRow, fromCol, toRow, toCol));
  }

  @Override
  public void makeMove(int fromRow, int fromCol, int toRow, int toCol) {
    board[fromRow][fromCol] = new EmptyPiece();
    board[toRow][toCol] = new MarblePiece();
    if (fromRow == toRow) {
      int middleCol = (fromCol + toCol) / 2;
      int middleRow = fromRow;
      board[middleRow][middleCol] = new EmptyPiece();
    } else {
      int middleRow = (fromRow + toRow) / 2;
      int middleCol = fromCol;
      board[middleRow][middleCol] = new EmptyPiece();
    }
  }

  @Override
  public boolean anyMoreMovesLeft() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        int fromRow = i;
        int fromCol = j;
        int northToRow = i + 2;
        int northtoCol = j;
        int eastToRow = i;
        int eastToCol = j + 2;
        int southToRow = i - 2;
        int southToCol = j;
        int westToRow = i;
        int westToCol = j - 2;
        if (isValidMove(fromRow, fromCol, northToRow, northtoCol)
                || isValidMove(fromRow, fromCol, eastToRow, eastToCol)
                || isValidMove(fromRow, fromCol, southToRow, southToCol)
                || isValidMove(fromRow, fromCol, westToRow, westToCol)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Check to see if move is in an invalid board constraint.
   *
   * @param fromRow the starting row.
   * @param fromCol the starting column.
   * @param toRow   the row to be moved to.
   * @param toCol   the column to be moved to.
   * @return boolean if move is in valid board constraint.
   */
  private boolean invalidBoardConstraints(int fromRow, int fromCol, int toRow, int toCol) {
    return (fromRow > board.length - 1 || fromRow < 0 || fromCol > board.length - 1 || fromCol < 0
            || toRow > board.length - 1 || toRow < 0 || toCol > board.length - 1 || toCol < 0);
  }

  /**
   * check to see if move is vertical or horizontal.
   *
   * @param fromRow the starting row.
   * @param fromCol the starting column.
   * @param toRow   the row to be moved to.
   * @param toCol   the column to be moved to.
   * @return boolean if move is vertical or horizontal.
   */
  private boolean isVerticalOrHorizontal(int fromRow, int fromCol, int toRow, int toCol) {
    return (fromRow == toRow || fromCol == toCol);
  }

  /**
   * check to see if move is two spaces apart.
   *
   * @param fromRow the starting row.
   * @param fromCol the starting column.
   * @param toRow   the row to be moved to.
   * @param toCol   the column to be moved to.
   * @return boolean if the move is two spaces apart.
   */
  private boolean isInvalidTwoSpacesApart(int fromRow, int fromCol, int toRow, int toCol) {
    return (!(isVerticalOrHorizontal(fromRow, fromCol, toRow, toCol)
            && (Math.abs(fromRow - toRow) == 2
            || Math.abs(fromCol - toCol) == 2)));
  }

  /**
   * checks to see if there is a marble is in the middle.
   *
   * @param fromRow the starting row.
   * @param fromCol the starting column.
   * @param toRow   the row to be moved to.
   * @param toCol   the column to be moved to.
   * @return boolean if there is a marble in the middle.
   */
  private boolean isMarbleInMiddle(int fromRow, int fromCol, int toRow, int toCol) {
    if (isVerticalOrHorizontal(fromRow, fromCol, toRow, toCol)
            && !(isInvalidTwoSpacesApart(fromRow, fromCol, toRow, toCol))) {
      if (fromRow == toRow) {
        int middleCol = (fromCol + toCol) / 2;
        int middleRow = fromRow;
        if (!(board[middleRow][middleCol].identity().equals("Marble Piece"))) {
          return true;
        }
      } else {
        int middleRow = (fromRow + toRow) / 2;
        int middleCol = fromCol;
        if (!(board[middleRow][middleCol].identity().equals("Marble Piece"))) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        if (i == board.length - 1 && j == armLength + this.armThickness - 1) {
          stringBuilder.append(board[i][j]);
          break;
        }
        if (j < board.length - 1 && board[i][j + 1].identity().equals("Invalid Piece Two")
                && (board[i][j].identity().equals("Marble Piece")
                || board[i][j].identity().equals("Empty Piece"))) {
          stringBuilder.append(board[i][j]);
          stringBuilder.append("\n");
        } else if (board[i][j].identity().equals("Invalid Piece Two")) {
          continue;
        } else {
          stringBuilder.append(board[i][j]);
          if (j != board.length - 1) {
            stringBuilder.append(" ");
          } else {
            stringBuilder.append("\n");
          }
        }
      }
    }
    return stringBuilder.toString();
  }
}
