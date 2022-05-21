package nsp.compiler.AnLex;

public enum Tokens_List{
    FUNCTION("func"),
    SHOW("show"),
    RETURN("->"),
    INT("int"),
    FLOAT ("float"),
    BOOLEAN("boolean"),
    CHAR("char"),
    STRING("string"),
    VOID("void"),
    IF("if"),
    ELSE("else"),
    WHILE("while"),
    FOR("for"),
    IGUALDADE ("="),
    DESIGUALDADE ("!="),
    MAIOR (">"),
    MENOR ("<"),
    MAIOR_IGUAL (">="),
    MENOR_IGUAL ("<="),
    ADICAO ("+"),
    SUBTRACAO ("-"),
    MULTIPLICACAO ("*"),
    DIVISAO ("/"),
    AND ("and"),
    OR ("or"),
    NOT ("!"),
    ATRIBUICAO (":="),
    EOI (";"),
    A_PARENTESES ("("),
    F_PARENTESES (")"),
    A_CHAVES ("{"),
    F_CHAVES ("}"),
    NEXTLINE("\n"),
    CHAR_VALUE(""),
    STRING_VALUE(""),
    INT_VALUE(""),
    FLOAT_VALUE(""),
    ID(""),
    DOISPONTOS(":"),
    BOOLEAN_VALUE("");
    
    private String a;
  
    Tokens_List(String paramString1) {
      this.a = paramString1;
    }
}