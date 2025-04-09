package hw30patterns;

interface Dictionary{
    String searchWords(String word);
}

class ChineseDictionary1 implements Dictionary{
    @Override
    public String searchWords(String word) {
        switch(word.toLowerCase()){
            case "opportunity": return "机会";
            case "salary": return "工资";
            default: return "word not found";
        }
    }
}

class RussianDictionary implements Dictionary{
    @Override
    public String searchWords(String word) {
        return switch (word.toLowerCase()) {
            case "возможность" -> "opportunity";
            case "зарплата" -> "salary";
            default -> "word not found";
        };
    }
}

class DictionaryFactory{
    public static Dictionary getDictionary(String lang){
        return switch (lang.toLowerCase()) {
            case "chinese" -> new ChineseDictionary1();
            case "russian" -> new RussianDictionary();
            default -> throw new IllegalArgumentException("language not supported");
        };
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        DictionaryFactory factory = new DictionaryFactory();
        Dictionary dictionary1 = factory.getDictionary("chinese");
        Dictionary dictionary2 = factory.getDictionary("russian");
        System.out.println("Chinese dictionary:\nOpportunity - "+dictionary1.searchWords("Opportunity"));
        System.out.println("English dictionary:\nзарплата - " + dictionary2.searchWords("зарплата"));
    }
}
