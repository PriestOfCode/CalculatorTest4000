package company.com;

//Класс, осуществляющий математические действия числами
public class CalculatingProcess {

    //Метод, работающий с арабскими числами
    public static Integer arabCalculate(){
        int aAnswer = 0;
        int num1 = Integer.parseInt(Auxiliary.sArray[0]);
        int num2 = Integer.parseInt(Auxiliary.sArray[1]);

        //Проверка условия задачи на входные числа от 1 до 10
        if (num1 > 10 || num1 < 1 || num2 > 10 || num2 < 1)
            Exceptions.badIn();

        //Проверка типа математического действия и его исполнение с возвратом ответа
        if (Auxiliary.chArray[Auxiliary.aIndex()] == '+')
            aAnswer = num1 + num2;
        if (Auxiliary.chArray[Auxiliary.aIndex()] == '-')
            aAnswer = num1 - num2;
        if (Auxiliary.chArray[Auxiliary.aIndex()] == '*')
            aAnswer = num1 * num2;
        //В случае с делением определяем какое из введённых чисел больше для выдачи корректного ответа вместо "0"
        if (Auxiliary.chArray[Auxiliary.aIndex()] == '/') {
            if (num1 < num2) {
                intToDouble();
                Calculator.k = 1;
            }
            else {
                aAnswer = num1/num2;
            }
        }

        return aAnswer;
    }

    //Метод, дающий корректный результат деления меньшего числа на большее, вместо "0"
    public static double intToDouble() {
        double dNum1 = Double.parseDouble(Auxiliary.sArray[0]);
        double dNum2 = Double.parseDouble(Auxiliary.sArray[1]);
        double aAnswer = dNum1/dNum2;

        return aAnswer;
    }


    //Метод, работающий с римскими числами
    public static String romanCalculate(){
        int r = 0, r1 = 0, r2 = 0;
        String rAnswer = "";

        //Перевод римских чисел в арабские
        for (int i = 1; i < RomanNumbers.romanArray.length; i++) {
            if (Auxiliary.sArray[0].equals(RomanNumbers.romanArray[i]))
                r1 = i;
            if (Auxiliary.sArray[1].equals(RomanNumbers.romanArray[i]))
                r2 = i;
        }

        //Проверка типа математического действия и его исполнение
        if (Auxiliary.chArray[Auxiliary.aIndex()] == '+')
            r = r1 + r2;
        if (Auxiliary.chArray[Auxiliary.aIndex()] == '-')
            r = r1 - r2;
        if (Auxiliary.chArray[Auxiliary.aIndex()] == '*')
            r = r1 * r2;
        if (Auxiliary.chArray[Auxiliary.aIndex()] == '/')
            /*
             * Определяем наличие дробного результата в случае с римскими числами,
             * посколько дроби отсутствуют в римской системе счисления
             */
            if (r1 < r2) {
                rAnswer = "Дроби в римской системе счисления не предусмотрены";
                return rAnswer;
            }
            else {
                r = r1 / r2;
            }

        //Исключение при получении ответа нуль
        if (r == 0)
            System.out.println("В римской системе счисления нуль отсутствует");

        //Перевод полученного значения из арабских цифр в римские и возврат ответа
        int k = 1;
        int marker = r;

        //Определяем скольки значное число получено
        while (marker/10 != 0) {
            marker /= 10;
            k++;
        }

        //Единственное трёхзначное число возможно только при умножении "X*X"
        if (k == 3)
            rAnswer = "C";

        /*
         * Двузначные числа конвертируются в римские, используя переменную marker,
         * которая уже хранит количество десятков в значении. Далее используется словарь десятков и единиц
         * из класса "RomanNumbers"
         */
        if (k == 2)
            rAnswer = RomanNumbers.romanTwenty[marker] + RomanNumbers.romanArray[r%10];

        /*
         * Перевод однозначных чисел учитывает возможность получения отрицательного числа,
         * которые в римской системе отсутствуют.
         * Сама конвертация происходит с помощью словаря единиц в классе RomanNumbers
         */
        try {
            if (k == 1)
                rAnswer = RomanNumbers.romanArray[r];
        }
        catch (Exception lowZero) {
            System.out.println("В римской системе счисления отрицательные значения отсутствуют");
        }

        return rAnswer;

    }


}
