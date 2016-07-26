package com.technawabs.openhouz.constants;

public class OpenHouzConstants {

    public static final int BOT = 0;
    public static final int USER = 1;
    public static final int APARTMENT_BUDGET = 2;
    public static final int APARTMENT_NEIGHBOURHOODS = 3;
    public static final int APARTMENT_TYPE = 4;

    public class Sender {
        public static final String BOT = "BOT";
        public static final String USER = "USER";
    }

    public class ApartmentProperties {
        public static final String TYPE = "APARTMENT_TYPE";
        public static final String NEIGHBOURHOODS = "APARTMENT_NEIGHBOURHOODS";
        public static final String BUDGET = "APARTMENT_BUDGET";
    }

    public class CardType {
        public static final int PROPERTY_CARD = 0;
        public static final int UPCOMING_VIEWING_CARD = 1;
        public static final int UPCOMING_VIEWED_CARD = 2;
    }
}
