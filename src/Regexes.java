import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Regexes {
    public static Map<String, Pattern> lexems = new HashMap<>();
    public static final Map<String, Pattern> KW = new HashMap<>();

    static {
        lexems.put("OP", Pattern.compile("^\\+|-|/|\\*$"));
        lexems.put("OP_BOOL", Pattern.compile("^>|<|==|!|!=$"));
        lexems.put("ASSIGN_OP", Pattern.compile("^=$"));
        lexems.put("DIGIT", Pattern.compile("^0|([1-9][0-9]*)$"));

        lexems.put("R_BRACKET", Pattern.compile("^\\)$"));
        lexems.put("L_BRACKET", Pattern.compile("^\\($"));
        lexems.put("START_BODY", Pattern.compile("^\\{$"));
        lexems.put("FINISH_BODY", Pattern.compile("^}$"));
        lexems.put("LIST_ASSIGN", Pattern.compile("^->$"));
        lexems.put("LIST_SIGN", Pattern.compile("^\\[]?$"));

        lexems.put("VAR", Pattern.compile("^[a-zA-Z][a-zA-Z0-9@]*$"));
        //нужно отделить для удобства дифферинцирования var и kw
        KW.put("WHILE_KEYWORD", Pattern.compile("^while$"));
        KW.put("FOR_KEYWORD", Pattern.compile("^for$"));
        KW.put("IF_KEYWORD", Pattern.compile("^if$"));
        KW.put("ELSE_KEYWORD", Pattern.compile("^else$"));
        KW.put("BOOL_KEYWORD", Pattern.compile("^true|false$"));
        KW.put("LINKED_LIST_DEF", Pattern.compile("^GurLinkedList@$"));
    }
}