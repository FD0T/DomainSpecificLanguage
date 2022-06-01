import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Type 'exit' to exit.");
        while(true){
            Scanner in = new Scanner(System.in);
            String src = in.nextLine();                 //ввод строковой перемменной
            if(src.equals("exit")){                     //выход из пародии на питоновский терминал
                System.out.println("See ya next time");
                break;
            }

            Lexer l = new Lexer();
            l.lexer(src);                               //кидаем строку на обработку лексеру
                                                        //т.е. вычленяем слова, точнее токены
    //        System.out.println("Tokens: ");
    //        l.printTokens();
            Parser p = new Parser(l.getTokens());
            p.parser();                                 //результат от лексера передаем уже парсеру
                                                        //он уже проверяет порядок слов/лексем/токенов
                                                        //"грамотность предложения, составленного из слов"
    //        System.out.print("\n");
            Interpreter i = new Interpreter(Parser.expressions);    //после проверки парсером передаем строки,
            i.interpreter();                                        //чьи токены меняют свой порядок согласно
                                                                    //обратной польской нотации, а дальше
                                                                    //отсеиваются на =/while/ifelse

            i.getVariables();                                       //результаты подсчетов, типо "память"
        }
    }
}

//        String src = "if (var == 1024) { n = n / 4};" +
//                "b = 1;" +
//                "a = 2;" +
//                "if(b == 1) {a = a / 4} else {b = b / 4};" +
//                "if(a == 1) {a = a / 4} else {b = b / 4};" +
//                "while (b < 10) { b = 2*(b + 1); i = i + 1;};" +
//                "num = ((100+2) * (50-22)) + b + (200 - a);" +
//                "sum = 100/50;";