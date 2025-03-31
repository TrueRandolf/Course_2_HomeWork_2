package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exeptions.BestResultNotFound;
import org.skypro.skyshop.Interfaces.Searchable;


import java.util.Iterator;
import java.util.LinkedList;

public class SearchEngine {

    LinkedList<Searchable> innerSearchable = new LinkedList<>();


    public void addNewItem(Searchable item) {
        innerSearchable.add(item);
        //System.out.println("added item = " + item);
    }

    public void clearAllItem(){
        innerSearchable.clear();
        System.out.println("Хранилище очищено");
    }

    public LinkedList<Searchable> searchItem(String searchTerm) {
        LinkedList<Searchable> searchResult = new LinkedList<>();
        Iterator<Searchable> iterator = innerSearchable.iterator();
        while (iterator.hasNext()) {
            Searchable item = iterator.next();
            //System.out.println("item.getSearchTerm() = " + item.getSearchTerm());
            if (item.getSearchTerm().contains(searchTerm)) {
                searchResult.add(item);
            }
        }
        if (searchResult.isEmpty()) {
            System.out.println("Не найдено");
        }
        return searchResult;
    }

    public Searchable searchBestObject(String searchTerm) {
        int bestFind = 0;
        int subStringCount;
        Searchable bestResult = null;
        Iterator<Searchable> iterator = innerSearchable.iterator();
        while (iterator.hasNext()) {
            Searchable item = iterator.next();
            if (bestFind < (subStringCount = subStringCount(item.getSearchTerm(), searchTerm))) {
                bestFind = subStringCount;
                bestResult = item;
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFound(searchTerm);
        }
        return bestResult;
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