package cs5004.marblesolitaire.model;

/**
 * implements IPiece and makes a marble piece.
 */
public class MarblePiece implements IPiece {

  @Override
  public String toString() {
    return "O";
  }

  @Override
  public String identity() {
    return "Marble Piece";
  }
}
