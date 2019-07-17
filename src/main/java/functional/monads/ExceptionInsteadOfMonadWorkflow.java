package functional.monads;

public class ExceptionInsteadOfMonadWorkflow {

    static class NotFoundException extends Exception {

    }

    public Talk getTalk(final Speaker speaker) throws NotFoundException {
        if (speaker == null) {
            throw new NotFoundException();
        } else {
            return new Talk(1L, "Functional Patterns");
        }
    }

    public Conference getConference(final Talk talk) throws NotFoundException {
        if (talk == null) {
            throw new NotFoundException();
        } else {
            return new Conference(1L, "Herbstcampus");
        }
    }

    public City getCity(final Conference conference) throws NotFoundException {
        if (conference == null) {
            throw new NotFoundException();
        } else {
            return new City(1L, "Nürnberg");
        }
    }

    public City allCityToVisit(Speaker speaker) {
        try {
            Talk talk = getTalk(speaker);
            Conference conference = getConference(talk);
            return getCity(conference);
        } catch (NotFoundException e) {
            return null;
        }
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
        ExceptionInsteadOfMonadWorkflow app = new ExceptionInsteadOfMonadWorkflow();
        app.run();
    }

}
