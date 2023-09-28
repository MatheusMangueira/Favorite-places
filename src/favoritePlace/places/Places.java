package favoritePlace.places;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Places {
  private String place;
  private List<Integer> assessment = new ArrayList<Integer>();

  public Places(String place, List<Integer> assessment) {
    this.place = place;
    this.assessment = assessment;
  }

  public Places() {
  }

  @Override
  public String toString() {
    return "lugar= " + this.place + "\n" +
            "total de avaliações= " + assessmentTotal() + "\n" +
            "media das avaliações= " + assessmentMedia() + "\n" +
            "status das avaliações= " + statusAssessment();
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public List<Integer> getAssessment() {
    return assessment;
  }

  public void accessPlace() {
    String nameURL = this.place.replace(" ", "%20");

    try {
      URI uri = new URI("https://www.google.com/maps/search/?api=1&query=" + nameURL);
      Desktop.getDesktop().browse(uri);
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
  }

  public void assessmentPlace(int assessment) {
    if (assessment < 0 || assessment > 10) {
      throw new RuntimeException("Avaliação deve ser entre 0 e 10");
    }
    this.assessment.add(assessment);
  }

  public int assessmentTotal() {
    return this.assessment.size();
  }

  private double sumAssessment() {
    double total = 0;
    for (int i = 0; i < this.assessment.size(); i++) {
      total += this.assessment.get(i);
    }
    return total;
  }

  public double assessmentMedia() {
    return sumAssessment() / assessmentTotal();
  }

  public String statusAssessment() {
    double media = assessmentMedia();
    if (media >= 8) {
      return "Exelente";
    } else if (media >= 5) {
      return "Bom";
    } else if (media >= 3) {
      return "Regular";
    } else {
      return "Ruim";
    }

  }

}
