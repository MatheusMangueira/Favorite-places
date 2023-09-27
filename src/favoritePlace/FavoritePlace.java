package favoritePlace;

import favoritePlace.places.Places;

public class FavoritePlace {
  public static void main(String[] args) {
    Places place = new Places();

    place.setPlace("Salvador");
    place.assessmentPlace(5);
    place.assessmentPlace(4);


    place.accessPlace();

    place.assessmentTotal();
    place.assessmentMedia();


  }
}
