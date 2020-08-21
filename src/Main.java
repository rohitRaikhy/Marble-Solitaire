import java.io.InputStreamReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

/**
 * This class represents the start of the program.
 */
public class Main {

  /**
   * Main function for the program.
   *
   * @param args argument variables for the program.
   */
  public static void main(String[] args) {
    MarbleSolitaireModel model = new MarbleSolitaireModelImpl();
    MarbleSolitaireController controller =
            new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out);
    controller.playGame(model);
  }
}
