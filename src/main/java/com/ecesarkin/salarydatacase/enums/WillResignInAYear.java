package com.ecesarkin.salarydatacase.enums;

public enum WillResignInAYear {
    DONTKNOW {
        @Override
        public String toString() {
            return "Don't know";
        }
    },
    YES {
        @Override
        public String toString() {
            return "Yes";
        }
    },
    NO {
        @Override
        public String toString() {
            return "No";
        }
    }
}
