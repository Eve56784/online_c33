package hw30patterns;

public class AbstractFactory {
    public static void main(String[] args) {
        ChineseDictionary dictionary = ChineseDictionary.getDictionary();
        System.out.println("Word:\nChinese:"+ dictionary.searchWords("chinese"));
        System.out.println("Word:\nEnglish:"+ dictionary.searchWords("ENGLISH"));
        System.out.println("Word:\nRussian:"+ dictionary.searchWords("russian"));
    }
}

class ChineseDictionary{
    private static ChineseDictionary dictionary;
    private ChineseDictionary() {
        System.out.println("Dictionary is being downloaded");
    }

    public static ChineseDictionary getDictionary() {
        if (dictionary == null) {
            dictionary = new ChineseDictionary();
        }
        return dictionary;
    }

    public String searchWords(String word){
        return switch (word.toLowerCase()) {
            case "chinese" -> "汉语|中文";
            case "japanese" -> "日本语|日语";
            case "english" -> "英语|美语";
            default -> "word not found";
        };
    }
}