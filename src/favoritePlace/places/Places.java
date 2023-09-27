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

  public String getPlace() {
    return place;
  }

  public String setPlace(String place) {
    this.place = place.toUpperCase();
    return place;
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
    this.assessment.add(assessment);
  }

  public int assessmentTotal() {
    return this.assessment.size();
  }

  public double assessmentMedia() {
    double total = 0;
    for (int i = 0; i < this.assessment.size(); i++) {
      total += this.assessment.get(i);
    }
    System.out.println(total / this.assessment.size());
    return total / this.assessment.size();

  }

}
