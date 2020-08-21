package cs5004.marblesolitaire.model;

import static org.junit.Assert.assertEquals;

/**
 * A junit test for the MarbleSolitaireModelImpl.
 */
public class MarbleSolitaireModelImplTest {

  private MarbleSolitaireModelImpl game1;
  private MarbleSolitaireModelImpl game2;
  private MarbleSolitaireModelImpl game4;
  private MarbleSolitaireModelImpl game5;
  private MarbleSolitaireModelImpl game6;
  private MarbleSolitaireModelImpl game7;
  private MarbleSolitaireModelImpl game8;
  private MarbleSolitaireModelImpl game9;
  private MarbleSolitaireModelImpl game10;

  @org.junit.Before
  public void setUp() {
    game1 = new MarbleSolitaireModelImpl();
    game2 = new MarbleSolitaireModelImpl(3, 0);
    game4 = new MarbleSolitaireModelImpl(3);
    game5 = new MarbleSolitaireModelImpl(5);
    game6 = new MarbleSolitaireModelImpl(3, 3, 3);
    game7 = new MarbleSolitaireModelImpl(5, 12, 4);
    game8 = new MarbleSolitaireModelImpl(3, 0, 2);
    game9 = new MarbleSolitaireModelImpl();
    game10 = new MarbleSolitaireModelImpl();

  }

  /**
   * test move method.
   */
  @org.junit.Test
  public void move() {
    String expected = "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O _ _ O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O";
    game1.move(3, 5, 3, 3);
    assertEquals(expected, game1.getGameState());
  }

  /**
   * test move method.
   */
  @org.junit.Test
  public void move2() {
    String expected = "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O";
    game1.move(3, 1, 3, 3);
    assertEquals(expected, game1.getGameState());
  }

  /**
   * test for invalid move on position on board.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void move3() {
    game1.move(0, 3, 3, 3);
    assertEquals("", game1.getGameState());
  }

  /**
   * test for multiple moves.
   */
  @org.junit.Test
  public void move4() {

    String expected = "    O O O" + "\n"
            + "    O _ O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O _ O O _ O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O";
    game1.move(3, 5, 3, 3);
    game1.move(3, 2, 3, 4);
    game1.move(1, 3, 3, 3);
    assertEquals(expected, game1.getGameState());
  }

  /**
   * test for invalid move out of bounds.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void move5() {
    game1.move(3, 5, 3, 10);
    assertEquals("", game1.getGameState());
  }

  /**
   * test for invalid move out of bounds for toRow.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void move6() {
    game1.move(3, 5, 10, 3);
    assertEquals("", game1.getGameState());
  }

  /**
   * test for invalid move out of bounds for fromCol.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void move7() {
    game1.move(3, 10, 3, 3);
    assertEquals("", game1.getGameState());
  }


  /**
   * test for marble between to and from invalid.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void move8() {
    game1.move(3, 5, 3, 3);
    game1.move(3, 5, 3, 3);
    assertEquals("", game1.getGameState());
  }

  /**
   * test for invalid move out of bounds for fromCol.
   */
  @org.junit.Test
  public void move9() {

    String expected = "    O O O" + "\n"
            + "    O O O" + "\n"
            + "O O O O O O O" + "\n"
            + "O O O O _ _ O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O O O" + "\n"
            + "    O O O";
    game1.move(3, 5, 3, 3);
    assertEquals(expected, game1.getGameState());
  }

  /**
   * test for multiple moves.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void move10() {
    game1.move(3, 5, 3, 3);
    game1.move(3, 2, 3, 4);
    game1.move(3, 4, 3, 2);
    assertEquals("", game1.getGameState());
  }


  /**
   * test gameplay. End on no valid moves.
   */
  @org.junit.Test
  public void testMove11() {

    String expected = "    O O O" + "\n"
            + "    O _ O" + "\n"
            + "O O O O O O O" + "\n"
            + "_ _ O _ O _ O" + "\n"
            + "O O O O O O O" + "\n"
            + "    O _ O" + "\n"
            + "    O _ O";

    game1.move(3, 5, 3, 3);
    game1.move(3, 2, 3, 4);
    game1.move(3, 0, 3, 2);
    game1.move(1, 3, 3, 3);
    game1.move(4, 3, 2, 3);
    game1.move(6, 3, 4, 3);
    assertEquals(expected, game1.getGameState());
  }


