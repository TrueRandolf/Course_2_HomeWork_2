package org.skypro.skyshop.product;

import org.skypro.skyshop.Interfaces.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getStringRepresentation() {
        return "имя \"" + name + "\" тип \"" + getContentType() + "\"";
    }
}

