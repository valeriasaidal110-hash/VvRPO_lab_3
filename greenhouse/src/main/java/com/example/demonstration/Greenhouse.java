package com.example.demonstration; // Объявление пакета — «папки» класса

import com.example.models.Fern;            // Импорт класса папоротника
import com.example.models.FloweringPlant;  // Импорт класса красивоцветущего растения
import com.example.models.HousePlant;      // Импорт базового абстрактного класса
import com.example.models.Succulent;       // Импорт класса суккулента

import java.util.ArrayList;                // Импорт реализации списка на массиве
import java.util.List;                     // Импорт интерфейса списка

/**
 * Класс «Теплица», демонстрирующий <b>композицию</b>: содержит коллекцию
 * комнатных растений и предоставляет методы выборки.
 */
public class Greenhouse { // public — доступен из любого пакета; class — объявление класса

    /** Внутреннее хранилище растений. */
    private final List<HousePlant> plants = new ArrayList<>();
    // private          — доступно только внутри класса (инкапсуляция)
    // final            — ссылку нельзя переприсвоить (но содержимое списка менять можно)
    // List<HousePlant> — список, элементы — любые наследники HousePlant
    // new ArrayList<>()— конкретная реализация, создаём пустой список; <> — «алмаз», тип выводится из левой части

    /**
     * Добавляет растение в теплицу.
     *
     */
    public void addPlant(HousePlant plant) { // public — доступен извне; void — ничего не возвращает
                                             // HousePlant plant — параметр базового типа, примет любой подтип
        plants.add(plant);                   // Делегируем работу внутреннему списку
    }

    
    public List<HousePlant> getAllPlants() { // Возвращает список всех растений
        return new ArrayList<>(plants);      // new ArrayList<>(plants) — защитная КОПИЯ, чтобы внешний код не мог менять внутреннее состояние
    }

    /**
     * Возвращает список всех красивоцветущих растений.
     *
     */
    public List<FloweringPlant> getFloweringPlants() { // Тип возврата конкретнее базового — List<FloweringPlant>
        List<FloweringPlant> result = new ArrayList<>(); // Пустой список для результата
        for (HousePlant p : plants) {                    // for-each: «для каждого растения p из plants»
            if (p instanceof FloweringPlant fp) {        // Pattern matching: проверка типа + автоматическое приведение к fp
                result.add(fp);                          // Если это цветущее — добавляем
            }
        }
        return result;                                   // Возвращаем найденные растения
    }

    /**
     * Возвращает растения с продолжительностью жизни меньше указанной.
     *
     */
    public List<HousePlant> getPlantsWithLifespanLessThan(int maxYears) { // int maxYears — порог в годах
        List<HousePlant> result = new ArrayList<>();                      // Пустой список результата
        for (HousePlant p : plants) {                                     // Перебираем все растения
            if (p.getLifespan() < maxYears) {                             // getLifespan() определён в базовом классе — доступен всем наследникам
                result.add(p);                                            // Если короче порога — добавляем
            }
        }
        return result;                                                    // Возвращаем результат
    }

    /**
     * Возвращает папоротники выше заданной высоты.
     *
   */
    public List<Fern> getFernsTallerThan(double minHeight) { // double minHeight — порог высоты в см
        List<Fern> result = new ArrayList<>();               // Пустой список результата
        for (HousePlant p : plants) {                        // Перебираем все растения
            if (p instanceof Fern fern && fern.getHeight() > minHeight) { // Двойное условие: тип И высота
                                                                          // fern доступна только внутри if
                result.add(fern);                                         // Добавляем подходящий папоротник
            }
        }
        return result;                                                    // Возвращаем результат
    }
}