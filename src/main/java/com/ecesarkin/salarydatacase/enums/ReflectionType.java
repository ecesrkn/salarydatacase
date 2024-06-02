package com.ecesarkin.salarydatacase.enums;

public enum ReflectionType {
    ItsComplicated {
        @Override
        public String toString() {
            return "It's Complicated";
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
