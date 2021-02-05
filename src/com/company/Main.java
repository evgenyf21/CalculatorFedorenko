package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        String[] arab = {"1","2","3","4","5","6","7","8","9","10"};

        String[] roma = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        char op = ' ';
        int ans=0;
        int num1=0, num2=0;
        System.out.println("Давайте посчитаем!");
        System.out.println("Введите выражение для расчёта. Используйте числа от 1 до 10 римскими или арабскими цифрами:");

        Scanner in = new Scanner(System.in);
        String vvod = in.nextLine();

	    System.out.println("Вы ввели: "+ vvod + ";");

	    if (vvod.contains("+")) {
	        op = '+'; }
        else { if (vvod.contains("-")) op = '-';
        else { if (vvod.contains("*")) op = '*';
        else { if (vvod.contains("/")) op = '/';
        else {System.out.println("Ошибка! Вы не использовали ни одного оператора. Я не могу произвести расчёт! ");
            System.exit(0);}}}}

        String[] str = vvod.split("[-+/*]",0);
        str[0] = str[0].trim();
        str[1] = str[1].trim();

        // проверяем, входит ли строка str в массив строк массива "roma"
        boolean flagR1 = false, flagR2 = false;
        boolean flagA1 = false, flagA2 = false;

        for (int i = 0; i < roma.length; i++){
            if (roma[i].equals(str[0])){
                flagR1 = true;
            }}
        for (int i = 0; i < roma.length; i++){
            if (roma[i].equals(str[1])){
                flagR2 = true;
            }}

            // если flagR1 и flagR2 = true, значит рим.
            if (flagR1 && flagR2) {
              num1 = romanToNumber(str[0]);
              num2 = romanToNumber(str[1]);
            } else {   // проверяем, входит ли строка str в массив строк массива "arab"
                for (int i = 0; i < arab.length; i++){
                    if (arab[i].equals(str[0])){
                        flagA1 = true;
                    }}

                for (int i = 0; i < arab.length; i++){
                    if (arab[i].equals(str[1])){
                        flagA2 = true;
                    }}

                if(flagA1 && flagA2){
                num1 = Integer.parseInt(str[0]);
                num2 = Integer.parseInt(str[1]);}
                    else {System.out.println("Ошибка! Вы ввели неверный формат числа. Я не могу произвести расчёт! ");
                        System.exit(0);};

                    }


        switch(op) {
            case '+': ans = num1 + num2;
                break;
            case '-': ans = num1 - num2;
                break;
            case '*': ans = num1 * num2;
                break;
            case '/': ans = num1 / num2;
                break;
            default: System.out.println("Ошибка! Вы не использовали ни одного оператора. Я не могу произвести расчёт! ");
                break;
        }
        if (flagR1 && flagR2) {
            System.out.println("Ответ арабскими: "+ ans);
            System.out.println("Ответ римскими: "+ NumberToRoman(ans));}
        else {System.out.println("Ответ: "+ ans);}

    }
    private static int romanToNumber(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            return -1;
        }
    }

    private static String NumberToRoman(Integer n) {
        int i = 8;
        String res = "";
        Integer[] arab2 = {1, 4, 5, 9, 10, 40, 50, 90, 100};
        String[] roma2 = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

            while (i>=0) {
                while (arab2[i]<=n) {
                    res = res + roma2[i];
                    n = n - arab2[i];
                }
                i = i-1;}

        return res; }


}
