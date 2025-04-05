package hw29_solid.dependency_inversion;

interface Translator {
    void translate(String text);
}

class ChineseTranslatorRight implements Translator {
    @Override
    public void translate(String text) {
        System.out.println("Translation to Chinese: " + text);
    }
}

public class Right {
    private Translator translator;

    public Right(Translator translator) {
        this.translator = translator;
    }

    public void performTranslation(String text) {
        translator.translate(text);
    }

    public static void main(String[] args) {
        Translator chineseTranslator = new ChineseTranslatorRight();
        Right right = new Right(chineseTranslator);
        right.performTranslation("to seek one's own doom");
    }
}
