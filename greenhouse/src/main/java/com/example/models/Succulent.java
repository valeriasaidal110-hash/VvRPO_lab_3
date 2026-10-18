package com.example.models; // Объявление пакета — файл лежит в src/main/java/com/example/models/

/**
 * Класс, описывающий суккулент — растение с толстыми сочными листьями.
 */
public class Succulent extends HousePlant {
    // public  — доступен из любого пакета
    // class   — объявление класса
    // extends — НАСЛЕДОВАНИЕ: Succulent получает pól и методы HousePlant
    //           (name, height, lifespan, getName(), getHeight(), getLifespan(), getInfo())

    /** Наличие колючек на растении. */
    private boolean hasSpines;
    // private — доступно только внутри класса (ИНКАПСУЛЯЦИЯ)
    // boolean — логический тип: true/false; hasSpines — имя в camelCase
    // Это ДОПОЛНИТЕЛЬНОЕ поле, специфичное для суккулентов
    // В отличие от полей других подклассов, это поле ИЗМЕНЯЕМОЕ (есть сеттер)

    /**
     * Конструктор.
     *
     * @param name      название
     * @param height    высота, см
     * @param lifespan  продолжительность жизни, лет
     * @param hasSpines есть ли колючки
     */
    public Succulent(String name, double height, int lifespan, boolean hasSpines) {
        // public — конструктор доступен извне
        // Имя = имя класса (Succulent)
        // Параметры: name, height, lifespan — общие для всех растений;
        //            hasSpines — специфичное для суккулента

        super(name, height, lifespan);
        // super — вызов КОНСТРУКТОРА РОДИТЕЛЯ (HousePlant)
        // Обязателен первой строкой
        // Родитель проверит name/height/lifespan и сохранит в свои private-поля

        this.hasSpines = hasSpines;
        // this.hasSpines — поле текущего объекта
        // hasSpines      — параметр конструктора
        // this нужен, потому что имена совпадают
        // Здесь НЕТ валидации: boolean не может быть «неправильным» — он либо true, либо false
    }

    /** @return {@code true}, если у растения есть колючки */
    public boolean isHasSpines() {
        // public  — доступен извне
        // boolean — тип возврата (логическое значение)
        // Имя isHasSpines() — стилистически неудачно: двойное «есть».
        // Логичнее: hasSpines() (без is) или isSpiny().

        return hasSpines;
        // Возвращаем значение поля
    }

    /** @param hasSpines новое значение наличия колючек */
    public void setHasSpines(boolean hasSpines) {
        // public — доступен извне
        // void   — ничего не возвращает
        // СЕТТЕР — метод изменения поля. В этом классе — единственный во всей иерархии.
        // Благодаря ему объект Succulent МУТАБЕЛЬНЫЙ (изменяемый)

        this.hasSpines = hasSpines;
        // Присваиваем полю новое значение
        // this нужен, чтобы отличить поле от параметра с тем же именем
    }

    @Override
    public String getInfo() {
        // @Override — АННОТАЦИЯ: переопределяем метод родителя HousePlant
        //             Компилятор проверит, что такой метод есть в родителе
        // public    — нельзя сузить видимость (у родителя тоже public)
        // String    — тот же тип возврата

        return super.getInfo() + ", колючки: " + (hasSpines ? "есть" : "нет");
        // super.getInfo()          — вызываем РОДИТЕЛЬСКУЮ реализацию (переиспользование)
        //                            вернёт: "Название: ..., высота: ..., продолжительность жизни: ..."
        // + ", колючки: "          — конкатенация литерала
        // + (hasSpines ? "есть" : "нет")
        //      ТЕРНАРНЫЙ ОПЕРАТОР (тернарник):
        //      условие ? значение_если_true : значение_если_false
        //      если hasSpines == true  → подставится "есть"
        //      если hasSpines == false → подставится "нет"
    }
}