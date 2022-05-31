public class main {
    public static void main(String[] args) {
//        String s = "mama=1; papa++;";
//        String s1 = "mama++;";
//        String s2 = "mama > 12;";
//        String s3 = "mama = 1+2+3;" +
//                "\npapa=((a+b+c+d)+var*c) if (n=m) 21 m hi 1;"; //Danya im sorry T-T
//        System.out.println(s);
//        Lexer l = new Lexer(s);
//        l.match();
//        //l.tokens();
//        System.out.println();
//
//        Parser3 p = new Parser3(l.getCode_tokens());
//        p.getExressions();

        String src = "if (var == 1024) { n = n / 4};" +
                "b = 1;" +
                "a = 2;" +
                "if(b == 1) {a = a / 4} else {b = b / 4};" +
                "if(a == 1) {a = a / 4} else {b = b / 4};" +
                "while (b < 10) { b = 2*(b + 1); i = i + 1;};" +
                "num = ((100+2) * (50-22)) + b + (200 - a);" +
                "sum = 100/50;";
        String src2 = "maksLox=(7-6)*((7-4)*7-5*6);" +
                "if(a>2){d=b+1;}" +
                "a=(22-2)*2;" +
                "b = ((a - 45) - (30 - a));" +
                "mama=b;";
                //"if(var>1024){n=n/4} else{vlad=molo+dec};" +
                //"while(mun!=2){ver=m*10; rem=w+21};";
        Lexer l = new Lexer();
        l.lexer(src);
        System.out.println("Tokens: ");
        l.printTokens();
        Parser p = new Parser(l.getTokens());
        p.parser();
        System.out.print("\n");
//        for (Expression s : Parser.expressions) {
//            for(int i = 0; i < s.getSize(); i++){
//                System.out.print(s.takeToken(i).getValue());
//            }
//        }
        Interpreter i = new Interpreter(Parser.expressions);
        i.interpreter();

//        Parser2 p = new Parser2(l.getCode_tokens());
//        p.lang();

        //Lexer lexer = new Lexer(s);
//        lexer.();
 //       lexer.Tokens();

//        MyLL list = new MyLL();
//        list.print();
//        System.out.println(list.contains(1));
//        list.addLast(1);
//        System.out.println(list.contains(1));
//        list.print();

//        Cat cat1 = new Cat(10,3,7);
//        Cat cat2 = new Cat(14,3,7);
//        Cat cat3 = new Cat(3,10,7);
//        Cat cat4 = new Cat(7,7,7);
//        MyHS hs = new MyHS();
//        hs.put(cat1);
//        hs.put(cat2);
//        hs.put(cat3);
//        hs.put(cat4);
//        hs.print();
    }
}
