package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Exeptions.BestResultNotFound;
import org.skypro.skyshop.SearchEngine.SearchEngine;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        final int storageSize = 10;
        String searchString = "Шуруп";

        System.out.println(">создание хранилища вместимостью " + storageSize + " элементов");
        SearchEngine thatStorage = new SearchEngine(storageSize);
        System.out.println(">создано");
        System.out.println();

        System.out.println(">ДОБАВЛЕНИЕ НОВЫХ ЭЛЕМЕНТОВ");
        System.out.println(">добавление новых элементов с ошибками:");
        System.out.println(">полный вывод ошибки");
        System.out.println(">Простой продукт: цена < 0:");
        try {
            thatStorage.addNewObject(new SimpleProduct("Гвоздь", -10));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println(">Продукт с фиксированной ценой: пустое название:");
        System.out.println(">вывод только сообщения ошибки");
        try {
            thatStorage.addNewObject(new FixPriceProduct(""));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(">Продукт со скидкой: отрицательный процент скидки:");
        System.out.println(">полный вывод ошибки");
        try {
            thatStorage.addNewObject(new DiscountProduct("Рымболт", 100, -10));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println(">исключения обработаны, элементы с ошибкой не внесены");

        System.out.println(">добавление валидных новых элементов:");
        thatStorage.addNewObject(new FixPriceProduct("Глухарь"));
        thatStorage.addNewObject(new DiscountProduct("Рымболт", 500, 5));
        //Оставлено для проверки! Не комментарии!
        //thatStorage.addNewObject(new SimpleProduct("Шайба", 100));
        //thatStorage.addNewObject(new FixPriceProduct("Саморез"));
        //thatStorage.addNewObject(new DiscountProduct("Винт", 100, 10));
        //thatStorage.addNewObject(new SimpleProduct("Болт М5", 10));
        thatStorage.addNewObject(new SimpleProduct("Болт м6", 15));
        thatStorage.addNewObject(new SimpleProduct("Болт М8", 20));
        thatStorage.addNewObject(new SimpleProduct("Болт М10", 30));
        thatStorage.addNewObject(new SimpleProduct("Болт М16", 80));
        thatStorage.addNewObject(new DiscountProduct("Гвоздь", 50, 20));
        thatStorage.addNewObject(new Article("Гвоздь",
                "Гвоздь Гвоздь - надостаточно гвоздей для критерия BestResult"));
        thatStorage.addNewObject(new Article("Гвоздь",
                "Гвоздь Гвоздь Гвоздь Гвоздь Гвоздь - такое многообразие гвоздей в статье введено для демонстрации BestResult"));
        thatStorage.addNewObject(new FixPriceProduct("Шуруп"));
        thatStorage.addNewObject(new SimpleProduct("Гровер", 100));
        System.out.println(">добавление элементов завершено");
        System.out.println();


        System.out.println(">поиск по несуществующему вхождению");
        System.out.println(">полный вывод ошибки + не найдено");
        searchString = "Вертлюг";
        System.out.println(">поиск в хранилище по вхождению \"" + searchString + "\"");
        try {
            System.out.println(thatStorage.searchBestObject(searchString));
        } catch (BestResultNotFound e) {
            System.out.println(e + " -  не найдено");
        }

        System.out.println();
        System.out.println("поиск по существующему вхождению");
        searchString = "Гвоздь";
        System.out.println(">поиск в хранилище по вхождению \"" + searchString + "\"");
        try {
            System.out.println(thatStorage.searchBestObject(searchString));
        } catch (BestResultNotFound e) {
            System.out.println(e + " -  не найдено");
        }

    }

}