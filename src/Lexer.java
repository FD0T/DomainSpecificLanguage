import java.util.regex.*;
import java.util.*;

public class Lexer {
    private final static List<Token> tokens = new LinkedList<>();

    protected void lexer(String src) {
        StringBuffer buffer = new StringBuffer(); //для содержимого токена
        String buffString = "";                   //для его типа
        boolean isValid;                          //KW or VAR
        int i = 0;                                //индекс символа в строке
        int length = src.length();                //собственно длина строки
        Matcher m;                                //сверялка проверялка по регулярке

        while (i < length) { //Проходимся по всем символам в строке src
            if (i == length - 1 && src.charAt(i) == ';' || src.charAt(i) == '\t') break; //условие конца программы
                                                                                         //конец строки, ;, перенос
            buffer.append(src.charAt(i)); //взяли символ

            if (src.charAt(i) == ' ' || src.charAt(i) == ';') { //игнорирование пробелов или точек с запятой в строке
                buffer.reverse();       //гениальный способ удадения
                buffer.deleteCharAt(0); //в самом конце стрингбуффера
                buffer.reverse();       //если "не знаешь" индекс последнего символа
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
                buffer.reverse();       //гениальный способ удадения
                buffer.deleteCharAt(0); //в самом конце стрингбуффера
                buffer.reverse();       //если "не знаешь" индекс последнего символа

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
