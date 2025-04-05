package hw26_solid.interface_segregation;

interface Translator {
    void translateToChinese(String text);
}

interface ChengYuLearner {
    void learnChengYu(String phrase);
}

interface CharacterPrinter {
    void printChineseCharacters(String chars);
}

class TranslationProcessor implements Translator {
    @Override
    public void translateToChinese(String text) {
        System.out.println("Translation to Chinese: " + text);
    }
}

class ChengYuProcessor implements ChengYuLearner {
    @Override
    public void learnChengYu(String phrase) {
        System.out.println("Learning 成语: " + phrase);
    }
}

class CharacterProcessor implements CharacterPrinter {
    @Override
    public void printChineseCharacters(String chars) {
        System.out.println("Chinese characters:\n" + chars);
    }
}

public class Right {
    public static void main(String[] args) {
        Translator translator = new TranslationProcessor();
        translator.translateToChinese("To add oil to the fire");

        ChengYuLearner chengYu = new ChengYuProcessor();
        chengYu.learnChengYu("火上加油//火上浇油");

        CharacterPrinter printer = new CharacterProcessor();
        printer.printChineseCharacters("火 - fire\n上 - on\n加/浇 - add/pour\n油 - fuel");
    }
}
