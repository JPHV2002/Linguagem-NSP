package nsp.compiler.AnSin;

import java.util.List;

import nsp.compiler.AnLex.Token;
import nsp.compiler.AnLex.Tokens_List;
import nsp.compiler.AnSin.Regras.Error;
import nsp.compiler.AnSin.Regras.Functions;

public class Sintatico {
    public List<Token> tokenList;
    public int pos;

    private Functions anFunction;

    public Sintatico(){
        this.pos = 0;
    }

    // FUNC ID A_P PAR F_P DOISPONTOS
    public void run(){
        while(this.tokenList.get(this.pos).tipo != Tokens_List.EOF && this.tokenList.get(this.pos).tipo != Tokens_List.MAIN){
            if(this.tokenList.get(this.pos).tipo == Tokens_List.FUNCTION){
                this.anFunction = new Functions(this.tokenList,this.pos);
                this.pos = this.anFunction.run();
            }
        }
    }

    public void match(Tokens_List esperado){
        lookAhead();
        if (this.tokenList.get(this.pos).tipo == esperado){
            //OK
        }else{
            Error.errorToken(this.tokenList.get(this.pos).tipo, esperado);
        }
    }

    private void lookAhead(){
        this.pos ++;
    }
}
