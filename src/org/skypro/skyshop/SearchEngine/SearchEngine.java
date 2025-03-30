package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exeptions.BestResultNotFound;
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
        System.out.println("Невозможно добавить еще элемент");
    }

    public Searchable[] searchObj(String searchTerm) {
        System.out.println("Поиск с выводом " + searchLimit + " объектов");
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

    public Searchable searchBestObject(String searchTerm) {
        Searchable bestObject = null;
        int bestFind = 0;
        int subStringCount;
        for (Searchable obj : innerSearchable) {
            if (obj != null &&
                    bestFind < (subStringCount = subStringCount(obj.getSearchTerm(), searchTerm))) {
                bestFind = subStringCount;
                bestObject = obj;
            }
        }
        if (bestObject == null) {
            throw new BestResultNotFound(searchTerm);
        }
        return bestObject;
    }

    private int subStringCount(String str, String subStr) {
        int count = 0;
        int index = 0;
        int subIndex = str.indexOf(subStr, index);
        while (subIndex != -1) {
            count++;
            index = subIndex + subStr.length();
            subIndex = str.indexOf(subStr, index);
        }
        return count;
    }

}