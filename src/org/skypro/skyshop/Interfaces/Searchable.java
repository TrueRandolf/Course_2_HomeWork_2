package org.skypro.skyshop.Interfaces;

public interface Searchable {
    default String getSearchTerm() {
        return null;
    }

    default String getContentType() {
        return null;
    }

    default String getStringRepresentation() {
        return null;
    }
}
