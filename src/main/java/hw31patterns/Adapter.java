package hw31patterns;

interface ChineseTranslator{
    String convertToSimplified(String text);
    String convertToTraditional(String text);
}

public class Adapter {
    public static void main(String[] args) {
        MockChineseLibrary library = new MockChineseLibrary();
        MockChineseLibraryAdapter adapter = new MockChineseLibraryAdapter(library);
        System.out.println(adapter.convertToSimplified("彥陽是大學生"));
        System.out.println(adapter.convertToTraditional("彦阳是大学生"));
    }
}

class MockChineseLibrary{
    public String convertText(String text, boolean toSimplified){
        if(toSimplified)
            return text.replace("學","学").replace("彥陽","彦阳");
        else
            return text.replace("学","學").replace("彦阳","彥陽");
    }
}

class MockChineseLibraryAdapter implements ChineseTranslator{

    private final MockChineseLibrary library;

    public MockChineseLibraryAdapter(MockChineseLibrary library) {
        this.library = library;
    }
    
    public String convertToSimplified(String text){
        return library.convertText(text, true);
    }

    public String convertToTraditional(String text){
        return library.convertText(text, false);
    }
}
