package nsp.compiler.AnSin;

import java.util.List;

import nsp.compiler.AnLex.Token;

public class Sintatico {
    public List<Token> tokenList;

    public int pos;

    public Sintatico(){
        this.pos = 0;
    }


    private void lookAhead(){
        this.pos ++;
    }
    private void lookAhead(int jump){
        this.pos += jump;
    }
}
