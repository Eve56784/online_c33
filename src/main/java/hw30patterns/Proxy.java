package hw30patterns;

interface ProxyDictionary {
    String searchWords(String word);
}

class RealChineseDictionary implements ProxyDictionary {
    @Override
    public String searchWords(String word) {
        switch (word.toLowerCase()) {
            case "opportunity": return "机会";
            case "salary": return "工资";
            default: return "word not found";
        }
    }
}

class ProxyChineseDictionary implements ProxyDictionary {
    private RealChineseDictionary realDictionary;

    @Override
    public String searchWords(String word) {
        if (realDictionary == null) {
            System.out.println("Real dictionary is being downloaded");
            realDictionary = new RealChineseDictionary();
        }
        System.out.println("Searching for: " + word);
        return realDictionary.searchWords(word);
    }
}

public class Proxy {
    public static void main(String[] args) {
        ProxyDictionary dictionary = new ProxyChineseDictionary();
        System.out.println("Opportunity - " + dictionary.searchWords("opportunity"));
        System.out.println("Salary - " + dictionary.searchWords("salary"));
    }
}
