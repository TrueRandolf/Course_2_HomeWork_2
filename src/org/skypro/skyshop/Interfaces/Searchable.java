package org.skypro.skyshop.Interfaces;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        String string = "";
        return "имя \"" + string + "\" тип \"" + getContentType() + "\"";
    }

}
