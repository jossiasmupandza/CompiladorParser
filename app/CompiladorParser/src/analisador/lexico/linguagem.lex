package analisador.lexico;
 
%%

%{ 
/*-*  * funcoes e variaveis  */ 

private void imprimir(String descricao, String lexema) {   
    System.out.println(lexema + " - " + descricao);    
} 


 
%} 
 
/*-*  * informacoes sobre a clase gerada  */ 
%public 
%class AnaLex
%type MucofotiToken 
 
 
/*-*  * definicaoes de regulares  */ 
BRANCO = [\n| |\t] 
ID = [_|a-z|A-Z][a-z|A-Z|0-9|_]* 
INTEIRO = 0|[1-9][0-9]* 
PONTOFLUTUANTE = [0-9][0-9]*"."[0-9]+ 
OPERADORES_MATEMATICOS = ("+" | "-" | "*" | "/") 
 
%% 
 
"if"                        { return new MucofotiToken(yytext(),yyline, "Instrucao if"); } 
"then"                      { return new MucofotiToken(yytext(),yyline, "Instrucao then"); } 
{BRANCO}                    { return new MucofotiToken(yytext(),yyline, "Espaco Branco"); } 
{ID}                        { return new MucofotiToken(yytext(),yyline, "Identificador"); } 
{INTEIRO}                   { return new MucofotiToken(yytext(),yyline, "Numero inteiro"); } 
{PONTOFLUTUANTE}            { return new MucofotiToken(yytext(),yyline, "Ponto Flutuante"); } 
{OPERADORES_MATEMATICOS}    { return new MucofotiToken(yytext(),yyline, "Operador Matematico"); } 
"=="                        { return new MucofotiToken(yytext(),yyline, "Operador de Igualidade"); } 
 
. { throw new RuntimeException("Caractere invalido \"" + yytext() +        
                            "\" na linha " + yyline + ", coluna " + yycolumn); } 