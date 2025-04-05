package hw26_solid.liskov_substitution;

class LanguageProcessor {
    public void process(String input) {
        System.out.println("Processing language input: " + input);
    }
}

class ChineseProcessor extends LanguageProcessor {
    @Override
    public void process(String input) {
        throw new UnsupportedOperationException("Cannot process input in this way");
    }
}

public class Wrong {
    public static void main(String[] args) {
        LanguageProcessor processor = new ChineseProcessor();
        processor.process("你好");
    }
}
