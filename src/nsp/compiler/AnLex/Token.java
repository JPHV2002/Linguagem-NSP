package nsp.compiler.AnLex;

public class Token {
    
    public final Tokens_List tipo;
    public final int line;
    public final int col_Start;
    public final int col_End;
    public final String lexeme;

    public Token(Tokens_List tipo, int line, int col_Start, int col_End){
        this.tipo = tipo;
        this.line = line;
        this.col_Start = col_Start;
        this.col_End = col_End;
        this.lexeme = "";
    }

    public Token(Tokens_List tipo, int value, int line, int col_Start, int col_End){
        this.tipo = tipo;
        this.line = line;
        this.lexeme = "" + value;
        this.col_Start = col_Start;
        this.col_End = col_End;
    }
    
    public Token(Tokens_List tipo, Float value, int line, int col_Start, int col_End){
        this.tipo = tipo;
        this.line = line;
        this.lexeme = "" + value;
        this.col_Start = col_Start;
        this.col_End = col_End;
    }

    public Token(Tokens_List tipo, String value, int line, int col_Start, int col_End){
        this.tipo = tipo;
        this.line = line;
        this.lexeme = "" + value;
        this.col_Start = col_Start;
        this.col_End = col_End;
    }

    public String toString(){
        return String.format("[%d | %d-%d | <%s> | %s]", this.line, this.col_Start, this.col_End, this.tipo, this.lexeme);
    }
}
