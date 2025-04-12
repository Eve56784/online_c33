package hw31patterns;

interface Translator {
    String translate(String text);
}

public class Decorator {
    public static void main(String[] args) {
        Translator translator = new MockSimpleTranslator();
        Translator toneTranslator = new ToneDecorator(translator);
        Translator fullTranslator = new WordCountDecorator(toneTranslator);

        System.out.println(fullTranslator.translate("哈罗世界"));
    }
}

class MockSimpleTranslator implements Translator {
    @Override
    public String translate(String text) {
        return "Translation: " + "Hello world";
    }
}

abstract class TranslatorDecorator implements Translator {
    protected Translator translator;

    public TranslatorDecorator(Translator translator) {
        this.translator = translator;
    }

    @Override
    public String translate(String text) {
        return translator.translate(text);
    }
}

class ToneDecorator extends TranslatorDecorator {
    public ToneDecorator(Translator translator) {
        super(translator);
    }

    @Override
    public String translate(String text) {
        String baseTranslation = super.translate(text);
        return baseTranslation + "\nPinyin: ha1 luo2 shi4 jie4";
    }
}

class WordCountDecorator extends TranslatorDecorator {
    public WordCountDecorator(Translator translator) {
        super(translator);
    }

    @Override
    public String translate(String text) {
        String baseTranslation = super.translate(text);
        return baseTranslation + "\nCharacter Count: " + text.length();
    }
}
