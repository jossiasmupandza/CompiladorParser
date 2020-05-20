package analisadorlexico;

import java.io.IOException;
import java.io.StringReader;

public class TesteAnalisadorLexico {
    public static void main(String[] args) throws IOException {
        //conjuto de caracteres/instrucoes a serem analisadas
        String expr = "if 2+3+4 then";
        
        AnalisadorLexico lexico =  new AnalisadorLexico(new StringReader(expr));
        lexico.yylex();
    }
}
