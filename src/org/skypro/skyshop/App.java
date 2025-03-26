package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.SearchEngine.SearchEngine;

import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        final int storageSize = 10;
        String searchString = "Шуруп";

        System.out.println(">создание хранилища вместимостью " + storageSize + " элементов");
        SearchEngine thatStorage = new SearchEngine(storageSize);
        System.out.println(">создано");
        System.out.println();

        System.out.println(">Поиск в пустом хранилище по вхождению \"" + searchString + "\":");
        System.out.println(Arrays.toString(thatStorage.searchObj(searchString)));
        System.out.println();

        System.out.println(">добавление новых элементов");
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
                "Гвоздь - крепежный метиз для неразъемных соедниений деревянных деталей"));
        thatStorage.addNewObject(new Article("Болт",
                "Болт - крепежный метиз для разъемных соединений деревянных или металлических деталей"));
        thatStorage.addNewObject(new FixPriceProduct("Шуруп"));
        thatStorage.addNewObject(new SimpleProduct("Гровер", 100));
        System.out.println(">добавление элементов завершено");
        System.out.println();

        System.out.println(">Поиск в заполненном хранилище по вхождению \"" + searchString + "\"");
        System.out.println(Arrays.toString(thatStorage.searchObj(searchString)));
        System.out.println();


        searchString = "Рымболт";
        System.out.println(">Поиск в заполненном хранилище по вхождению \"" + searchString + "\"");
        System.out.println(Arrays.toString(thatStorage.searchObj(searchString)));
        System.out.println();

        searchString = "Болт";
        System.out.println(">Поиск в заполненном хранилище по вхождению \"" + searchString + "\"");
        System.out.println(Arrays.toString(thatStorage.searchObj(searchString)));
        System.out.println();

        searchString = "Гвоздь";
        System.out.println(">Поиск в заполненном хранилище по вхождению \"" + searchString + "\"");
        System.out.println(Arrays.toString(thatStorage.searchObj(searchString)));
        System.out.println();

    }

}