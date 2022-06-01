public class Token {
    private final String type;                               //тип переменной
    private final StringBuffer value = new StringBuffer(""); //что хранит в себе
                                                             //stringbuffer для удобного редактирования в циклах
    public Token(String type, StringBuffer value) {
        this.type = type;
        this.value.append(value);
    }

    public String getType() {
        return type;
    }

    public StringBuffer getValue() {
        return value;
    }
    @Override
    public String toString() {
        return "Token{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
