package nsp.compiler;

import java.util.List;

import nsp.compiler.AnLex.Lexico;
import nsp.compiler.AnLex.Token;

public class Compile {

    public List<Token>  lexico(String codFont){
        System.out.print("Analise Lexica... ");
        Lexico anLexico;
        (anLexico = new Lexico()).codFont = codFont;
        return anLexico.setTokens();
    }
}
