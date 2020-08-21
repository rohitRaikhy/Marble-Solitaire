package cs5004.marblesolitaire.model;

/**
 * implements IPiece and makes an empty piece.
 */
public class EmptyPiece implements IPiece {

  /**
   * constructor to make an Empty Piece.
   */

  @Override
  public String toString() {
    return "_";
  }

  @Override
  public String identity() {
    return "Empty Piece";
  }
}
