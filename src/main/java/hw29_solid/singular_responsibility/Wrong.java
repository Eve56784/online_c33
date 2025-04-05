package hw29_solid.singular_responsibility;

public class Wrong {
    public static void main(String[] args) {
        String text = "To add oil to the fire";
        String phrase = "火上加油//火上浇油";
        String chars = "火 - fire\n上 - on\n加/浇 - add/pour\n油 - fuel";
        Chinese chineseHelper = new Chinese();
        chineseHelper.translateToChinese(text);
        chineseHelper.dailyChengYu(phrase);
        chineseHelper.printChineseCharacters(chars);
    }
}

class Chinese {
    public void translateToChinese(String text) {
        System.out.println("Translation to Chinese: " + text);
    }

    public void dailyChengYu(String phrase) {
        System.out.println("Daily 成语: " + phrase);
    }

    public void printChineseCharacters(String chars) {
        System.out.println("Chinese characters:\n" + chars);
    }
}