package Planes;

/**
 * Класс Airbus представляет самолет типа Airbus, наследующий основные характеристики от класса Plane.
 * Ограничения: максимальная вместимость — 1320 пассажиров, максимальная емкость топлива — 220.
 */
public class Airbus extends Plane {

    // Максимальное количество пассажиров для Airbus
    public static int maxPassengers = 1320;
    
    // Максимальное количество топлива для Airbus
    public static int maxFuel = 220;

    /**
     * Конструктор класса Airbus.
     * Инициализирует самолет с заданными названием, количеством топлива и пассажиров, 
     * проверяя их на соответствие ограничениям по максимальному топливу и пассажирам.
     * 
     * @param name название самолета
     * @param fuel количество топлива
     * @param passengers количество пассажиров
     */
    public Airbus(String name, int fuel, int passengers) {
        // Используем Math.min для предотвращения превышения максимальных значений топлива и пассажиров
        super(name, Math.min(fuel, maxFuel), Math.min(passengers, maxPassengers), maxFuel);
        
        // Выводим сообщение об ошибке, если заданные параметры превышают допустимые пределы
        if (fuel > maxFuel || passengers > maxPassengers) {
            System.out.println("Creation error: Exceeded max limits");
        } 
    }

    /**
     * Переопределенный метод для вывода информации о самолете.
     * Выводит название, количество топлива и пассажиров, а также указывает, что это Airbus.
     */
    @Override
    public void print() {
        System.out.printf("Name: %s \tfuel: %d\t passengers: %d\ntype - Airbus\n", 
                        super.getName(), super.getFuel(), super.getPassengers(), super.getMaxFuel());
    }
}
