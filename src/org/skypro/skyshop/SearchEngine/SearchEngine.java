package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Interfaces.Searchable;

public class SearchEngine {
    private final Searchable[] innerSearchable;
    private final int searchLimit = 5;

    public SearchEngine(int dimension) {
        innerSearchable = new Searchable[dimension];
    }

    public void addNewObject(Searchable obj) {
        for (int i = 0; i < innerSearchable.length; i++) {
            if (innerSearchable[i] == null) {
                innerSearchable[i] = obj;
                return;
            }
        }
        System.out.println("/Невозможно добавить еще элемент");
    }

    public Searchable[] searchObj(String searchTerm) {
        System.out.println("/Поиск с выводом " + searchLimit + " объектов");
        int searchCounter = 0;
        Searchable[] searchResult = new Searchable[searchLimit];
        for (Searchable searchItem : innerSearchable) {
            if (searchItem != null && searchItem.getSearchTerm().contains(searchTerm)) {
                searchResult[searchCounter++] = searchItem;
            }
            if (searchCounter >= searchLimit) {
                break;
            }
        }
        return searchResult;
    }

}