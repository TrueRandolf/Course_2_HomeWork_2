package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private final int basePrice;
    private final int discountPercent;
    private final int discountPrice;

    public DiscountProduct(String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice < 1) {
            throw new IllegalArgumentException("Цена продукта должна быть больше 0");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка должна быть в пределах 0-100%");
        }
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

}
