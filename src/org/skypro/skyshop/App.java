package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        System.out.println(">создание корзины (5 товаров)");
        ProductBasket thatBasket = new ProductBasket();

        System.out.println(">добавление одного товара");
        thatBasket.addProductToBasket(new SimpleProduct("Шайба", 100));
        System.out.println(">печать содержимого корзины");
        thatBasket.printBasket();
        System.out.println();

        System.out.println(">наполнение корзины до предела (всего 5 товаров)");
        thatBasket.addProductToBasket(new SimpleProduct("Гайка", 200));
        thatBasket.addProductToBasket(new DiscountProduct("Винт", 300, 10));
        thatBasket.addProductToBasket(new FixPriceProduct("Болт"));
        thatBasket.addProductToBasket(new FixPriceProduct("Саморез"));
        System.out.println(">печать содержимого корзины");
        thatBasket.printBasket();
        System.out.println();

        System.out.println(">добавление еще одного товара, сверх возможного");
        thatBasket.addProductToBasket(new SimpleProduct("Изолента", 600));
        System.out.println(">корзина заполнена, нет возможности добавить товар");

        System.out.println(">печать содержимого корзины");
        thatBasket.printBasket();
        System.out.println();

        System.out.print(">общая стоимость корзины = ");
        System.out.println(thatBasket.getSumPrice());
        System.out.println();

        SimpleProduct examProduct = new SimpleProduct("Шуруп", 250);
        System.out.print(">проверка наличия в корзине товара: " + examProduct + " ");
        System.out.println(thatBasket.getIsProductInBasket(examProduct));
        System.out.println();

        examProduct = new SimpleProduct("Гайка", 200);
        System.out.print(">проверка наличия в корзине товара: " + examProduct + " ");
        System.out.println(thatBasket.getIsProductInBasket(examProduct));
        System.out.println();

        System.out.println(">очистка корзины");
        thatBasket.clearBasket();

        System.out.println(">печать содержимого пустой корзины");
        thatBasket.printBasket();

        System.out.print(">общая стоимость пустой корзины: ");
        System.out.println(thatBasket.getSumPrice());

        examProduct = new SimpleProduct("Гайка", 200);
        System.out.print(">проверка наличия в пустой корзине товара: " + examProduct + " ");
        System.out.println(thatBasket.getIsProductInBasket(examProduct));
        System.out.println();
    }
}
