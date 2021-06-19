package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("[a\\]b\\[]");
        Pattern p2 = Pattern.compile("[\\[ab\\\\]");
        Pattern p3 = Pattern.compile("[^a-z]"); //отрицание
        Pattern p4 = Pattern.compile("^a"); //строка начинается с "а"
        Pattern p5 = Pattern.compile("z$"); //строка кончается на "z"
        Pattern p6 = Pattern.compile("^\\d\\d[- /.]\\d\\d[- /.]\\d\\d(\\d\\d)?$"); //date pattern
        Pattern p7 = Pattern.compile("\"[^\"\r\n]*\""); //pattern for words in quotation marks
        Pattern p8 = Pattern.compile("\\b[Ww]e\\b"); //word board
        Pattern p9 = Pattern.compile("^\\d+$", Pattern.MULTILINE); //является ли строка числом, проверка во множестве строк
        Pattern p10 = Pattern.compile("cat|dog"); //cat or dog
        Pattern p11 = Pattern.compile("colou?r"); //color or colour
        Pattern p12 = Pattern.compile("Feb(ruary)? 23(rd)?"); //Feb or February; 23 or 23rd
        Pattern p13 = Pattern.compile("<[A-Za-z][A-Za-z0-9]*"); //второй символ должен присутствовать от 0 до бесконечности раз
        Pattern p14 = Pattern.compile("<[A-Za-z][A-Za-z0-9]+"); //второй символ должен присутствовать от 1 до бесконечности раз
        Pattern p15 = Pattern.compile("\\b[1-9][0-9]{2,4}\\b"); //числа от 100 до 99999; {0,} - *; {1,} - +
        Pattern p16 = Pattern.compile("\\Q2 + 2 = 4\\E+"); //буквальное выражение, встречающиеся от 1 до бесконечности раз
        Pattern p17 = Pattern.compile("[\\p{Upper}\\p{Space}]"); //пробелы и символы в верхнем регистре
        Pattern p18 = Pattern.compile("word", Pattern.CASE_INSENSITIVE); //регистр не важен
        System.out.println("A".matches("(?i)a")); //case insensitive
        System.out.println("A".matches("(?s)a")); //single line
        System.out.println("A".matches("(?m)a")); //multiline
        System.out.println("A".matches("(?x)a #comment")); //comments, whitespaces is turned off
        Pattern p19 = Pattern.compile("q(?=u)"); //после q должна идти u (lookahead)
        Pattern p20 = Pattern.compile("q(?!=u)"); //после q не должна идти u (lookahead)
        Pattern p21 = Pattern.compile("(?<!a)b"); //перед b не должна идти a (lookbehind)
        Pattern p22 = Pattern.compile("(?<=a)b"); //перед b должна идти a (lookbehind)
        Pattern p23 = Pattern.compile(""); //
        Matcher m = p12.matcher("roF laN");
        while (m.find()) {
            System.out.print(m.start() + " " + m.group() + " ");
        }
    }
}
