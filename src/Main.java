import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InputException {
        Scanner scanner = new Scanner(System.in);
        String inputStr;
        ArabNum arabNum = new ArabNum();

        System.out.println("Добро пожаловать в мойКалькулятор");
        System.out.println("Введите выражения для вычисления. Допускаются числа от 1 до 10 в арабской и римской системах счисления");

        for (;;) {          // **  Запускаем бесконечный цикл калькулятора  ** //
            System.out.println("Введите пример для вычисления или q для выхода:");
            inputStr = scanner.nextLine(); // Считывание строки для вычисления
            String [] str = inputStr.split(" "); // Делим строку на части

            if (str[0].equals("q")) {
                    System.out.println("Выход. Хорошего Вам дня!"); break;}
            else if (str[0].equals("Q")) {
                System.out.println("Выход. Хорошего Вам дня!"); break;}
            else if (str[0].equals("й")) {
                System.out.println("Выход. Хорошего Вам дня!"); break;}
            else if (str[0].equals("Й")) {
                System.out.println("Выход. Хорошего Вам дня!"); break;}
            else if (str.length < 3) throw new InputException("Строка не является математической операцией!");
            else if (str.length > 3) throw new InputException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            else if ((arabNum.isArab(str[0]) && RomNum.isRoman(str[2])) || (arabNum.isArab(str[2]) && RomNum.isRoman(str[0])))
                throw new InputException("Используются одновременно разные системы счисления!");

            String calcRes =  calc(inputStr);
            String [] outStr = calcRes.split("\\*");
            if (outStr[0].equals("OK")) System.out.println(outStr[1]);
            else if (outStr[0].equals("Er")) throw new InputException(outStr[1]);
        }
        scanner.close();
    }

    public static String calc (String input) {
        ArabNum arabNum = new ArabNum();
        String result = "";
        String [] str = input.split(" ");

        if (arabNum.isArab(str[0]) && arabNum.isArab(str[2]))
        {
            // Блок обработки арабской математики
            if (MathOps.isMath(str[1])) {  // если в строке символ из списка математических операций - продолжаем
                switch (str[1]) {
                    case "+" -> {
                        int x = Integer.parseInt(str[0]) + Integer.parseInt(str[2]);
                        result = "OK*" + x;
                    }
                    case "-" -> {
                        int x = Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
                        result = "OK*" + x;
                    }
                    case "*" -> {
                        int x = Integer.parseInt(str[0]) * Integer.parseInt(str[2]);
                        result = "OK*" + x;
                    }
                    case "/" -> {
                        int x = Integer.parseInt(str[0]) / Integer.parseInt(str[2]);
                        result = "OK*" + x;
                    }
                }
            }
            else result = "Er*Некорректный оператор!";
        }
        else if ((RomNum.isRoman(str[0])) && (RomNum.isRoman(str[2])))
        {
            if (MathOps.isMath(str[1])) {
                switch (str[1]) {
                    case "+" -> {
                        int x = RomNum.romToInt(str[0]) + RomNum.romToInt(str[2]);
                        result = "OK*" + RomNum.intToRom(x);
                    }
                    case "-" -> {
                        int x = RomNum.romToInt(str[0]) - RomNum.romToInt(str[2]);
                        if (x == 0) {
                            result = "Er*В римской системе счисления нет нуля";
                        } else if (x <= 0) result = "Er*В римской системе счисления нет отрицательных чисел";
                        else result = "OK*" + RomNum.intToRom(x);
                    }
                    case "*" -> {
                        int x = RomNum.romToInt(str[0]) * RomNum.romToInt(str[2]);
                        result = "OK*" + RomNum.intToRom(x);
                    }
                    case "/" -> {
                        int x = RomNum.romToInt(str[0]) / RomNum.romToInt(str[2]);
                        result = "OK*" + RomNum.intToRom(x);
                    }
                }
            }
            else{
                result = "Er*Некорректный оператор!";
            }
        }
        else {
            result = "Er*Используются неподходящие значения!";
        }
        return result;
    }

}