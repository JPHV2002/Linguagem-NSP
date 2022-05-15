package nsp.compiler.AnLex;

import java.util.ArrayList;
import java.util.List;

public class Lexico {
    public String codFont;
    public List<Token> tokens;
    public int pos;
    public int lin;
    public int col;

    public void setCodFont(String condFont){
        this.codFont = condFont;
    }

    public List<Token> setTokens(){
        this.tokens = new ArrayList<>();

        this.pos = 0;
        this.lin = 1;
        this.col = 1;

        int i = this.codFont.length();

        while(this.pos < i){
            if(this.codFont.charAt(this.pos) == '{'){
                this.tokens.add(new Token(Tokens_List.A_CHAVES, this.lin, this.col, this.col));
            }
            if(this.codFont.charAt(this.pos) == '}'){
                this.tokens.add(new Token(Tokens_List.F_CHAVES, this.lin, this.col, this.col));
            }
            if(this.codFont.charAt(this.pos) == '('){
                this.tokens.add(new Token(Tokens_List.A_PARENTESES, this.lin, this.col, this.col));
            }
            if(this.codFont.charAt(this.pos) == ')'){
                this.tokens.add(new Token(Tokens_List.F_PARENTESES, this.lin, this.col, this.col));
            }
            if(this.codFont.charAt(this.pos) == ';'){
                this.tokens.add(new Token(Tokens_List.EOI, this.lin, this.col, this.col));
            }
            if(this.codFont.charAt(this.pos) == '\n'){
                this.col = 0;
                this.lin ++;
            }
            if(this.codFont.charAt(this.pos) == ':'){
                lookAhead();
                if(this.codFont.charAt(this.pos) == '='){
                    this.tokens.add(new Token(Tokens_List.ATRIBUICAO, this.lin, this.col - 1, this.col));
                }
            }
            if(this.codFont.charAt(this.pos) == '-'){
                lookAhead();
                if(this.codFont.charAt(this.pos) == '>'){
                    this.tokens.add(new Token(Tokens_List.RETURN, this.lin, this.col - 1, this.col));
                }else{
                    lookBack();
                    this.tokens.add(new Token(Tokens_List.SUBTRACAO, this.lin, this.col, this.col));
                }
            }
            if(this.codFont.charAt(this.pos) == '+'){
                this.tokens.add(new Token(Tokens_List.ADICAO, this.lin, this.col, this.col));
            }
            if(this.codFont.charAt(this.pos) == '*'){
                this.tokens.add(new Token(Tokens_List.MULTIPLICACAO, this.lin, this.col, this.col));
            }
            if(isLetter(this.codFont.charAt(this.pos))){
                int start = this.col;
                String word = "" + this.codFont.charAt(this.pos);
                lookAhead();
                while(isLetter(this.codFont.charAt(this.pos))){
                    word += this.codFont.charAt(this.pos);
                    lookAhead();
                }
                lookBack();
                if(word.length() > 1){
                    this.tokens.add(new Token(Tokens_List.STRING, word,this.lin,start, this.col));
                }else{
                    this.tokens.add(new Token(Tokens_List.CHAR, word,this.lin, start, this.col));
                }
                
            }
            if(isDig(this.codFont.charAt(this.pos))){
                int start = this.col;
                String number = "" + this.codFont.charAt(this.pos);
                lookAhead();
                while(isDig(this.codFont.charAt(this.pos))){
                    number += this.codFont.charAt(this.pos);
                    lookAhead();
                }
                if(this.codFont.charAt(this.pos) == '.'){
                    lookAhead();
                    number += ".";
                    while(isDig(this.codFont.charAt(this.pos))){
                        number += this.codFont.charAt(this.pos);
                        lookAhead();
                    }
                    this.tokens.add(new Token(Tokens_List.FLOAT, Float.parseFloat(number),this.lin, start, this.col));
                }else{
                    this.tokens.add(new Token(Tokens_List.INT, Integer.parseInt(number),this.lin, start, this.col));           
                }
                lookBack();
            }
            this.col ++;
            this.pos ++;
        }

        return this.tokens;
    }

    public boolean isDig(char value){
        return ('0' <= value && value <= '9');
    }

    public boolean isLetter(char value){
        return (('A' <= value && value <= 'Z') || ('a' <= value && value <= 'z'));
    }

    public void lookAhead(){
        this.pos ++;
        this.col ++;
    }
    public void lookAhead(int jump){
        this.pos += jump;
        this.col += jump;
    }

    public void lookBack(){
        this.pos --;
        this.col --;
    }
    public void lookBack(int jump){
        this.pos -= jump;
        this.col -= jump;
    }
}
