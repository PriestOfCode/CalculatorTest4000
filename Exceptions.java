package company.com;

//Класс, содержащий исключения, вызываемые в ходе программы в случае недопустимого ввода и завершающие работу
public class Exceptions {

    static void noAction() {
        System.out.println("Введён недопустимый оперант или он отсутствует");
        System.exit(0);
    }

    static void badIn() {
        System.out.println("Некорректно введены значения");
        System.exit(0);
    }
}
