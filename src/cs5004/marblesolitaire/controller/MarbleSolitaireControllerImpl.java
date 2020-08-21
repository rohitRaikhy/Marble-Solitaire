package cs5004.marblesolitaire.controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This class implements the MarbleSolitaireModel interface.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  final Readable rd;
  final Appendable ap;

  /**
   * Creates marble solitaire controller interface.
   *
   * @param rd Readable the reader to be used for input.
   * @param ap Appendable the appendable to be used for output.
   * @throws IllegalArgumentException if reader or appendable is null.
   */
  public MarbleSolitaireControllerImpl(Readable rd, Appendable ap)
          throws IllegalArgumentException {
    if (rd == null || ap == null) {
      throw new IllegalArgumentException("Readable or appendable cannot be null");
    }
    this.rd = rd;
    this.ap = ap;
  }

  private int enterValidRow(String fromRow, Scanner scan)
          throws IllegalArgumentException, IOException {
    int moveFromRow = 0;
    while (true) {
      try {
        moveFromRow = Integer.parseInt(fromRow);
      } catch (NumberFormatException e) {
        this.ap.append("Not a valid integer.\n");
      }
      if (moveFromRow > 0) {
        break;
      }
      this.ap.append("Please enter the from row again.\n");
      try {
        fromRow = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("End of stream to parse.");
      }
    }
    return moveFromRow;
  }

  private int enterValidFromColumn(String fromCol, Scanner scan)
          throws IllegalArgumentException, IOException {
    int moveFromCol = 0;
    while (true) {
      try {
        moveFromCol = Integer.parseInt(fromCol);
      } catch (NumberFormatException e) {
        this.ap.append("Not a valid integer.\n");
      }
      if (moveFromCol > 0) {
        break;
      }
      this.ap.append("Please enter the from column again.\n");
      try {
        fromCol = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("End of stream to parse.");
      }
    }
    return moveFromCol;
  }

  private int enterValidToRow(String fromCol, Scanner scan)
          throws IllegalArgumentException, IOException {
    int moveToRow = 0;
    while (true) {
      try {
        moveToRow = Integer.parseInt(fromCol);
      } catch (NumberFormatException e) {
        this.ap.append("Not a valid integer.\n");
      }
      if (moveToRow > 0) {
        break;
      }
      this.ap.append("Please enter the to row again.\n");
      try {
        fromCol = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("End of stream to parse.");
      }
    }
    return moveToRow;
  }

  private int enterValidToCol(String toCol, Scanner scan)
          throws IllegalArgumentException, IOException {
    int moveToCol = 0;
    while (true) {
      try {
        moveToCol = Integer.parseInt(toCol);
      } catch (NumberFormatException e) {
        this.ap.append("Not a valid integer.\n");
      }
      if (moveToCol > 0) {
        break;
      }
      this.ap.append("Please enter the to row again.\n");
      try {
        toCol = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("End of stream to parse.");
      }
    }
    return moveToCol;
  }

  private boolean checkQuitGame(String testString, MarbleSolitaireModel model) {
    return (testString.equals("q") || testString.equals("Q"));
  }

  private void appendGameState(MarbleSolitaireModel model) {
    try {
      this.ap.append("\nGame quit!\nState of game when quit:\n");
      this.ap.append(model.getGameState());
      this.ap.append(String.format("\nScore: %d\n", model.getScore()));
      return;
    } catch (IOException e) {
      throw new IllegalStateException("Cannot write to game.");
    }
  }

  @Override
  public void playGame(MarbleSolitaireModel model) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("The model cannot be null");
    }
    String scanString;
    int moveFromRow;
    int moveFromCol;
    int moveToRow;
    int moveToCol;
    Scanner scan = new Scanner(this.rd);
    while (true) {
      try {
        this.ap.append(model.getGameState());
        this.ap.append(String.format("\nScore: %d\n", model.getScore()));
      } catch (IOException e) {
        throw new IllegalStateException("Was not able to append to game");
      }
      try {
        scanString = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("Unable to read from input");
      }
      if (checkQuitGame(scanString, model)) {
        appendGameState(model);
        return;
      }
      try {
        moveFromRow = enterValidRow(scanString, scan) - 1;
      } catch (IOException e) {
        throw new IllegalStateException("Cannot write to game.");
      }
      try {
        scanString = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("Cannot write to game.");
      }
      if (checkQuitGame(scanString, model)) {
        appendGameState(model);
        return;
      }
      try {
        moveFromCol = enterValidFromColumn(scanString, scan) - 1;
      } catch (IOException e) {
        throw new IllegalStateException("Cannot write to game.");
      }
      try {
        scanString = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("Cannot write to game.");
      }
      if (checkQuitGame(scanString, model)) {
        appendGameState(model);
        return;
      }
      try {
        moveToRow = enterValidToRow(scanString, scan) - 1;
      } catch (IOException e) {
        throw new IllegalStateException("Cannot write to game.");
      }
      try {
        scanString = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException("Cannot write to game.");
      }
      if (checkQuitGame(scanString, model)) {
        appendGameState(model);
        return;
      }
      try {
        moveToCol = enterValidToCol(scanString, scan) - 1;
      } catch (IOException e) {
        throw new IllegalStateException("Cannot write to game.");
      }
      try {
        model.move(moveFromRow, moveFromCol, moveToRow, moveToCol);
      } catch (IllegalArgumentException e) {
        try {
          this.ap.append("\"Invalid move. Play again.\"");
        } catch (IOException n) {
          throw new IllegalStateException("Cannot write to game.");
        }
      }

      if (model.isGameOver()) {
        try {
          this.ap.append("\nGame over!\n");
          this.ap.append(model.getGameState());
          this.ap.append(String.format("\nScore: %d\n", model.getScore()));
          return;
        } catch (IOException e) {
          throw new IllegalStateException("Cannot write to game.");
        }
      }
    }
  }
}






