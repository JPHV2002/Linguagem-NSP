package nsp.compiler.AnSin.Regras;

import java.util.List;

import nsp.compiler.AnLex.Token;
import nsp.compiler.AnLex.Tokens_List;

public class Functions {
    public List<Token> tokens;
    public int pos;
    private Bloco bloco;
    
    public Functions(List<Token> tokenList, int pos){
        this.tokens = tokenList;
        this.pos = pos;
        
    }

    public int run(){
        match(Tokens_List.ID);
        match(Tokens_List.A_PARENTESES);
        isParams();
        match(Tokens_List.F_PARENTESES);
        match(Tokens_List.DOISPONTOS);
        isTipo();
        match(Tokens_List.A_CHAVES);
        lookAhead();
        this.pos = (this.bloco = new Bloco(this.tokens, this.pos)).run();
        return this.pos;
    }

    public void match(Tokens_List esperado){
        lookAhead();
        if (this.tokens.get(this.pos).tipo == esperado){
            //Não Faz Nada
            // System.out.printf("\t%s - %s\n",this.tokens.get(this.pos).tipo, esperado);
        }else{
            Error.errorToken(this.tokens.get(this.pos).tipo, esperado);
        }
    }

    private void lookAhead(){
        this.pos ++;
    }

    private void isTipo(){
        lookAhead();
        switch (this.tokens.get(this.pos).tipo) {
            case INT:
            case FLOAT:
            case BOOLEAN:
            case CHAR:
            case STRING:
            case VOID:
                break;
            default:
                Error.errorTipo(this.tokens.get(this.pos).tipo);
                break;
        }
    }

    private void isParams(){
        match(Tokens_List.ID);
        match(Tokens_List.DOISPONTOS);
        isTipo();
        if(this.tokens.get(this.pos+1).tipo == Tokens_List.VIRGULA){
            lookAhead();
            isParams();
        }
    }
}
