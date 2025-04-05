package hw26_solid.singular_responsibility;

public class Right {
    public static void main(String[] args) {
        String text = "To add oil to the fire";
        String phrase = "火上加油//火上浇油";
        String chars = "火 - fire\n上 - on\n加/浇 - add/pour\n油 - fuel";

        ChineseTranslator translator = new ChineseTranslator();
        translator.translateToChinese(text);

        ChengYuService chengYu = new ChengYuService();
        chengYu.displayDailyChengYu(phrase);

        ChineseCharacterPrinter printer = new ChineseCharacterPrinter();
        printer.printChineseCharacters(chars);
    }
}

class ChineseTranslator {
    public void translateToChinese(String text) {
        System.out.println("Translation to Chinese: " + text);
    }
}

class ChengYuService {
    public void displayDailyChengYu(String phrase) {
        System.out.println("Daily 成语: " + phrase);
    }
}

class ChineseCharacterPrinter {
    public void printChineseCharacters(String chars) {
        System.out.println("Chinese characters:\n" + chars);
    }
}