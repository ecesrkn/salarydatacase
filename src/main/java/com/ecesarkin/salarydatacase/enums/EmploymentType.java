package com.ecesarkin.salarydatacase.enums;

public enum EmploymentType {
    FULLTIME {
        @Override
        public String toString() {
            return "Full-time";
        }
    },
    PARTTIME {
        @Override
        public String toString() {
            return "Part-time";
        }
    },
    CONTRACTOR {
        @Override
        public String toString() {
            return "Contractor";
        }
    },
    SELFEMPLOYED {
        @Override
        public String toString() {
            return "Self-employed";
        }
    },
    INTERNSHIP {
        @Override
        public String toString() {
            return "Internship";
        }
    },

}
