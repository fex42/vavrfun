package functional.monads;

public class NullInsteadOfMonadWorkflow {
    public Talk getTalk(final Speaker speaker) {
        if (speaker == null) {
            return null;
        } else {
            return new Talk(1L, "Functional Patterns");
        }
    }

    public Conference getConference(final Talk talk) {
        if (talk == null) {
            return null;
        } else {
            return new Conference(1L, "Herbstcampus");
        }
    }

    public City getCity(final Conference conference) {
        if (conference == null) {
            return null;
        } else {
            return new City(1L, "Nürnberg");
        }
    }

    public City allCityToVisit(Speaker speaker) {
        Talk talk = getTalk(speaker);
        if (talk == null) return null;

        Conference conference = getConference(talk);
        if (talk == null) return null;

        City city = getCity(conference);
        return city;
    }


    private void run() {
        System.out.println("#1: (no speaker at all)");
        System.out.println(allCityToVisit(null));
        Speaker jimBim = new Speaker(2L, "Jim Bim");
        System.out.println("#2: " + jimBim);
        System.out.println(allCityToVisit(jimBim));
        Speaker johnDoe = new Speaker(3L, "John Doe");
        System.out.println("#3:" + johnDoe);
        System.out.println(allCityToVisit(johnDoe));
    }


    public static void main(String[] args) {
        NullInsteadOfMonadWorkflow app = new NullInsteadOfMonadWorkflow();
        app.run();
    }

}
