package nsp.compiler.AnSin.Regras.RegrasBloco.Variable.exp;

import java.util.List;

import nsp.compiler.AnLex.Token;
import nsp.compiler.AnLex.Tokens_List;
import nsp.compiler.AnSin.Exp.Expressao;
import nsp.compiler.AnSin.Regras.Error;
import nsp.compiler.AnSin.Utils.Utils;
import nsp.compiler.Arvore.GeradorArvore;

public class exp {
    
    private int pos;
    private List<Token> tokens;
    private Expressao expr;

    public exp(List<Token> tokens){
        this.tokens = tokens;
        this.expr = new Expressao();
        this.expr.grAvalInicio();
    }   

    public int run(int pos){
        this.pos = pos;
        if(isValor()){
            this.expr.grAvalValor(this.tokens.get(this.pos).lexeme);
            System.out.println(this.expr.pilha);
            GeradorArvore.grArvLex(this.tokens, this.pos);
            this.pos ++;
            this.pos = run(this.pos);
        }else if(this.tokens.get(this.pos).tipo != Tokens_List.EOI){
            if(this.tokens.get(this.pos).tipo == Tokens_List.ADICAO){
                GeradorArvore.grArvLex(this.tokens, this.pos);
                this.pos ++;
                this.expr.grAvalValor(this.tokens.get(this.pos).lexeme);
                System.out.println(this.expr.pilha);
                GeradorArvore.grArvLex(this.tokens, this.pos);
                this.expr.grAvalMais();
                System.out.println(this.expr.pilha);
                this.pos ++;
                this.pos = run(this.pos);
            }else if(this.tokens.get(this.pos).tipo == Tokens_List.SUBTRACAO){
                GeradorArvore.grArvLex(this.tokens, this.pos);
                this.pos ++;
                this.expr.grAvalValor(this.tokens.get(this.pos).lexeme);
                System.out.println(this.expr.pilha);
                GeradorArvore.grArvLex(this.tokens, this.pos);
                this.expr.grAvalMenos();
                System.out.println(this.expr.pilha);
                this.pos ++;
                this.pos = run(this.pos);
            }
        }else{
            this.pos -- ;
        }

        return this.pos;
    }

    public boolean isValor(){
        switch (this.tokens.get(this.pos).tipo) {
            case INT_VALUE:
            case FLOAT_VALUE:
            case CHAR_VALUE:
            case BOOLEAN_VALUE:
            case STRING_VALUE:
                return true;
        
            default:
                return false;
                
        }
    }
}
