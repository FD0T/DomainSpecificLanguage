import java.util.*;

//этот класс можно было не создавать и использовать линкедлист линкедлистов токенов,
//но для человеческого понимания пришлосьь прибегнуть к такому
public class Expression {
    private final List<Token> EXPRESSION = new LinkedList<>();

    public void addToken (Token t) {
        EXPRESSION.add(t);
    }

    public Token takeToken(int index) {
        return EXPRESSION.get(index);
    }

    public int getSize(){
        return EXPRESSION.size();
    }
    @Override
    public String toString() {
        StringBuilder expr = new StringBuilder();
        for (Token token : EXPRESSION) {
            expr.append(token.getValue());
        }
        return "Expression: " + expr;
    }
}