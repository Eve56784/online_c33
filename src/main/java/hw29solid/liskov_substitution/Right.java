package hw29solid.liskov_substitution;

abstract class LanguageProcessorRight {
    public abstract void process(String input);
}

class GeneralProcessor extends LanguageProcessorRight {
    @Override
    public void process(String input) {
        System.out.println("Processing language input: " + input);
    }
}

class ChineseProcessorRight extends LanguageProcessorRight {
    @Override
    public void process(String input) {
        System.out.println("Processing Chinese input: " + input);
    }
}

public class Right {
    public static void main(String[] args) {
        LanguageProcessorRight generalProcessor = new GeneralProcessor();
        generalProcessor.process("Hello");

        LanguageProcessorRight chineseProcessor = new ChineseProcessorRight();
        chineseProcessor.process("哈罗");
    }
}
