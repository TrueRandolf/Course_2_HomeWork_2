package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "<" + getName() + ">:<" + price + ">";
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return price == that.price && Objects.equals(getName(), getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), price);
    }
}
