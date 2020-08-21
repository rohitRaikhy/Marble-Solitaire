package cs5004.marblesolitaire.model;

/**
 * This class implements the MarbleSolitaireModel interface.
 */
public class MarbleSolitaireModelImpl implements MarbleSolitaireModel {

  private int row;
  private int column;
  private int armThickness;
  private IBoard englishBoard;

  /**
   * Constructor to create a MarbleSolitaireModelImpl.
   */
  public MarbleSolitaireModelImpl() {
    this.englishBoard = new Board();
  }

  /**
   * Constructor to create a MarbleSolitaireModelImpl.
   */
  public MarbleSolitaireModelImpl(int row, int column) {
    this.englishBoard = new Board(row, column);
  }

  /**
   * Constructor to create a MarbleSolitaireModelImpl.
   */
  public MarbleSolitaireModelImpl(int armthickness) {
    this.englishBoard = new Board(armthickness);
  }

  /**
   * Constructor to create a MarbleSolitaireModelImpl.
   */
  public MarbleSolitaireModelImpl(int armthickness, int row, int column) {
    this.englishBoard = new Board(armthickness, row, column);
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (englishBoard.isValidMove(fromRow, fromCol, toRow, toCol)) {
      englishBoard.makeMove(fromRow, fromCol, toRow, toCol);
    } else {
      throw new IllegalArgumentException("Move is not valid.");
    }
  }

  @Override
  public boolean isGameOver() {
    if (getScore() == 0 || getScore() == 1) {
      return true;
    }
    return (!(englishBoard.anyMoreMovesLeft()));
  }

  @Override
  public String getGameState() {
    return englishBoard.toString();
  }

  @Override
  public int getScore() {
    return englishBoard.getScore();
  }

}
