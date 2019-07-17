package functional.monads;

import io.vavr.collection.List;

public class ListMonadWorkflow {
    public List<Talk> getTalks(final Speaker speaker) {
        if (speaker == null) {
            return List.empty();
        } else if (speaker.getId() % 3 == 0) {
            return List.of(new Talk(1L, "Functional Patterns"));
        } else {
            return List.of(
                    new Talk(2L, "Monads for Noobs"),
                    new Talk(3L, "Strange Code Made Simple")
            );
        }
    }

    public List<Conference> getConferences(final Talk talk) {
        if (talk == null) {
            return List.empty();
        } else if (talk.getId() % 2 == 0) {
            return List.of(new Conference(1L, "Herbstcampus"));
        } else {
            return List.of(
                    new Conference(2L, "JAX"),
                    new Conference(3L, "Strangeloop")
            );
        }
    }

    public List<City> getCities(final Conference conference) {
        if (conference == null) {
            return List.empty();
        } else if (conference.getId() % 3 == 0) {
            return List.of(new City(1L, "Nürnberg"));
        } else {
            return List.of(
                    new City(2L, "Berlin"),
                    new City(3L, "München")
            );
        }
    }

    public List<City> allCitiesToVisit(Speaker speaker) {
        return getTalks(speaker)        .flatMap(talk ->
               getConferences(talk)     .flatMap(conference ->
               getCities(conference)));
    }

    public void printAllCities(List<City> cities) {
        cities.forEach(
                c -> System.out.println(c)
        );
    }

    private void run() {
        System.out.println("#1: (no speaker at all)");
        printAllCities(allCitiesToVisit(null));
        Speaker jimBim = new Speaker(2L, "Jim Bim");
        System.out.println("#2: " + jimBim);
        printAllCities(allCitiesToVisit(jimBim));
        Speaker johnDoe = new Speaker(3L, "John Doe");
        System.out.println("#3:" + johnDoe);
        printAllCities(allCitiesToVisit(johnDoe));
    }


    public static void main(String[] args) {
        ListMonadWorkflow app = new ListMonadWorkflow();
        app.run();
    }

}
