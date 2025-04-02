package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Comparators.ContentComparator;
import org.skypro.skyshop.Comparators.LengthComparator;
import org.skypro.skyshop.Comparators.AlphabeticalComparator;
import org.skypro.skyshop.Exeptions.BestResultNotFound;
import org.skypro.skyshop.Interfaces.Searchable;

import java.util.Comparator;

import java.util.*;

public class SearchEngine {

    Set<Searchable> innerSearchable = new HashSet<>();

    // Этот огород для форматирования TreeSet. Хочу так:
    // Сначала всегда статьи по убыванию длины названия и алфавитном порядке
    // при равной длине назания,
    // потом товары, но строго в алфавитном порядке, без учета длины!
    Comparator scmp = new ContentComparator().
            thenComparing(new LengthComparator().
                    thenComparing(new AlphabeticalComparator()));

    Set<Searchable> innerFormat = new TreeSet<>(scmp);

    public void printAll() {
        if (innerSearchable.isEmpty()) {
            System.out.println("список пуст");
            return;
        }
        for (Searchable tail : innerSearchable) {
            System.out.println(tail);
        }
    }

    public void printAllFormat() {
        if (innerSearchable.isEmpty()) {
            System.out.println("список пуст");
            return;
        }
        innerFormat.addAll(innerSearchable);
        for (Searchable tail : innerFormat) {
            System.out.println(tail);
        }
    }

    public void addNewItem(Searchable searchable) {
        innerSearchable.add(searchable);
    }

    public Set<Searchable> searchItem(String searchItem) {
        Set<Searchable> searchResult = new TreeSet<>(scmp);
        if (innerSearchable.isEmpty()) {
            System.out.println("Не найдено");
            return searchResult;
        }
        for (Searchable search : innerSearchable) {
            if (search.getName().contains(searchItem)) {
                searchResult.add(search);
            }
        }
        return searchResult;
    }


    public Searchable searchBestObject(String searchTerm) {

        if (searchItem(searchTerm).isEmpty()) {
            throw new BestResultNotFound(searchTerm);
        }
        Searchable bestResult = null;
        int bestFind = 0;
        int subStringCount;
        for (Searchable searchObj : searchItem(searchTerm)) {
            //System.out.println(" = " + searchObj.getSearchTerm());
            if (bestFind < (subStringCount = subStringCount(searchObj.getSearchTerm(), searchTerm))) {
                bestFind = subStringCount;
                bestResult = searchObj;
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
