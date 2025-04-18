package org.skypro.skyshop.Comparators;

import org.skypro.skyshop.Interfaces.Searchable;

import java.util.Comparator;

public class ContentComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        return o1.getContentType().compareTo(o2.getContentType());
    }
}
