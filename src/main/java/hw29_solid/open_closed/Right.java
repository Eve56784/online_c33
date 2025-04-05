package hw29_solid.open_closed;

abstract class ChineseAbstract {
    public abstract void execute(String input);
}

class ChineseTranslator extends ChineseAbstract {
    @Override
    public void execute(String text) {
        System.out.println("Translation to Chinese: " + text);
    }
}

class ChengYuService extends ChineseAbstract {
    @Override
    public void execute(String phrase) {
        System.out.println("Daily 成语: " + phrase);
    }
}

class ChineseCharacterPrinter extends ChineseAbstract {
    @Override
    public void execute(String chars) {
        System.out.println("Chinese characters:\n" + chars);
    }
}

public class Right {
    public static void main(String[] args) {
        ChineseAbstract translator = new ChineseTranslator();
        ChineseAbstract chengYu = new ChengYuService();
        ChineseAbstract printer = new ChineseCharacterPrinter();

        translator.execute("to seek one's own doom");
        chengYu.execute("飞蛾扑火");
        printer.execute("飞 - to fly\n蛾 - moss\n扑 - to pounce on\n火 - fire");
    }
}
