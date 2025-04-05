package hw26_solid.interface_segregation;

interface ChineseService {
    void translateToChinese(String text);
    void learnChengYu(String phrase);
    void printChineseCharacters(String chars);
}

class BasicChineseProcessor implements ChineseService {
    @Override
    public void translateToChinese(String text) {
        System.out.println("Translation to Chinese: " + text);
    }

    @Override
    public void learnChengYu(String phrase) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void printChineseCharacters(String chars) {
        throw new UnsupportedOperationException("Not implemented");
    }

}

public class Wrong{
    public static void main(String[] args) {
        BasicChineseProcessor processor = new BasicChineseProcessor();
        String text = "太阳 - sun";
        processor.translateToChinese(text);
        processor.learnChengYu(text);
    }
}
