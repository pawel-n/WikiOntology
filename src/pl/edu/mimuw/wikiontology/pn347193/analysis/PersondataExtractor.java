package pl.edu.mimuw.wikiontology.pn347193.analysis;

import java.util.regex.Pattern;
import pl.edu.mimuw.wikiontology.pn347193.Article;

/**
 * Extracts Persondata metadata from a wiki article.
 *
 * Dependencies: none.
 * Result: whether the article contains a Persondata template.
 */
public class PersondataExtractor implements Analysis<Boolean> {

    /**
     * Singleton reference of PersondataExtractor.
     */
    private static PersondataExtractor instance;

    /**
     * @return Singleton instance of PersondataExtractor.
     */
    public static PersondataExtractor getInstance() {
        if (instance == null) {
            instance = new PersondataExtractor();
        }
        return instance;
    }

    private final Pattern pattern;

    protected PersondataExtractor() {
        pattern = Pattern.compile("\\{\\{Persondata([^\\}]*)\\}\\}");
    }
 
    @Override
    public Boolean process(Article article) {
        return pattern.matcher(article.getText()).find();
    }

}