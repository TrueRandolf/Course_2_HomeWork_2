package org.skypro.skyshop.product;

import java.util.Objects;

public class FixPriceProduct extends Product {
    private static final int PRICE = 260;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return "<" + getName() + ">:Фиксированная цена<" + PRICE + ">";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FixPriceProduct that = (FixPriceProduct) o;
        return Objects.equals(getName(), name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
