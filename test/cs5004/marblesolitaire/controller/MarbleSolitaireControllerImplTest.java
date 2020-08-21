package cs5004.marblesolitaire.controller;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * Test suite for the marble solitaire controller.
 */
public class MarbleSolitaireControllerImplTest {

  private MarbleSolitaireModelImpl englishGame;

  @Before
  public void setUp() throws Exception {
    englishGame = new MarbleSolitaireModelImpl();
  }

  /**
   * test reader as null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    StringBuffer out = new StringBuffer();
    Reader in = null;
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
  }

  /**
   * test appendable as null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test2Constructor() {
    StringBuffer out = null;
    Reader in = new StringReader("2 3 3 3");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
  }

  /**
   * test appendable and reader as null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void test3Constructor() {
    StringBuffer out = null;
    Reader in = null;
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
  }

  /**
   * test if model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testPlayGame() throws IOException {
    MarbleSolitaireModelImpl nullGame = null;
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 3 3 3");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(nullGame);
  }

  /**
   * test if model is gameOver win.
   */
  @Test
  public void test2PlayGame() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 "
            + "3 6 3 4 "
            + "1 5 3 5 "
            + "4 5 2 5 "
            + "6 5 4 5 "
            + "5 7 5 5 "
            + "5 4 5 6 "
            + "3 7 5 7 "
            + "5 7 5 5 "
            + "3 3 3 5 "
            + "3 1 3 3 "
            + "5 2 5 4 "
            + "5 4 5 6 "
            + "5 6 3 6 "
            + "3 6 3 4 "
            + "3 4 3 2 "
            + "7 3 5 3 "
            + "4 3 6 3 "
            + "7 5 7 3 "
            + "7 3 5 3 "
            + "5 1 3 1 "
            + "3 1 3 3 "
            + "1 3 1 5 "
            + "1 5 3 5 "
            + "3 5 5 5 "
            + "2 3 4 3 "
            + "4 3 6 3 "
            + "6 3 6 5 "
            + "6 5 4 5 "
            + "4 5 4 3 "
            + "4 2 4 4 ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if no valid inputs left in stream.
   */
  @Test(expected = IllegalStateException.class)
  public void test3PlayGame() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 ");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with no input.
   */
  @Test(expected = IllegalStateException.class)
  public void test4PlayGame() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader(" ");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with no input.
   */
  @Test(expected = IllegalStateException.class)
  public void test5PlayGame() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }


  /**
   * test if illegal state with 2 values.
   */
  @Test(expected = IllegalStateException.class)
  public void test6PlayGame() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with 3 values.
   */
  @Test(expected = IllegalStateException.class)
  public void test7PlayGame() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if model is gameplay.
   */
  @Test
  public void test8PlayGame() throws IOException {
    String expected =
            "    O O _\n"
                    + "    O _ O\n"
                    + "O O O O _ _ O\n"
                    + "O O O O _ O O\n"
                    + "O O O O O O O\n"
                    + "    O O O\n"
                    + "    O O O";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 "
            + "3 6 3 4 "
            + "1 5 3 5 "
            + "4 5 2 5 q");


    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with 3 values.
   */
  @Test(expected = IllegalStateException.class)
  public void test9PlayGame() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 5");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with 3 values.
   */
  @Test(expected = IllegalStateException.class)
  public void test10PlayGame() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 5 5");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with 3 values.
   */
  @Test
  public void test11PlayGame() throws IOException {
    String expected =
            "    O O O" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O _ O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";


    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("5 4 5 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with 3 values.
   */
  @Test
  public void test12PlayGame() throws IOException {
    String expected =
            "    O O O" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O _ O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";


    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if model is gameOver win.
   */
  @Test(expected = IllegalStateException.class)
  public void testGameOverWithErrors() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 "
            + "3 6 3 4 "
            + "1 5 3 5 "
            + "4 5 2 5 "
            + "6 5 4 5 "
            + "5 7 5 5 "
            + "5 4 5 6 "
            + "3 7 5 7 "
            + "5 7 5 5 "
            + "3 3 3 5 "
            + "3 1 3 3 "
            + "5 2 5 4 "
            + "5 4 5 6 "
            + "5 6 3 6 "
            + "3 6 3 4 "
            + "3 4 3 2 "
            + "7 3 5 3 "
            + "4 3 6 3 "
            + "7 5 7 3 "
            + "7 3 5 3 "
            + "5 1 3 1 "
            + "3 1 3 3 "
            + "1 3 1 5 "
            + "1 5 3 5 "
            + "3 5 5 5 "
            + "2 3 4 3 "
            + "4 3 6 3 "
            + "6 3 6 5 "
            + "6 5 4 5 "
            + "4 5 4 3 "
            + "4 2 4 dgse3 q ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(true, englishGame.isGameOver());
  }

  /**
   * test if illegal state with no input.
   */
  @Test(expected = IllegalStateException.class)
  public void testErrorInput() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 hg");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with no input.
   */
  @Test(expected = IllegalStateException.class)
  public void test2ErrorInput() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("sf");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with no input.
   */
  @Test(expected = IllegalStateException.class)
  public void test3ErrorInput() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("5 dfgf");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with no input.
   */
  // need to fix case of quit.
  @Test
  public void test4ErrorInput() throws IOException {
    String expected =
            "    O O O" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O _ O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 q 2 4");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with no input.
   */
  // need to fix case of quit.
  @Test
  public void testInvalidMove() throws IOException {
    String expected =
            "    O O O" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O _ O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";

    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1 3 2 4 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if model is gameOver win.
   */
  @Test
  public void test2GameOverWithErrors() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 "
            + "3 6 3 4 "
            + "1 5 3 5 "
            + "4 5 2 5 "
            + "6 5 4 5 "
            + "5 7 5 5 "
            + "5 4 5 6 "
            + "3 7 5 7 "
            + "5 7 5 5 "
            + "3 3 3 5 "
            + "3 1 3 3 "
            + "5 2 5 4 "
            + "5 4 5 6 "
            + "5 6 3 6 "
            + "3 6 3 4 "
            + "3 4 3 2 "
            + "7 3 5 3 "
            + "4 3 6 3 "
            + "7 5 7 3 "
            + "7 3 5 3 "
            + "5 1 3 1 "
            + "3 1 3 3 "
            + "1 3 1 5 "
            + "1 5 3 5 "
            + "3 5 5 5 "
            + "2 3 4 3 "
            + "4 3 6 3 "
            + "6 3 6 5 "
            + "6 5 4 5 "
            + "4 5 4 3 "
            + " hhj 4 2 4 4 ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if illegal state with 3 values.
   */
  @Test
  public void testErrorEndGame() throws IOException {
    String expected =
            "    O O O" + "\n"
                    + "    O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "O O O _ O O O" + "\n"
                    + "O O O O O O O" + "\n"
                    + "    O O O" + "\n"
                    + "    O O O";


    StringBuffer out = new StringBuffer();
    Reader in = new StringReader(" -5 2 4 5 5 q");

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if model is gameOver win.
   */
  @Test
  public void test3GameOverWithErrors() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 "
            + "3 6 3 4 "
            + "1 5 3 5 "
            + "4 5 2 5 "
            + "6 5 4 5 "
            + "5 7 5 5 "
            + "5 4 5 6 "
            + "3 7 5 7 "
            + "5 7 5 5 "
            + "3 3 3 5 "
            + "3 1 3 3 "
            + "5 2 5 4 "
            + "5 4 5 6 "
            + "5 6 3 6 "
            + "3 6 3 4 "
            + "3 4 3 2 "
            + "7 3 5 3 "
            + "4 3 6 3 "
            + "7 5 7 3 "
            + "7 3 5 3 "
            + "5 1 3 1 "
            + "3 1 3 3 "
            + "1 3 1 5 "
            + "1 5 3 5 "
            + "3 5 5 5 "
            + "2 3 4 3 "
            + "4 3 6 3 "
            + "6 3 6 5 "
            + "6 5 4 5 "
            + "4 5 4 3 "
            + "4 sdf 2 4 4 ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if model is gameOver win.
   */
  @Test
  public void test4GameOverWithErrors() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 "
            + "3 6 3 4 "
            + "1 5 3 5 "
            + "4 5 2 5 "
            + "6 5 4 5 "
            + "5 7 5 5 "
            + "5 4 5 6 "
            + "3 7 5 7 "
            + "5 7 5 5 "
            + "3 3 3 5 "
            + "3 1 3 3 "
            + "5 2 5 4 "
            + "5 4 5 6 "
            + "5 6 3 6 "
            + "3 6 3 4 "
            + "3 4 3 2 "
            + "7 3 5 3 "
            + "4 3 6 3 "
            + "7 5 7 3 "
            + "7 3 5 3 "
            + "5 1 3 1 "
            + "3 1 3 3 "
            + "1 3 1 5 "
            + "1 5 3 5 "
            + "3 5 5 5 "
            + "2 3 4 3 "
            + "4 3 6 3 "
            + "6 3 6 5 "
            + "6 5 4 5 "
            + "4 5 4 3 "
            + "4 2 df 4 4 ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test if model is gameOver win.
   */
  @Test
  public void test5GameOverWithErrors() throws IOException {
    String expected = "    _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "_ _ _ O _ _ _" + "\n"
            + "_ _ _ _ _ _ _" + "\n"
            + "    _ _ _" + "\n"
            + "    _ _ _";
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("2 4 4 4 "
            + "3 6 3 4 "
            + "1 5 3 5 "
            + "4 5 2 5 "
            + "6 5 4 5 "
            + "5 7 5 5 "
            + "5 4 5 6 "
            + "3 7 5 7 "
            + "5 7 5 5 "
            + "3 3 3 5 "
            + "3 1 3 3 "
            + "5 2 5 4 "
            + "5 4 5 6 "
            + "5 6 3 6 "
            + "3 6 3 4 "
            + "3 4 3 2 "
            + "7 3 5 3 "
            + "4 3 6 3 "
            + "7 5 7 3 "
            + "7 3 5 3 "
            + "5 1 3 1 "
            + "3 1 3 3 "
            + "1 3 1 5 "
            + "1 5 3 5 "
            + "3 5 5 5 "
            + "2 3 4 3 "
            + "4 3 6 3 "
            + "6 3 6 5 "
            + "6 5 4 5 "
            + "4 5 4 3 "
            + "4 2 4 sf 4 ");
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(englishGame);
    assertEquals(expected, englishGame.getGameState());
  }

  /**
   * test with mock model.
   */
  @Test
  public void testMockModel() {
    StringBuffer out = new StringBuffer();
    Appendable mockAppendable = new StringBuilder();
    MarbleSolitaireModel mockModel = new MockModel(mockAppendable, 1234321);
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(new StringReader("4 6 4 4 q"), out);
    controller.playGame(mockModel);
    assertEquals("4 6 4 4", mockAppendable.toString());
    assertEquals("1234321\n", out.toString().substring(89));
  }

} 