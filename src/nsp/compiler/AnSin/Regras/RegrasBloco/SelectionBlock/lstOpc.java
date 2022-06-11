package nsp.compiler.AnSin.Regras.RegrasBloco.SelectionBlock;

import java.util.List;

import nsp.compiler.AnLex.Token;
import nsp.compiler.AnLex.Tokens_List;
import nsp.compiler.AnSin.Regras.RegrasBloco.Retorno.Return;
import nsp.compiler.AnSin.Regras.RegrasBloco.Show.Show;
import nsp.compiler.AnSin.Regras.RegrasBloco.Variable.variableAttribution;
import nsp.compiler.AnSin.Regras.RegrasBloco.Variable.variableDeclaration;
import nsp.compiler.AnSin.Regras.Error;

public class lstOpc {
    public List<Token> tokens;
    public int pos;
    public variableDeclaration vd;
    public variableAttribution va;
    public Return retorno;
    public Show show;

    public lstOpc(List<Token> tokenList){
        this.tokens = tokenList;
        this.vd = new variableDeclaration(this.tokens);
        this.va = new variableAttribution(this.tokens);
        this.retorno = new Return(this.tokens);
        this.show = new Show(this.tokens);
    }

    public int run(int pos){
        this.pos = pos;

        if(this.tokens.get(this.pos).tipo != Tokens_List.F_CHAVES){
            if(isTipo()){
                this.pos = this.vd.run(this.pos);
                run(this.pos);
            }else if(this.tokens.get(this.pos).tipo == Tokens_List.ID){
                this.pos = this.va.run(this.pos);
                run(this.pos);
            }else if(this.tokens.get(this.pos).tipo == Tokens_List.RETURN){
                this.pos = this.retorno.run(this.pos-1);
                run(this.pos);
            }else if(this.tokens.get(this.pos).tipo == Tokens_List.SHOW){
                this.pos = this.show.run(this.pos-1);
                run(this.pos);
            }   
        }

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
