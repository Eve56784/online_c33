package hw31patterns;

interface ConversionStrategy {
    String convert(String text);
}

class MockSimplifiedConversion implements ConversionStrategy {
    @Override
    public String convert(String text) {
        return text.replace("學","学").replace("彥陽","彦阳");
    }
}

class MockTraditionalConversion implements ConversionStrategy {
    @Override
    public String convert(String text) {
        return text.replace("学","學").replace("彦阳","彥陽");
    }
}

class TranslatorContext {
    private ConversionStrategy strategy;

    public void setConversionStrategy(ConversionStrategy strategy) {
        this.strategy = strategy;
    }

    public String convert(String text) {
        return strategy.convert(text);
    }
}

public class Strategy {
    public static void main(String[] args) {
        TranslatorContext context = new TranslatorContext();

        context.setConversionStrategy(new MockSimplifiedConversion());
        System.out.println("Simplified: " + context.convert("彥陽是大學生"));
        context.setConversionStrategy(new MockTraditionalConversion());
        System.out.println("Traditional: " + context.convert("彦阳是大学生"));
    }
}

