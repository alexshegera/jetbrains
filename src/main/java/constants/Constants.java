package constants;

import java.time.Duration;

public class Constants {
    public static class TimeoutVariable {
        public static final int IMPLICIT_WAIT = 10;
        public static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);
    }

    public static class Urls {
        public static String HOME_PAGE_URL = "https://pets.kruts.net/start";
    }
}
