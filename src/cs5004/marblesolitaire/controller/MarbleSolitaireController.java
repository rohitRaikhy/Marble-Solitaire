package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This interface represents the operations offered by the marble solitaire controller.
 */

public interface MarbleSolitaireController {

  /**
   * Plays a new game of Marble Solitaire using the provided model.
   *
   * @param model the model to be used with the game.
   * @throws IllegalArgumentException if the model provided is null.
   * @throws IllegalStateException    only if the controller is unable to receive input or transmit
   *                                  output
   */
  void playGame(MarbleSolitaireModel model) throws IllegalArgumentException;
}
