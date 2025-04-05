package hw29solid.dependency_inversion;

class ChineseTranslator {
    public void translate(String text) {
        System.out.println("Translation to Chinese: " + text);
    }
}

public class Wrong {
    public static void main(String[] args) {
        ChineseTranslator translator = new ChineseTranslator();
        translator.translate("to seek one's own doom");
    }
}
