package com.example.models; // Объявление пакета

/**
 * Класс, описывающий папоротник.
 * <p>
 * Дополнительно содержит тип спор, характерный для данного папоротника.
 * </p>
 */
public class Fern extends HousePlant {
    // public  — доступен из любого пакета
    // class   — объявление класса
    // extends — НАСЛЕДОВАНИЕ: Fern получает методы родителя HousePlant

    /** Тип спор папоротника. */
    private String sporeType;
    // private — доступно только внутри класса (инкапсуляция)
    // String  — тип поля; sporeType — имя в camelCase

    /**
     * Конструктор.
    */
    public Fern(String name, double height, int lifespan, String sporeType) {
        // public — конструктор доступен извне

        super(name, height, lifespan);
        // super — вызов КОНСТРУКТОРА РОДИТЕЛЯ (HousePlant)

        if (sporeType == null || sporeType.isBlank()) {
            // Валидация «fail fast»
            // null        — проверка на отсутствие значения
            // isBlank()   — true, если строка пустая или состоит только из пробелов

            throw new IllegalArgumentException("Тип спор не может быть пустым");
            // throw — «бросить» исключение
            // new - оператор создания объекта
            // IllegalArgumentException — сигнал: передан неверный аргумент
            // Объект НЕ будет создан
        }

        this.sporeType = sporeType;
        // this.sporeType — поле текущего объекта
        // sporeType       — параметр конструктора
        // this нужен, потому что имена совпадают
    }

      public String getSporeType() {
        // public    — доступен извне
        // String    — тип возвращаемого значения
        // getSporeType — геттер в camelCase
        // Геттер нужен, потому что поле private (инкапсуляция)

        return sporeType;
        // Возвращаем значение поля
    }

       @Override
    public String getInfo() {
        // @Override — сообщает компилятору, что мы ПЕРЕОПРЕДЕЛЯЕМ метод родителя
        //             Компилятор проверит, что такой метод действительно есть в HousePlant
        //             (защита от опечаток в имени)
        // public    — нельзя сузить видимость родителя (у него тоже public)
        // String    — тот же тип возврата, что у родителя

        return super.getInfo() + ", тип спор: " + sporeType;
        // super.getInfo() — вызываем РОДИТЕЛЬСКУЮ реализацию, чтобы не дублировать код
        //                   она вернёт: "Название: ..., высота: ..., продолжительность жизни: ..."
        // + ", тип спор: " — конкатенация строк
        // + sporeType      — добавляем специфичное поле
        // Итог: базовая информация + дополнение от папоротника
    }
}