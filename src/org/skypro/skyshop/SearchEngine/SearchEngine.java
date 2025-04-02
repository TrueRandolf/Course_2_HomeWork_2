package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exeptions.BestResultNotFound;
import org.skypro.skyshop.Interfaces.Searchable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    Map<String, LinkedList<Searchable>> innerSearchable = new HashMap<>();

    public void printAll() {
        if (innerSearchable.isEmpty()) {
            System.out.println("пусто");
            return;
        }
        for (LinkedList<Searchable> tail : innerSearchable.values()) {
            for (Searchable searchable : tail) {
                System.out.println(searchable);
            }
        }
    }

    public void addNewItem(Searchable searchable) {
//        Распарсил имя из getSearchTerm()
//        Можно было добавить метод getname() в интерфейс Searchable, как советовал Герман ИИ
//        но он тот еще советник. К тому же:
//            1.умножать сущности без нужды-как-то...
//            2.тяжело в учении - легко в бою (вдруг у меня нет доступа к классу?)
//            3.элементарная задача, на мой взгляд

        String name;
        if (searchable.getContentType().equals("ARTICLE")) {
            String term = searchable.getSearchTerm();
            name = term.substring(0, term.indexOf('\n'));
        } else {
            name = searchable.getSearchTerm();
        }

        if (innerSearchable.containsKey(name)) {
            innerSearchable.get(name).add(searchable);
        } else {
            LinkedList<Searchable> mapTail = new LinkedList<>();
            mapTail.add(searchable);
            innerSearchable.put(name, mapTail);
        }
    }

    public Map<String, LinkedList<Searchable>> searchItem(String searchItem) {
        Map<String, LinkedList<Searchable>> searchResult = new TreeMap<>();
        if (innerSearchable.isEmpty() || !innerSearchable.containsKey(searchItem)) {
            System.out.println("Не найдено");
            return searchResult;
        }
        for (Map.Entry<String, LinkedList<Searchable>> searchMap : innerSearchable.entrySet()) {
            if (searchMap.getKey().contains(searchItem)) {
                searchResult.put(searchMap.getKey(), searchMap.getValue());
            }
        }
        return searchResult;
    }


    public Searchable searchBestObject(String searchTerm) {
        if (innerSearchable.isEmpty()) {
            throw new BestResultNotFound(searchTerm);
        }
        Searchable bestResult = null;
        int bestFind = 0;
        int subStringCount;
        for (LinkedList<Searchable> searchList : innerSearchable.values()) {
            for (Searchable searchObj : searchList) {
                if (bestFind < (subStringCount = subStringCount(searchObj.getSearchTerm(), searchTerm))) {
                    bestFind = subStringCount;
                    bestResult = searchObj;
                }
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