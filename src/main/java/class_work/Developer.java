package class_work;

import java.util.ArrayList;
import java.util.List;

public class Developer {
    private final String language;
    private final int experience;
    private final String level;
    private final boolean hasDegree;
    private final List<String> frameworks;

    private Developer(Builder builder) {
        this.language = builder.language;
        this.experience = builder.experience;
        this.level = builder.level;
        this.hasDegree = builder.hasDegree;
        this.frameworks = builder.frameworks;
    }

    public static Builder builder(String language) {
        return new Builder(language);
    }

    public static class Builder {
        private final String language;
        private int experience = 0;
        private String level = "Junior";
        private boolean hasDegree = false;
        private List<String> frameworks = new ArrayList<>();

        public Builder(String language) {
            this.language = language;
        }

        public Builder experience(int years) {
            if (years < 0)
                throw new IllegalArgumentException("Experience can't be negative");
            this.experience = years;
            return this;
        }

        public Builder level(String level) {
            this.level = level;
            return this;
        }

        public Builder hasDegree(boolean hasDegree) {
            this.hasDegree = hasDegree;
            return this;
        }

        public Builder framework(String framework) {
            this.frameworks.add(framework);
            return this;
        }

        public Developer build() {
            validate();
            return new Developer(this);
        }

        private void validate() {
            if (language == null || language.isEmpty()) {
                throw new IllegalStateException("Language is required");
            }
        }
    }

    public String getLanguage() {
        return language;
    }

    public int getExperience() {
        return experience;
    }

    public String getLevel() {
        return level;
    }

    public boolean hasDegree() {
        return hasDegree;
    }

    public List<String> getFrameworks() {
        return frameworks;
    }

    @Override
    public String toString() {
        return String.format("Developer [Language: %s, Experience: %d years, Level: %s, Degree: %s, Frameworks: %s]",
                language, experience, level, hasDegree ? "Yes" : "No", frameworks);
    }

    public static void main(String[] args) {
        Developer javaDev = Developer
                .builder("Java")
                .experience(5)
                .level("Senior")
                .hasDegree(true)
                .framework("Spring")
                .framework("Hibernate")
                .build();

        Developer pythonDev = Developer
                .builder("Python")
                .experience(2)
                .framework("Django")
                .build();

        System.out.println(javaDev);
        System.out.println(pythonDev);
    }
}