package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountProduct extends Product {
    private String name = getName();
    private int basePrice;
    private int discountPercent;
    private int discountPrice;

    public DiscountProduct(String name, int basePrice, int discountPercent) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
        this.discountPrice = basePrice - basePrice * discountPercent / 100;
    }

    @Override
    public int getPrice() {
        return discountPrice;
    }

    @Override
    public String toString() {
        return "<" + name + ">:<" + discountPrice + ">(<" + discountPercent + ">%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return basePrice == that.basePrice && discountPercent == that.discountPercent && discountPrice == that.discountPrice && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, basePrice, discountPercent, discountPrice);
    }
}
