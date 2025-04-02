package org.skypro.skyshop.Comparators;

import org.skypro.skyshop.Interfaces.Searchable;

import java.util.Comparator;

public class LengthComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        if (o1.getContentType() == "ARTICLE") {
            return o2.getName().length() - o1.getName().length();
        }
        return 0;
    }
}
