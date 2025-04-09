package hw30patterns;

interface PrototypeDictionary extends Cloneable{
    PrototypeDictionary clone();
    String searchWord(String word);
}

class ChineseDictionary4 implements PrototypeDictionary{

    @Override
    public PrototypeDictionary clone() {
        try{
            return (PrototypeDictionary) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String searchWord(String word) {
        return switch (word.toLowerCase()) {
            case "opportunity" -> "机会";
            case "salary" -> "工资";
            default -> "word not found";
        };
    }
}

public class Prototype {
    public static void main(String[] args) {
        ChineseDictionary4 dictionary = new ChineseDictionary4();
        PrototypeDictionary dictionaryClone = dictionary.clone();
        System.out.println("Original: Opportunity - " + dictionary.searchWord("opportunity"));
        System.out.println("Cloned: Salary - " + dictionaryClone.searchWord("salary"));

        System.out.println("Is it the same dictionary? "+(dictionary == dictionaryClone));
    }
}
