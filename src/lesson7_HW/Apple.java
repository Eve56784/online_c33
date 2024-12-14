package lesson7_HW;

public class Apple {
        private String colour;

        public Apple(String colour) {
            this.colour = colour;
        }

        public void changeColour(String newColour) {
            this.colour = newColour;
        }

        public String getCurrentColour() {
            return this.colour;
        }
    }