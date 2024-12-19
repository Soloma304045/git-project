package Planes;

/**
 * Класс Plane представляет самолет с его характеристиками: 
 * название, количество топлива, пассажиры и максимальная емкость топлива.
 */
abstract public class Plane {

    // Название самолета
    private String name = "";
    
    /**
     * Возвращает название самолета.
     * 
     * @return название самолета
     */
    public String getName() { 
        return name; 
    }

    // Количество топлива в самолете
    private int fuel = 0;
    
    /**
     * Возвращает текущее количество топлива в самолете.
     * 
     * @return количество топлива
     */
    public int getFuel() { 
        return fuel; 
    }

    // Количество пассажиров
    private int passengers = 0;
    
    /**
     * Возвращает количество пассажиров на борту.
     * 
     * @return количество пассажиров
     */
    public int getPassengers() { 
        return passengers; 
    }

    // Максимальное количество топлива, которое может вместить самолет
    private int maxFuel = 0;
    
    /**
     * Возвращает максимальное количество топлива, которое может вместить самолет.
     * 
     * @return максимальное количество топлива
     */
    public int getMaxFuel() { 
        return maxFuel; 
    }

    /**
     * Конструктор класса Plane, который инициализирует основные параметры самолета.
     * 
     * @param name название самолета
     * @param fuel количество топлива
     * @param passengers количество пассажиров
     * @param maxFuel максимальная емкость топлива
     */
    public Plane(String name, int fuel, int passengers, int maxFuel) {
        this.name = name;
        this.fuel = fuel;
        this.passengers = passengers;
        this.maxFuel = maxFuel;
    }

    /**
     * Проверяет, достаточно ли топлива для полета. Условие полета — 
     * должно быть больше 70% от максимальной емкости топлива.
     * 
     * @return true, если топлива достаточно, иначе false
     */
    public boolean enoughFuel() {
        return this.fuel - maxFuel * 0.7 > 0;
    }

    /**
     * Печатает информацию о самолете: название, количество топлива, пассажиров и максимальную емкость.
     */
    public void print() {
        System.out.printf("Name: %s \tfuel: %d\t passengers: %d\t maxFuel: %d\n", name, fuel, passengers, maxFuel);
    }
}
