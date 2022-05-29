import java.util.regex.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Lexer {
    private final static List<Token> tokens = new LinkedList<>();

    protected void lexer(String src) {
        StringBuffer buffer = new StringBuffer();
        String buffString = "";
        boolean isValid;
        int i = 0;
        int length = src.length();
        Matcher m;

        while (i < length) { //Проходимся по всем символам в строке src
            if (i == length - 1 && src.charAt(i) == ';' || src.charAt(i) == '\t') break; //Условие конца программы

            buffer.append(src.charAt(i));

            if (src.charAt(i) == ' ' || src.charAt(i) == ';') { //Пропуск пробелов или точек с запятой в строке
                buffer.reverse();
                buffer.deleteCharAt(0);
                buffer.reverse();
                i++;
                continue;
            }

            isValid = false;

            for (String lexemName : Regexes.lexems.keySet()) {
                Pattern p = Regexes.lexems.get(lexemName);
                Pattern p_sec = Regexes.lexems.get("VAR"); //специальный паттерн для var лексем
                m = p_sec.matcher(buffer);

                if (m.matches()) { //проверка для отделения ключевых слов от названий переменных
                    boolean isValid_var = false;

                    for (String lexemName_var : Regexes.KW.keySet()) {
                        Pattern p_var = Regexes.KW.get(lexemName_var);
                        m = p_var.matcher(buffer);

                        if (m.matches()) { //проверка буфера на соответствие регулярным выражениям
                            isValid = true;
                            isValid_var = true;
                            buffString = lexemName_var;
                        }
                    }

                    if (!isValid_var) {
                        isValid = true;
                        buffString = "VAR";
                    }

                    break;
                }

                m = p.matcher(buffer);

                if (m.matches()) { //проверка буфера на соответствие регулярным выражениям
                    isValid = true;
                    buffString = lexemName;
                }
            }

            if (!isValid) { //проверка конца лексемы в строке
                buffer.reverse();
                buffer.deleteCharAt(0);
                buffer.reverse();

                tokens.add(new Token(buffString, buffer));
                buffer.setLength(0);
                continue;
            }

            if (src.charAt(i + 1) == ';') { //условие конечной лексемы в строке
                tokens.add(new Token(buffString, buffer));
                buffer.setLength(0);
                i++;
                continue;
            }
            i++;
        }
    }

    public void printTokens(){
        for (Token token: tokens){
            System.out.println(token);
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
