package cs5004.marblesolitaire.controller;

import java.io.IOException;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This class implements the MarbleSolitaireModel and is used for testing the controller IO.
 */
public class MockModel implements MarbleSolitaireModel {

  private final Appendable log;
  private final int uniqueIdentifier;

  public MockModel(Appendable log, int uniqueIdentifier) {
    this.log = log;
    this.uniqueIdentifier = uniqueIdentifier;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    try {
      log.append((fromRow + 1) + " " + (fromCol + 1) + " " + (toRow + 1) + " " + (toCol + 1));
    } catch (IOException e) {
      return;
    }
    return;
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  public String getGameState() {
    return null;
  }

  @Override
  public int getScore() {
    return uniqueIdentifier;
  }
}