  /**
   * test gameplay. no valid moves.
   */
  @org.junit.Test
  public void testIsGameOver() {
    game1.move(3, 5, 3, 3);
    game1.move(3, 2, 3, 4);
    game1.move(3, 0, 3, 2);
    game1.move(1, 3, 3, 3);
    game1.move(4, 3, 2, 3);
    game1.move(6, 3, 4, 3);
    assertEquals(true, game1.isGameOver());
  }

  /**
   * test gameplay. game not over.
   */
  @org.junit.Test
  public void test2IsGameOver() {

    game1.move(3, 5, 3, 3);
    game1.move(3, 2, 3, 4);
    game1.move(3, 0, 3, 2);
    game1.move(1, 3, 3, 3);
    game1.move(4, 3, 2, 3);
    assertEquals(false, game1.isGameOver());
  }


  /**
   * test the gameState method.
   */
  @org.junit.Test
  public void testGetGameState() {
    MarbleSolitaireModelImpl game1 = new MarbleSolitaireModelImpl();
    String expectedConstructorOne =
            "    O O O" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O _ O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";

    String expectedConstructorTwo =
            "    O O O" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "_ O O O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";

    assertEquals(expectedConstructorOne, game1.getGameState());
    assertEquals(expectedConstructorTwo, game2.getGameState());

  }

  /**
   * test the gameState method.
   */
  @org.junit.Test
  public void test2GetGameState() {

    String expectedConstructorOne =
            "    O O O" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O _ O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";

    String expectedConstructorTwo =
            "        O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        O O O O O" + "\n" + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O _ O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        O O O O O";

    assertEquals(expectedConstructorOne, game4.getGameState());
    assertEquals(expectedConstructorTwo, game5.getGameState());

  }

  /**
   * test the gameState method.
   */
  @org.junit.Test
  public void test3GetGameState() {

    String expectedConstructorOne =
            "    O O O" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O _ O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";

    String expectedConstructorTwo =
            "        O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        O O O O O" + "\n" + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "O O O O O O O O O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        O O O O O" + "\n"
                    + "        _ O O O O";

    assertEquals(expectedConstructorOne, game6.getGameState());
    assertEquals(expectedConstructorTwo, game7.getGameState());

  }

  /**
   * test the gameState method.
   */
  @org.junit.Test
  public void test4GetGameState() {

    String expectedConstructorOne =
            "    O _ _" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";


    game8.move(0, 4, 0, 2);
    game8.getGameState();
    assertEquals(expectedConstructorOne, game8.getGameState());

  }

  /**
   * test the gameState method on invalid case.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void test5GetGameState() {

    MarbleSolitaireModelImpl game9;
    game9 = new MarbleSolitaireModelImpl(3, 0, 5);
  }

  /**
   * test the getScore method.
   */
  @org.junit.Test
  public void getScore() {
    // should be 32
    assertEquals(32, game1.getScore());
    // should be 32
    assertEquals(32, game2.getScore());
    // should be 32
    assertEquals(32, game4.getScore());
    // should be 104
    assertEquals(104, game5.getScore());
  }

  /**
   * test gameplay with one marble left.
   */
  @org.junit.Test
  public void oneMarbleLeft() {
    game9.move(3, 5, 3, 3);
    game9.move(5, 4, 3, 4);
    game9.move(4, 6, 4, 4);
    game9.move(4, 3, 4, 5);
    game9.move(4, 1, 4, 3);
    game9.move(6, 2, 4, 2);
    game9.move(3, 2, 5, 2);
    game9.move(6, 4, 6, 2);
    game9.move(6, 2, 4, 2);
    game9.move(2, 4, 4, 4);
    game9.move(0, 4, 2, 4);
    game9.move(1, 2, 3, 2);
    game9.move(3, 2, 5, 2);
    game9.move(5, 2, 5, 4);
    game9.move(5, 4, 3, 4);
    game9.move(3, 4, 1, 4);
    game9.move(2, 6, 4, 6);
    game9.move(4, 6, 4, 4);
    game9.move(4, 4, 4, 2);
    game9.move(2, 0, 2, 2);
    game9.move(2, 3, 2, 1);
    game9.move(4, 0, 2, 0);
    game9.move(2, 0, 2, 2);
    game9.move(0, 2, 0, 4);
    game9.move(0, 4, 2, 4);
    game9.move(2, 5, 2, 3);
    game9.move(2, 3, 2, 1);
    game9.move(2, 1, 4, 1);
    game9.move(4, 1, 4, 3);
    game9.move(4, 3, 2, 3);
    game9.move(1, 3, 3, 3);

    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    assertEquals(expected, game9.getGameState());
    assertEquals(true, game9.isGameOver());
  }

