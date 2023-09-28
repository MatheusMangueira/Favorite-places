package favoritePlace;

import favoritePlace.places.Places;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class FavoritePlace {
  public static void main(String[] args) throws IOException, URISyntaxException {

    String view = inputView("Qual seu lugar favorito?");
    Places place = new Places();

    while (true) {
      try {
        String inputAssessment = inputView("Qual sua avaliação?");
        int assessment = Integer.parseInt(inputAssessment);
        place.assessmentPlace(assessment);
      } catch (NumberFormatException e) {
        break;
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        break;
      }
    }

    place.setPlace(view);

    outputView(place);
    place.accessPlace();
  }

  public static String inputView(String display) {
    return JOptionPane.showInputDialog(display);
  }

  public static void outputView(Places display) {
    JOptionPane.showMessageDialog(null, display);
  }


}
