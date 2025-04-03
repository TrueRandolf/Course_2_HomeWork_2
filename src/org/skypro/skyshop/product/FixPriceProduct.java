package org.skypro.skyshop.product;

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

}
