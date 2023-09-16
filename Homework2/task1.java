package Homework2;

public class Homework2 {
    public static void main(String[] args) {
        System.out.println(equals("s","S"));
        System.out.println(replace("super","s","S"));
        System.out.println(format("Михаил",10,"жабе"));
        System.out.println(isPalindrome("1S1"));
    }
    static boolean equals(String s, String t) {
        // проверить, что строки совпадают без учета регистра
        return s.equalsIgnoreCase(t);
    }

    static String replace(String str, String oldStr, String newStr) {
        // в строке str все вхождения oldStr заменить на newStr
        return str.replace(oldStr, newStr);
    }

    static String format(String surname, int mark, String subject) {
        // вернуть строку, используя форматирование: Студент [Фамилия] получил [оценка] по [предмету]

        return "Студент " + surname + " получил " + mark + " по " + subject;
    }

    static boolean isPalindrome(String str) {
        // проверить, является ли строка палиндромом
        String str1 = "";
        for (int i = 0; i < str.length(); ++i) {
            str1 += str.charAt(str.length() - 1 - i);
        }
        return str.equals(str1);
    }

}
