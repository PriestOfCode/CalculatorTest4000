package company.com;
import java.util.Scanner;




public class Calculator {
    /*
     * 1. Создаётся переменная для хранения введённых значений в качестве строки
     * 2. Убираются пробелы из введённого значения
     * 3. Переменная "k" служит для получения корректного ответа деления 2-х арабских чисел при условии,
     *    что первое число меньше второго
     */
    static Scanner scanner = new Scanner(System.in);
    static String sM = scanner.nextLine();
    static String s = sM.replaceAll("\\s", "");
    static int k = 0;

    /*
     * В зависимости от количества римских цифр вызывается либо калькулятор арабских значений,
     * либо римских, либо сообщение о некорректном вводе
     */

    public static void main(String[] args) {
       if (Auxiliary.romanMarker() == 0) {
           if (k == 0)
               System.out.print(CalculatingProcess.arabCalculate());
           if (k == 1)
               System.out.println(CalculatingProcess.intToDouble());
       }

       if (Auxiliary.romanMarker() == 1)
               Exceptions.badIn();

       if (Auxiliary.romanMarker() == 2)
            System.out.print(CalculatingProcess.romanCalculate());
    }

}


