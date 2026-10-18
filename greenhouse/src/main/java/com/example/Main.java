package com.example;

import com.example.models.Fern;            // Импорт класса папоротника
import com.example.models.FloweringPlant;  // Импорт класса красивоцветущего растения
import com.example.models.HousePlant;      // Импорт базового абстрактного класса
import com.example.models.Succulent;       // Импорт класса суккулента
import com.example.demonstration.Greenhouse; // Импорт класса теплицы

import java.util.List;                     // Импорт интерфейса списка

/**
 * Консольное приложение для демонстрации работы иерархии комнатных растений.
 */
public final class Main {
    // public — доступен из любого пакета
    // final  — от класса НЕЛЬЗЯ наследоваться

    private Main() { }
    // private — конструктор закрыт: никто не может сделать new Main()
    // Пустое тело { } — ничего не делает

    /**
     * Точка входа.
     *
     */
    public static void main(String[] args) {
        // public — JVM должна иметь доступ к методу извне
        // static — вызывается БЕЗ создания объекта
        // void   — ничего не возвращает
        // main   — имя, которое ищет JVM при запуске
        // String[] args — массив аргументов командной строки (может быть пустым)

        Greenhouse greenhouse = new Greenhouse();
        // new Greenhouse() — создаём ОБЪЕКТ теплицы
        // Тип переменной — Greenhouse; имя — greenhouse (camelCase)
        // С этого момента у нас есть пустая теплица с пустым списком plants

        // 10 объектов разных видов
        greenhouse.addPlant(new FloweringPlant("Орхидея Фаленопсис", 45, 7, 4));
        // new FloweringPlant(...) — создаём цветущее растение
        // Параметры: name="Орхидея Фаленопсис", height=45, lifespan=7, floweringTime=4
        // addPlant(...) — ПОЛИМОРФИЗМ: метод принимает HousePlant, а мы даём FloweringPlant

        greenhouse.addPlant(new FloweringPlant("Фиалка", 12, 3, 9));
        // Фиалка: высота 12 см, живёт 3 года, цветёт 9 месяцев

        greenhouse.addPlant(new FloweringPlant("Гибискус", 80, 20, 6));
        // Гибискус: 80 см, 20 лет, 6 месяцев цветения

        greenhouse.addPlant(new FloweringPlant("Антуриум", 55, 5, 3));
        // Антуриум: 55 см, 5 лет, 3 месяца

        greenhouse.addPlant(new Succulent("Алоэ Вера", 35, 12, false));
        // Суккулент: 35 см, 12 лет, БЕЗ колючек (false)

        greenhouse.addPlant(new Succulent("Кактус Эхинокактус", 25, 30, true));
        // Кактус: 25 см, 30 лет, С колючками (true)

        greenhouse.addPlant(new Succulent("Толстянка", 18, 8, false));
        // Толстянка: 18 см, 8 лет, без колючек

        greenhouse.addPlant(new Fern("Нефролепис", 60, 4, "одноклеточные"));
        // Папоротник: 60 см, 4 года, споры одноклеточные

        greenhouse.addPlant(new Fern("Адиантум", 30, 6, "многоклеточные"));
        // Адиантум: 30 см, 6 лет, споры многоклеточные

        greenhouse.addPlant(new Fern("Асплениум", 75, 10, "одноклеточные"));
        // Асплениум: 75 см, 10 лет, споры одноклеточные
        // Итого: 4 цветущих + 3 суккулента + 3 папоротника = 10 растений

        System.out.println("=========================================");
        // println — печатает строку и переводит курсор на новую строку
        // Разделитель для визуального оформления вывода

        System.out.println("1. ВСЕ КРАСИВОЦВЕТУЩИЕ РАСТЕНИЯ:");
        // Заголовок первого отчёта

        System.out.println("=========================================");
        // Закрывающий разделитель

        List<FloweringPlant> flowering = greenhouse.getFloweringPlants();
        // getFloweringPlants() возвращает List<FloweringPlant> — только цветущие
        // Локальная переменная flowering хранит результат

        flowering.forEach(System.out::println);
        // forEach — встроенный метод списка: применяет действие к каждому элементу
        // System.out::println — ССЫЛКА НА МЕТОД (method reference)
        //   сокращение для лямбды: element -> System.out.println(element)
        // Каждый элемент печатается через toString() → getInfo() (ПОЛИМОРФИЗМ)

        System.out.println();
        // Пустая строка — визуальный отступ между отчётами

        System.out.println("=========================================");
        System.out.println("2. РАСТЕНИЯ С ПРОДОЛЖИТЕЛЬНОСТЬЮ ЖИЗНИ < 5 ЛЕТ:");
        System.out.println("=========================================");

        List<HousePlant> shortLived = greenhouse.getPlantsWithLifespanLessThan(5);
        // Передаём порог 5 лет; метод вернёт список ВСЕХ растений с lifespan < 5
        // Среди наших данных подойдут: Фиалка (3), Нефролепис (4)

        shortLived.forEach(System.out::println);
        // Печатаем каждое найденное растение

        System.out.println();
        System.out.println("=========================================");

        double threshold = 40.0;
        // Локальная переменная — порог высоты для папоротников
        // double — дробное число; выбрали 40.0 см

        System.out.printf("3. ПАПОРОТНИКИ ВЫШЕ %.1f см:%n", threshold);
        // printf — форматированный вывод (в отличие от println)
        // %.1f — подставит double с ОДНИМ знаком после точки → "40,0" (или "40.0")
        // %n   — перенос строки (платформозависимый аналог \n)
        // threshold — подставляется вместо %.1f

        System.out.println("=========================================");

        List<Fern> tallFerns = greenhouse.getFernsTallerThan(threshold);
        // Получаем папоротники выше 40 см
        // Среди наших: Нефролепис (60), Асплениум (75) — оба подойдут
        //                Адиантум (30) — НЕ подойдёт

        tallFerns.forEach(System.out::println);
        // Печатаем каждый найденный папоротник

        System.out.println();
        System.out.println("=========================================");
        System.out.println("4. ВСЕ РАСТЕНИЯ ТЕПЛИЦЫ:");
        System.out.println("=========================================");

        greenhouse.getAllPlants().forEach(System.out::println);
        // getAllPlants() возвращает КОПИЮ списка всех растений
        // Сразу у результата вызываем forEach — переменная не нужна
        // ЦЕПОЧКА ВЫЗОВОВ (method chaining): метод → метод → метод
    }
}