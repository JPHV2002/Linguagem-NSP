package nsp.compiler.AnSin.Exp;

import java.util.Stack;

public class Expressao {
    public Stack<Integer> pilha = null;

    public void grAvalInicio() {
        pilha = new Stack<Integer>();
    }

    public void grAvalValor(String valor){
        var digito = Integer.parseInt("" + valor);
        pilha.push(digito);
    }

    public void grAvalMais() {
        int exp2 = pilha.pop();
        int exp1 = pilha.pop();
        pilha.push(exp1 + exp2);
    }

    public void grAvalMenos() {
        int exp2 = pilha.pop();
        int exp1 = pilha.pop();
        pilha.push(exp1 - exp2);
    }

    public Stack<Integer> pilha() {
        return pilha;
    }
}