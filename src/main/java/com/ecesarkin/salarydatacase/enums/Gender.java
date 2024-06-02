package com.ecesarkin.salarydatacase.enums;

public enum Gender {
    MALE {
        @Override
        public String toString() {
            return "Female";
        }
    },
    FEMALE {
        @Override
        public String toString() {
            return "Male";
        }
    },
    DIVERSE {
        @Override
        public String toString() {
            return "Diverse";
        }
    },
    PREFERNOTTOSAY {
        @Override
        public String toString() {
            return "Prefer Not To Say";
        }
    }

}