  /**
   * test gameplay with one marble left.
   */
  @org.junit.Test
  public void oneMarbleLeft2() {
    game10.move(5, 3, 3, 3);
    game10.move(4, 5, 4, 3);
    game10.move(6, 4, 4, 4);
    game10.move(6, 2, 6, 4);
    game10.move(3, 4, 5, 4);
    game10.move(6, 4, 4, 4);
    game10.move(1, 4, 3, 4);
    game10.move(2, 6, 2, 4);
    game10.move(4, 6, 2, 6);
    game10.move(2, 3, 2, 5);
    game10.move(2, 6, 2, 4);
    game10.move(2, 1, 2, 3);
    game10.move(0, 2, 2, 2);
    game10.move(3, 2, 1, 2);
    game10.move(0, 4, 0, 2);
    game10.move(0, 2, 2, 2);
    game10.move(5, 2, 3, 2);
    game10.move(4, 0, 4, 2);
    game10.move(2, 0, 4, 0);
    game10.move(4, 3, 4, 1);
    game10.move(4, 0, 4, 2);
    game10.move(2, 3, 2, 5);
    game10.move(2, 5, 4, 5);
    game10.move(4, 5, 4, 3);
    game10.move(4, 3, 4, 1);
    game10.move(4, 1, 2, 1);
    game10.move(2, 1, 2, 3);
    game10.move(3, 3, 3, 5);
    game10.move(1, 3, 3, 3);
    game10.move(3, 2, 3, 4);
    game10.move(3, 5, 3, 3);

    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    assertEquals(expected, game10.getGameState());
    assertEquals(true, game10.isGameOver());
    assertEquals(1, game10.getScore());
  }

  /**
   * test the gameState method on invalid case.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void test6GetGameState() {

    MarbleSolitaireModelImpl game11;
    game11 = new MarbleSolitaireModelImpl(-1);
  }

  /**
   * test the gameState method on invalid case.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void test7GetGameState() {

    MarbleSolitaireModelImpl game11;
    game11 = new MarbleSolitaireModelImpl(-1, -1, -1);
  }

  /**
   * test the gameState method on invalid case.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void test8GetGameState() {

    MarbleSolitaireModelImpl game11;
    game11 = new MarbleSolitaireModelImpl(-1, -1);
  }

  /**
   * test the gameState method on invalid case.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void test9GetGameState() {

    MarbleSolitaireModelImpl game11;
    game11 = new MarbleSolitaireModelImpl(1, -1);
  }

  /**
   * test the gameState method on invalid case.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void test10GetGameState() {

    MarbleSolitaireModelImpl game11;
    game11 = new MarbleSolitaireModelImpl(-1, 1);
  }

  /**
   * test the gameState method on invalid case.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void test11GetGameState() {

    MarbleSolitaireModelImpl game11;
    game11 = new MarbleSolitaireModelImpl(-1, 1, 1);
  }

  /**
   * test the gameState method on invalid case.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void test13GetGameState() {

    MarbleSolitaireModelImpl game11;
    game11 = new MarbleSolitaireModelImpl(1, -1, 1);
  }

  /**
   * test the gameState method on invalid case.
   */
  @org.junit.Test(expected = IllegalArgumentException.class)
  public void test14GetGameState() {

    MarbleSolitaireModelImpl game11;
    game11 = new MarbleSolitaireModelImpl(1, 1, -1);
  }

  /**
   * test the isValidMove.
   */
  @org.junit.Test
  public void testisValidMove() {

    IBoard board1;
    board1 = new Board();
    assertEquals(true, board1.isValidMove(5, 3, 3, 3));
  }

  /**
   * test the identity of piece.
   */
  @org.junit.Test
  public void testIdentity() {
    IPiece empty = new EmptyPiece();
    IPiece marble = new MarblePiece();
    IPiece invalidPiece = new InvalidPiece();
    IPiece invalidPieceTwo = new InvalidPieceTwo();

    assertEquals("Empty Piece", empty.identity());
    assertEquals("Marble Piece", marble.identity());
    assertEquals("Invalid Piece", invalidPiece.identity());
    assertEquals("Invalid Piece Two", invalidPieceTwo.identity());
  }


}