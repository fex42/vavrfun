package functional.monads;

import io.vavr.control.Option;

public class OptionMonadWorkflow {
    public Option<Talk> getTalk(final Speaker speaker) {
        if (speaker == null) {
            return Option.none();
        } else {
            return Option.of(new Talk(1L, "Functional Patterns"));
        }
    }

    public Option<Conference> getConference(final Talk talk) {
        if (talk == null) {
            return Option.none();
        } else {
            return Option.of(new Conference(1L, "Herbstcampus"));
        }
    }

    public Option<City> getCity(final Conference conference) {
        if (conference == null) {
            return Option.none();
        } else {
            return Option.of(new City(1L, "Nürnberg"));
        }
    }

    public Option<City> allCityToVisit(Speaker speaker) {
        return getTalk(speaker)        .flatMap(talk ->
               getConference(talk)     .flatMap(conference ->
               getCity(conference)));
    }

    public void printAllCities(Option<City> cities) {
        cities.forEach(
                c -> System.out.println(c)
        );
    }

    private void run() {
        System.out.println("#1: (no speaker at all)");
        printAllCities(allCityToVisit(null));
        Speaker jimBim = new Speaker(2L, "Jim Bim");
        System.out.println("#2: " + jimBim);
        printAllCities(allCityToVisit(jimBim));
        Speaker johnDoe = new Speaker(3L, "John Doe");
        System.out.println("#3:" + johnDoe);
        printAllCities(allCityToVisit(johnDoe));
    }


    public static void main(String[] args) {
        OptionMonadWorkflow app = new OptionMonadWorkflow();
        app.run();
    }

}
