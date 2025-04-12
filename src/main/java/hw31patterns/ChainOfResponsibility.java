package hw31patterns;

abstract class TextProcessor {
    protected TextProcessor next;

    public void setNext(TextProcessor next) {
        this.next = next;
    }

    public void process(String text) {
        if (next != null) {
            next.process(text);
        }
    }
}
public class ChainOfResponsibility {
    public static void main(String[] args) {
        TextProcessor whitespaceRemover = new WhitespaceRemover();
        TextProcessor punctuationSimplifier = new PunctuationSimplifier();
        TextProcessor transliterationProcessor = new MockTransliterationProcessor();

        whitespaceRemover.setNext(punctuationSimplifier);
        punctuationSimplifier.setNext(transliterationProcessor);
        whitespaceRemover.process("哈罗  ，  世 界。");
    }
}

class WhitespaceRemover extends TextProcessor {
    @Override
    public void process(String text) {
        text = text.replaceAll("\\s+", "");
        System.out.println("Whitespace removed: " + text);
        super.process(text);
    }
}

class PunctuationSimplifier extends TextProcessor {
    @Override
    public void process(String text) {
        text = text.replace("，", ",").replace("。", ".");
        System.out.println("Punctuation simplified: " + text);
        super.process(text);
    }
}

class MockTransliterationProcessor extends TextProcessor {
    @Override
    public void process(String text) {
        System.out.println("Transliteration: Pinyin output for '" + text + "' - ha1 luo2 shi4 jie4");
        super.process(text);
    }
}
