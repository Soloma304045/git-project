import java.util.ArrayList;
import java.util.Scanner;
import Planes.Boeing;
import Planes.Airbus;
import Planes.IL;
import Planes.Plane;

/**
 * Основной класс программы, который предоставляет функции для создания и управления объектами самолетов.
 * Поддерживает модели Boeing, Airbus, IL.
 */
public class Program {

    /**
     * Возвращает список самолетов, название которых начинается на заданную букву.
     *
     * @param list список самолетов
     * @param letter начальная буква имени самолета
     * @return список самолетов, название которых начинается на заданную букву
     */
    public static ArrayList<Plane> planeList(ArrayList<Plane> list, String letter) {
        ArrayList<Plane> newList = new ArrayList<Plane>(); 
        for (Plane plane : list) {
            if (plane.getName().startsWith(letter)) {
                newList.add(plane);
            }
        }
        return newList;
    }

    /**
     * Создает новый самолет в зависимости от модели и добавляет его в список.
     * Проверяет корректность введенных данных, включая топливо и пассажиров.
     *
     * @param list список самолетов, в который будет добавлен новый самолет
     * @param scanner объект для ввода данных с консоли
     * @return обновленный список самолетов
     */
    private static ArrayList<Plane> createPlane(ArrayList<Plane> list, Scanner scanner) {
        System.out.println("Введите модель: ");
        scanner.nextLine();
        String model = scanner.nextLine();
        System.out.println("Введите название: ");
        String name = scanner.nextLine();
        System.out.println("Введите объем топлива: ");
        int fuel = scanner.nextInt();
        System.out.println("Введите число пассажиров: ");
        int passengers = scanner.nextInt();
        switch(model) {
            case "Boeing": {
                if (fuel <= Boeing.maxFuel && passengers <= Boeing.maxPassengers) {
                    Boeing plane = new Boeing(name, fuel, passengers);
                    list.add(plane);
                } else {
                    System.out.println("Input data error. Please, try again");
                }
                break;
            }
            case "Airbus": {
                if (fuel <= Airbus.maxFuel && passengers <= Airbus.maxPassengers) {
                    Airbus plane = new Airbus(name, fuel, passengers);
                    list.add(plane);
                } else {
                    System.out.println("Input data error. Please, try again");
                }
                break;
            }
            case "IL": {
                if (fuel <= IL.maxFuel && passengers <= IL.maxPassengers) {
                    IL plane = new IL(name, fuel, passengers);
                    list.add(plane);
                } else {
                    System.out.println("Input data error. Please, try again");
                }
                break;
            }
            default: {
                System.out.println("model error. Please, try again");
                break;
            }
        }
        return list;
    }

    /**
     * Основной метод программы. Позволяет пользователю добавлять самолеты, просматривать информацию
     * о них, проверять количество пассажиров и выходить из программы.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        ArrayList<Plane> planeList = new ArrayList<Plane>();
        ArrayList<String> nameList = new ArrayList<String>();

        // Создание начальных объектов самолетов
        Boeing boeing_1 = new Boeing("Tommer", 190, 1275);
        Boeing boeing_2 = new Boeing("Hemly", 179, 1138);
        Boeing boeing_3 = new Boeing("Kollen", 192, 1056);

        Airbus airbus_1 = new Airbus("Fortune", 168, 689);
        Airbus airbus_2 = new Airbus("Summer Boy", 112, 1007);
        Airbus airbus_3 = new Airbus("Gimly", 202, 1159);

        IL iL_1 = new IL("Lisa", 266, 1734);
        IL iL_2 = new IL("Zaharov", 241, 1612);
        IL iL_3 = new IL("Kristina", 247, 1483);

        // Добавление самолетов в список
        planeList.add(boeing_1);
        planeList.add(boeing_2);
        planeList.add(boeing_3);
        planeList.add(airbus_1);
        planeList.add(airbus_2);
        planeList.add(airbus_3);
        planeList.add(iL_1);
        planeList.add(iL_2);
        planeList.add(iL_3);

        Scanner in = new Scanner(System.in);
        boolean endIsNear = false;
        int choice;
        int i;
        
        // Основной цикл программы
        while (!endIsNear) {
            System.out.printf("1 - Создать новый самолет\n" +
                              "2 - Вывести информацию о самолете\n" +
                              "3 - Проверить число пассажиров\n" +
                              "4 - Поиск самолетов по символу\n" +
                              "5 - Покинуть программу\n");
            choice = in.nextInt();
            switch(choice) {
                case 1: {
                    // Создание нового самолета
                    createPlane(planeList, in);
                    break;
                }
                case 2: {
                    // Вывод информации о самолете
                    i = 1;
                    System.out.printf("Выберите самолет из списка: \n");
                    for (Plane plane : planeList) {
                        System.out.printf("%d - %s\n", i, plane.getName());
                        i++;
                    }
                    choice = in.nextInt();
                    if (choice > planeList.size()) {
                        System.out.println("input error. Please, try again");
                        break;
                    }
                    planeList.get(choice-1).print();
                    if (planeList.get(choice-1).enoughFuel()) {
                        System.out.println("Топлива достаточно");
                    } else {
                        System.out.println("Топлива не достаточно");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Введите число пассажиров: ");
                    int num = in.nextInt();
                    for (Plane plane : planeList) {
                        if (plane.getPassengers() < num) {
                            nameList.add(plane.getName());
                        }
                    }
                    System.out.println(nameList);
                    break;
                }
                case 4: {
                    i = 1;
                    System.out.println("Введите символ: ");
                    char chr = in.next().charAt(0); 
                    for (Plane plane : planeList) {
                        if(plane.getName().charAt(0) == Character.toUpperCase(chr)) {
                            System.out.println(i + " - " + plane.getName());
                            i++;
                        }
                    }
                    System.out.println("\n");
                    i = 0;
                    break;
                }
                case 5: {
                    endIsNear = true;
                    break;
                }
                default: {
                    System.out.println("input error. Please, try again");
                    break;
                }
            }
        }
        in.close();
    }
}
