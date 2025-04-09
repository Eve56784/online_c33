package hw30patterns;

import java.util.ArrayList;
import java.util.List;

public class Builder {
    public static void main(String[] args) {
        Sentence customSentence = new SentenceBuilder()
                .addWord("我")
                .addWord("在")
                .addWord("地铁")
                .addWord("上")
                .build();

        System.out.println(customSentence.getSentence());
    }
}

class Sentence {
    private final List<String> words;

    public Sentence(List<String> words) {
        this.words = words;
    }

    public String getSentence() {
        return String.join("", words);
    }
}

class SentenceBuilder {
    private final List<String> words = new ArrayList<>();

    public SentenceBuilder addWord(String word) {
        words.add(word);
        return this;
    }

    public Sentence build() {
        return new Sentence(words);
    }
}
