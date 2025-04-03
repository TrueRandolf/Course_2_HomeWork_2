package org.skypro.skyshop.Article;

import org.skypro.skyshop.Interfaces.Searchable;

import java.util.Objects;

public class Article implements Searchable {

    private final String articleTitle;
    private final String articleText;

    public Article(String articleTitle, String articleText) {
        this.articleTitle = articleTitle;
        this.articleText = articleText;
    }

    @Override
    public String getName() {
        return articleTitle;
    }

    @Override
    public String toString() {
        //return "\nстатья: " + articleTitle + "\n" + "текст: " + articleText;
        return "статья: " + articleTitle + "\n" + "текст: " + articleText;
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

    @Override
    public int hashCode() {
        return Objects.hashCode(articleTitle);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleTitle, article.articleTitle);
    }

}