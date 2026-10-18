package com.example.models; // Объявление пакета — файл лежит в src/main/java/com/example/models/

/**
 * Класс, описывающий красивоцветущее комнатное растение.
 * <p>
 * Дополнительно содержит продолжительность цветения в месяцах.
 * </p>
 */
public class FloweringPlant extends HousePlant {
    // public  — доступен из любого пакета
    // class   — объявление класса
    // extends — НАСЛЕДОВАНИЕ: FloweringPlant получает pól и методы HousePlant
    //           (name, height, lifespan, getName(), getHeight(), getLifespan(), getInfo())

    /** Продолжительность цветения в месяцах. */
    private int floweringTime;
    // private — доступно только внутри класса (инкапсуляция)
    // int     — целочисленный тип; floweringTime — имя в camelCase
    // Это ДОПОЛНИТЕЛЬНОЕ поле, специфичное для красивоцветущих растений

    /**
     * Конструктор.
     */
    public FloweringPlant(String name, double height, int lifespan, int floweringTime) {
        // public — конструктор доступен извне
        // Имя = имя класса (FloweringPlant)
        // Параметры: name, height, lifespan — общие для всех растений;
        //            floweringTime — специфичное для цветущих

        super(name, height, lifespan);
        // super — вызов КОНСТРУКТОРА РОДИТЕЛЯ (HousePlant)
        // Должен быть первой строкой в конструкторе
        // Родитель проверит name/height/lifespan и сохранит в свои private-поля

        if (floweringTime < 1 || floweringTime > 12) {
            // Валидация «fail fast»: ошибку ловим сразу
            // < 1  — меньше одного месяца — некорректно
            // ||   — логическое «ИЛИ»
            // > 12 — больше года — тоже некорректно

            throw new IllegalArgumentException("Продолжительность цветения должна быть 1..12 месяцев");
            // throw — «бросить» исключение
            // IllegalArgumentException — неверный аргумент
            // Объект НЕ создастся, ошибка сразу уйдёт вызывающему
        }

        this.floweringTime = floweringTime;
        // this.floweringTime — поле текущего объекта
        // floweringTime      — параметр конструктора
        // this нужен, потому что имена совпадают
    }

    /**
     * @return продолжительность цветения в месяцах
     */
    public int getFloweringTime() {
        // public — доступен извне
        // int    — тип возврата (целое число)
        // Геттер нужен, потому что поле private (инкапсуляция)
        // @return в Javadoc — документирует возвращаемое значение

        return floweringTime;
        // Возвращаем значение поля
    }

    /**
     * Дополняет информацию сроком цветения.
     */
    @Override
    public String getInfo() {
        // @Override — АННОТАЦИЯ: переопределяем метод родителя
        //             Компилятор проверит, что такой метод есть в HousePlant
        //             (защита от опечаток)
        // public    — нельзя сузить видимость родителя
        // String    — тот же тип возврата, что у родителя
        // ПОЛИМОРФИЗМ: у каждого подкласса — своя версия getInfo()

        return super.getInfo() + String.format(", цветение: %d мес.", floweringTime);
        // super.getInfo() — вызываем РОДИТЕЛЬСКУЮ реализацию (переиспользование кода)
        //                   вернёт: "Название: ..., высота: ..., продолжительность жизни: ..."
        // +                 — конкатенация строк
        // String.format(...) — форматирование строки
        //     %d             — подставит целое число (floweringTime)
        //     " мес."        — единица измерения (месяцы)
        // Итог: базовая информация + срок цветения
    }
}