package nsp.compiler.AnSin.Regras;

import java.util.List;

import nsp.compiler.AnLex.Token;
import nsp.compiler.AnLex.Tokens_List;
import nsp.compiler.AnSin.Regras.RegrasBloco.variableAttribution;
import nsp.compiler.AnSin.Regras.RegrasBloco.variableDeclaration;

/* Bloco:
 *      Declaracao de variavel
 *      Atribuicao de variavel
 *      
 */
        

public class Bloco {
    public List<Token> tokens;
    public int pos;
    public variableDeclaration vd;
    public variableAttribution va;

    public Bloco(List<Token> tokenList, int pos){
        this.tokens = tokenList;
        this.pos = pos;
        this.vd = new variableDeclaration(this.tokens);
        this.va = new variableAttribution(this.tokens);
    }

    public int run(){
        if(this.tokens.get(this.pos).tipo != Tokens_List.F_PARENTESES){
            if(isTipo()){
                this.pos = this.vd.run(this.pos);
                run();
            }else if(this.tokens.get(this.pos).tipo == Tokens_List.ID){
                this.pos = this.va.run(this.pos);
            }
        }
        return this.pos+1;
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

    private boolean isTipo(){
        switch (this.tokens.get(this.pos).tipo) {
            case INT:
            case FLOAT:
            case BOOLEAN:
            case CHAR:
            case STRING:
            case VOID:
                return true;
            default:
                return false;
        }
    }
}
