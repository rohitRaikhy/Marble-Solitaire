package cs5004.marblesolitaire.model;

/**
 * Represents the board.
 */

public interface IBoard {
  /**
   * gets the current score.
   *
   * @return the score.
   */
  int getScore();

  /**
   * checks to see if a move is valid.
   *
   * @param fromRow the starting row.
   * @param fromCol the starting column.
   * @param toRow   the row to be moved to.
   * @param toCol   the column to be moved to.
   * @return boolean if the move is valid or not.
   */
  boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol);

  /**
   * makes a move on the board.
   *
   * @param fromRow the starting row.
   * @param fromCol the starting column.
   * @param toRow   the row to be moved to.
   * @param toCol   the column to be moved to.
   */
  void makeMove(int fromRow, int fromCol, int toRow, int toCol);

  /**
   * Checks to see if a piece has any more moves left.
   *
   * @return a boolean indicating if any moves are left for a piece.
   */
  boolean anyMoreMovesLeft();
}
