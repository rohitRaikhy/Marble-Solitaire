package cs5004.marblesolitaire.model;

/**
 * implements IPiece and makes an invalid piece.
 */
public class InvalidPiece implements IPiece {

  /**
   * constructor to make first type of invalid piece on the left of the board.
   */

  @Override
  public String toString() {
    return " ";
  }

  @Override
  public String identity() {
    return "Invalid Piece";
  }
}
