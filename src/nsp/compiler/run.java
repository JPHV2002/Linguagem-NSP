package nsp.compiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import nsp.compiler.AnLex.Lexico;

public class run {
    public static void main(String args[]) throws IOException{
        Path fileName = Path.of("/home/joao/Documents/Linguagem-NSP/teste.nsp");
 
        String str = Files.readString(fileName);

        Lexico Lexico = new Lexico();
        Lexico.setCodFont(str);
        System.out.println(Lexico.setTokens());
    }
}
