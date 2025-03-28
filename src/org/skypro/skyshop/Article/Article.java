package org.skypro.skyshop.Article;

import org.skypro.skyshop.Interfaces.Searchable;

public class Article implements Searchable {

    private final String articleTitle;
    private final String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return "\nстатья: " + articleTitle + "\n" + "текст: " + articleText;
    }

    @Override
    public String getSearchTerm() {
        return articleTitle + "\n" + articleText;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getStringRepresentation() {
        return "имя \"" + articleTitle + "\" тип \"" + getContentType() + "\"";
    }

}