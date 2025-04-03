package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Comparators.ContentComparator;
import org.skypro.skyshop.Comparators.LengthComparator;
import org.skypro.skyshop.Comparators.AlphabeticalComparator;
import org.skypro.skyshop.Exeptions.BestResultNotFound;
import org.skypro.skyshop.Interfaces.Searchable;

import java.util.Comparator;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

    Set<Searchable> innerSearchable = new HashSet<>();

    // Этот огород для форматирования TreeSet. Хочу так:
    // Сначала всегда статьи по убыванию длины названия и алфавитном порядке
    // при равной длине назания,
    // потом товары, но строго в алфавитном порядке, без учета длины!
    Comparator<Searchable> searchComp = new ContentComparator().
            thenComparing(new LengthComparator().
                    thenComparing(new AlphabeticalComparator()));

    public void printAll() {
        if (innerSearchable.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        innerSearchable.stream().forEach(System.out::println);
    }

    public void printAllFormat() {
        if (innerSearchable.isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        innerSearchable.stream().sorted(searchComp).forEach(System.out::println);
    }

    public void addNewItem(Searchable searchable) {
        innerSearchable.add(searchable);
    }

    public Set<Searchable> searchItem(String searchItem) {
        TreeSet<Searchable> result = innerSearchable.stream()
                .filter(s -> s.getName().contains(searchItem))
                .collect(Collectors.toCollection(() -> new TreeSet<>(searchComp)));
        if(result.isEmpty()){
            System.out.println("Список пуст");
        }
        return result;
    }

    public Searchable searchBestObject(String searchTerm) {
        if (innerSearchable.isEmpty()) {
            throw new BestResultNotFound(searchTerm);
        }
        Searchable bestResult = null;
        int bestFind = 0;
        int subStringCount;
        for (Searchable searchObj : innerSearchable) {
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
