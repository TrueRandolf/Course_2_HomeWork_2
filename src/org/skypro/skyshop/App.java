package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Exeptions.BestResultNotFound;
import org.skypro.skyshop.SearchEngine.SearchEngine;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        try {
            productBasketDemo("Гвоздь");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println();
        }
        try {
            searchEngineDemo("Болт2");
            searchEngineDemo("Гвоздь");
        } catch (BestResultNotFound e) {
            System.out.println("e = " + e);
        }

    }

    public static void searchEngineDemo(String searchString) {
        SearchEngine thatStorage = new SearchEngine();
        System.out.println(">РАБОТА С SEARCHENGINE:");
        System.out.println(">добавление элементов метод addNewItem :");
        thatStorage.addNewItem(new FixPriceProduct("Глухарь"));
        thatStorage.addNewItem(new DiscountProduct("Рымболт", 500, 5));
        //Оставлено для проверки! Не комментарии!
        //thatStorage.addNewItem(new SimpleProduct("Шайба", 100));
        //thatStorage.addNewItem(new FixPriceProduct("Саморез"));
        //thatStorage.addNewItem(new DiscountProduct("Винт", 100, 10));
        //thatStorage.addNewItem(new SimpleProduct("Болт М5", 10));
        thatStorage.addNewItem(new SimpleProduct("Болт", 15));
        thatStorage.addNewItem(new SimpleProduct("Болт", 20));
        thatStorage.addNewItem(new SimpleProduct("Болт", 30));
        thatStorage.addNewItem(new SimpleProduct("Болт", 80));
        thatStorage.addNewItem(new SimpleProduct("Болт", 100));
        thatStorage.addNewItem(new SimpleProduct("Болт", 130));
        thatStorage.addNewItem(new SimpleProduct("Болт", 150));
        thatStorage.addNewItem(new Article("Болт",
                "Болт - не Гвоздь. Гвоздь - не Болт."));
        thatStorage.addNewItem(new DiscountProduct("Гвоздь", 50, 20));
        thatStorage.addNewItem(new Article("Гвоздь",
                "Гвоздь Гвоздь - недостаточно гвоздей для критерия BestResult"));
        thatStorage.addNewItem(new Article("Гвоздь",
                "Гвоздь Гвоздь Гвоздь Гвоздь Гвоздь - такое многообразие гвоздей в статье введено для демонстрации BestResult"));
        thatStorage.addNewItem(new FixPriceProduct("Шуруп"));
        thatStorage.addNewItem(new SimpleProduct("Гровер", 100));
        System.out.println(">добавление элементов завершено");
        System.out.println();


        System.out.println(">простой поиск с выводом всех объектов по вхождению в любом поле \"" + searchString + "\" метод searchItem ");
        if (!thatStorage.searchItem(searchString).isEmpty()) {
            System.out.println(thatStorage.searchItem(searchString));
        }
        System.out.println();

        System.out.println(">поиск наибольшего количества совпадений по вхождению \"" + searchString + "\" searchBestObject ");
        try {
            System.out.println(thatStorage.searchBestObject(searchString));
        } catch (BestResultNotFound e) {
            System.out.println("Не найдено " + e);
        }
        System.out.println();
    }


    public static void productBasketDemo(String searchString) {
        ProductBasket productBasket = new ProductBasket();
        System.out.println(">РАБОТА С PRODUCTBASKET:");
        System.out.println(">добавление товаров в корзину, метод addToBasket:");
        productBasket.addToBasket(new SimpleProduct("Шайба", 100));
        productBasket.addToBasket(new FixPriceProduct("Саморез"));
        productBasket.addToBasket(new DiscountProduct("Винт", 100, 10));
        productBasket.addToBasket(new SimpleProduct("Болт", 5));
        productBasket.addToBasket(new SimpleProduct("Болт", 6));
        productBasket.addToBasket(new SimpleProduct("Болт", 10));
        productBasket.addToBasket(new SimpleProduct("Болт", 20));
        productBasket.addToBasket(new DiscountProduct("Гвоздь", 50, 20));
        productBasket.addToBasket(new FixPriceProduct("Шуруп"));
        System.out.println(">добавление товаров в корзину завершено");

        System.out.println(">вывод всей корзины, метод printBasket()");
        productBasket.printBasket();
        System.out.println();

        System.out.println(">удаление группы товаров по названию \"" + searchString + "\" из корзины метод removeProductFromBasket(String): ");
        System.out.println(">удалены товары: " + productBasket.removeProductFromBasket(searchString));

        System.out.println(">вывод всей корзины (проверка удачного удаления)");
        productBasket.printBasket();
        System.out.println();

        System.out.println("> повторное удаление (уже удаленной) группы товаров по названию \"" + searchString + "\" из корзины");
        if (!productBasket.removeProductFromBasket(searchString).isEmpty()) {
            System.out.println(">удалены товары: " + productBasket.removeProductFromBasket(searchString));
        }
        System.out.println();
        System.out.println(">вывод всей корзины (проверка неудачного удаления)");
        productBasket.printBasket();
        System.out.println();

        System.out.println(">полная очистка корзины метод clearBasket()");
        productBasket.clearBasket();
        System.out.println(">вывод всей корзины (проверка очистки)");
        productBasket.printBasket();
        System.out.println();

        System.out.println("добавление неправильно созданного товара в корзину (проверка IllegalArgumentException)");
        productBasket.addToBasket(new DiscountProduct("ds", 100, -10));

    }
}

