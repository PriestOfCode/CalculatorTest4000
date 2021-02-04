package company.com;

//Вспомогательный класс для поиска промежуточных значений

public class Auxiliary {
    //Переводим строку "s" в массив примитивных символов
    static char [] chArray = Calculator.s.toCharArray();
    //Создаётся строчный массив для хранения условных цифр(без символа действия)
    static String[] sArray = {(Calculator.s.substring(0, aIndex())), (Calculator.s.substring(aIndex() + 1, chArray.length))};

    //Метод, возвращающий индекс элемента действия из массива примитивных символов, созданного в начале данного класса
    public static Integer aIndex () {
            Integer index = null;

            for (int i = 0; i < chArray.length; i++) {
                if (chArray[i] == '+' || chArray[i] == '-' || chArray[i] == '*' || chArray[i] == '/')
                    index = i;
            }
            /*
             * Проработка исключений:
             * 1. отсутствие символа действия;
             * 2. начилие символа действия в начале строки или в её конце.
             * Эти действия позволяют избавиться от вариантов типа "127+", "127", "VV+" и т.п.
             */
            if (index == null)
                Exceptions.noAction();
            if (index == 0 || index == chArray.length-1)
                Exceptions.badIn();

            return index;
    }

    //Метод, считающий количество введённых пользователем римских цифр от 1 до 10 с помощью "словаря" RomanNumbers
    public static Integer romanMarker () {
        Integer romanMarker = 0;

        for (int i = 0; i < sArray.length; i++) {
            for (int j = 0; j < RomanNumbers.romanArray.length; j++) {
                if (sArray[i].equals(RomanNumbers.romanArray[j]))
                    romanMarker++;
            }
        }
        return romanMarker;
    }

}