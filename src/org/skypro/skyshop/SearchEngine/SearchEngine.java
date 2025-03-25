package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Interfaces.Searchable;

public class SearchEngine {
    private final Searchable[] innerArray;
    final int SEARCHLIMIT = 5;

    public SearchEngine(int dimension) {
        innerArray = new Searchable[dimension];
    }

    public void addNewObject(Searchable obj) {
        for (int i = 0; i < innerArray.length; i++) {
            if (innerArray[i] == null) {
                innerArray[i] = obj;
                return;
            }
        }
        System.out.println("/Невозможно добавить еще элемент");
    }

    public Searchable[] searchObj(String searchTerm) {
        System.out.println("/Поиск с выводом "+ SEARCHLIMIT + " объектов");
        int searchCounter = 0;
        Searchable[] searchResult = new Searchable[SEARCHLIMIT];
        for (Searchable searchItem : innerArray) {
            if (searchItem != null && searchItem.getSearchTerm().contains(searchTerm)) {
                searchResult[searchCounter++] = searchItem;
            }
            if (searchCounter >= SEARCHLIMIT) {
                break;
            }
        }
        return searchResult;
    }

    public String[] searchRepresent(String searchTerm) {
        System.out.println("/Поиск с выводом "+ SEARCHLIMIT + " обзоров");
        int searchCounter = 0;
        String[] searchResultRepresent = new String[SEARCHLIMIT];
        for (Searchable searchItem : innerArray) {
            if (searchItem != null && searchItem.getSearchTerm().contains(searchTerm)) {
                searchResultRepresent[searchCounter++] = searchItem.getStringRepresentation();
            }
            if (searchCounter >= SEARCHLIMIT) {
                break;
            }
        }
        return searchResultRepresent;
    }

}