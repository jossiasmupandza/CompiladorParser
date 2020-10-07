package analisador.lexico;
import java_cup.runtime.*;

%%

%{ 
/* funcoes e variaveis  */ 

%} 
 
/* informacoes sobre a clase gerada  */ 
%public 
%class AnaLex
%type MucofotiToken
%line 
%column
  
/* Definicao de Regulares  */ 
Identificador = [_|a-z|A-Z][a-z|A-Z|0-9|_]* 
Inteiro = 0|[1-9][0-9]* 
PontoFlutuante = [0-9][0-9]*"."[0-9]+ 
OperadorMatematico = ("+" | "-" | "*" | "/")

/* Espaco em Branco */
FinalizadorDeLinha = \r|\n|\r\n
CaracterDeEntrada = [^\r\n]
EspacoBranco = {FinalizadorDeLinha} | [ \t\f]

/* Comentarios */
Comentario = {ComentarioTradicional} | {ComentarioFimDeLinha} | {ComentarioDocumento}
ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/"
ComentarioFimDeLinha = "//" {CaracterDeEntrada}* {FinalizadorDeLinha}?
ComentarioDocumento = "/**" {ConteudoDoComentario} "*"+ "/"
ConteudoDoComentario = ( [^*] | \*+ [^/*] )*

%% 
/* Comentarios */
{Comentario}                { /* ignore */ }

/* Espaco em branco */
{EspacoBranco}              { /* ignore */ }

/* Identificadores */
{Identificador}             { return new MucofotiToken(yytext(),yyline, "Identificador"); } 

/* Numeros inteiros e decimais */
{Inteiro}                   { return new MucofotiToken(yytext(),yyline, "Numero inteiro"); } 
{PontoFlutuante}            { return new MucofotiToken(yytext(),yyline, "Ponto Flutuante"); }

/* operadores matematicos */
{OperadorMatematico}        { return new MucofotiToken(yytext(),yyline, "Operador Matematico"); }

/* Palavras reservadas */
"se"                        { return new MucofotiToken(yytext(),yyline, "Instrucao se"); } 
"entao"                     { return new MucofotiToken(yytext(),yyline, "Instrucao entao"); }        

/* Operadores logicos */ 
"=="                        { return new MucofotiToken(yytext(),yyline, "Operador de Igualidade"); }

/* Simbolos especiais */
";"                         { return new MucofotiToken(yytext(),yyline, "Ponto e virgula"); }
"="                         { return new MucofotiToken(yytext(),yyline, "Atribuicao"); }
 
. { throw new RuntimeException("Caractere invalido \"" + yytext() +        
                            "\" na linha " + yyline + ", coluna " + yycolumn); } 