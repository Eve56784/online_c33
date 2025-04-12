package hw31patterns;

public class Facade {
    public static void main(String[] args) {
        ChineseProcessingFacade processingFacade = new ChineseProcessingFacade();
        processingFacade.processText("哈罗世界");
    }
}

class MockTranslation{
    String translate(String text){
        return "Translated: "+"Hello world";
    }
}

class MockTransliteration{
    String transliterate(String text){
        return "Pinyin: "+"ha1 luo2 shi4 jie4";
    }
}

class MockConvertToTraditional{
    String convert(String text){
        return "Traditional: "+"哈羅世界";
    }
}

class ChineseProcessingFacade{
    MockTranslation translator;
    MockTransliteration transliterator;
    MockConvertToTraditional convertorToTraditional;

    ChineseProcessingFacade(){
        this.translator = new MockTranslation();
        this.transliterator = new MockTransliteration();
        this.convertorToTraditional = new MockConvertToTraditional();
    }

    public void processText(String text) {
        System.out.println(translator.translate(text));
        System.out.println(transliterator.transliterate(text));
        System.out.println(convertorToTraditional.convert(text));
    }
}