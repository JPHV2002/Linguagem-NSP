package nsp.compiler.AnLex;

public enum Tokens_List{
    FUNCTION("func"),
    RETURN("->"),
    INT("int"),
    FLOAT ("float"),
    BOOLEAN("boolean"),
    CHAR("char"),
    STRING("string"),
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
    NEXTLINE("\n");
    
    
    private String a;
  
    Tokens_List(String paramString1) {
      this.a = paramString1;
    }
}