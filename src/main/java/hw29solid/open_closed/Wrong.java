package hw29solid.open_closed;

public class Wrong {
    public static void main(String[] args) {
        Chinese chineseHelper = new Chinese();
        chineseHelper.processChinese("chengyu", "飞蛾扑火");
    }
}

class Chinese{
    public void processChinese(String type, String input) {
        if (type.equals("translate")) {
            System.out.println("Translation to Chinese: " + input);
        } else if (type.equals("chengyu")) {
            System.out.println("Daily 成语: " + input);
        } else if (type.equals("characters")) {
            System.out.println("Chinese characters: " + input);
        }
    }
}

