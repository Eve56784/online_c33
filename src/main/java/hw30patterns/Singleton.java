package hw30patterns;

public class Singleton {
    public static void main(String[] args) {
        ChineseDictionary3 dictionary1 = ChineseDictionary3.getInstance();
        System.out.println("Opportunity - " + dictionary1.searchWord("opportunity"));
        ChineseDictionary3 dictionary2 = ChineseDictionary3.getInstance();
        System.out.println("Is it the same dictionary? " + (dictionary2 == dictionary1));
    }
}

class ChineseDictionary3 {
    private static ChineseDictionary3 instance;
    private ChineseDictionary3() {
        System.out.println("Dictionary is being downloaded");
    }

    public static ChineseDictionary3 getInstance() {
        if (instance == null) {
            instance = new ChineseDictionary3();
        }
        return instance;
    }

    public String searchWord(String word) {
        return switch (word.toLowerCase()) {
            case "opportunity" -> "机会";
            case "salary" -> "工资";
            default -> "word not found";
        };
    }
}
