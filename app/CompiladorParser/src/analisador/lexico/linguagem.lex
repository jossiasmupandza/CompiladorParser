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

/* Operadores Aritmeticos */
"+"                         { return new MucofotiToken(yytext(),yyline, "Operador Aritmetico - Adicao"); }
"-"                         { return new MucofotiToken(yytext(),yyline, "Operador Aritmetico - Subtracao"); }
"*"                         { return new MucofotiToken(yytext(),yyline, "Operador Aritmetico - Multiplicacao"); }
"/"                         { return new MucofotiToken(yytext(),yyline, "Operador Aritmetico - Divisao"); }
"#"                         { return new MucofotiToken(yytext(),yyline, "Operador Aritmetico - Resto da Devisao"); }

/* Operadores Logicos */ 
"&"                         { return new MucofotiToken(yytext(),yyline, "Operador Logico - E"); }
"|"                         { return new MucofotiToken(yytext(),yyline, "Operador Logico - OU"); }

/* Estruturas de Selecao */
"se"                        { return new MucofotiToken(yytext(),yyline, "Instucao de selecao simples"); }
"entao"                     { return new MucofotiToken(yytext(),yyline, "Instrucao de selecção em alternativa"); }
"escolha"                   { return new MucofotiToken(yytext(),yyline, "Instucao de selecao multipla"); }
"caso"                      { return new MucofotiToken(yytext(),yyline, "Instucao de selecao multipla"); }

/* Estruturas de Repeticao */
"enquanto"                  { return new MucofotiToken(yytext(),yyline, "estrutura de repeticao"); } 
"para"                      { return new MucofotiToken(yytext(),yyline, "estrutura de repeticao"); }
"faca"                      { return new MucofotiToken(yytext(),yyline, "estrutura de repeticao"); }

/* Tipos de Dados Primitivos*/ 
"inteiro"                   { return new MucofotiToken(yytext(),yyline, "Tipo de dado para numeros inteiro"); } 
"decimal"                   { return new MucofotiToken(yytext(),yyline, "Tipo de dado para numeros decimais"); } 
"logico"                    { return new MucofotiToken(yytext(),yyline, "Tipo de dado para valores binarios(verdade ou falso)"); }
"literal"                   { return new MucofotiToken(yytext(),yyline, "Tipo de dado para numeros inteiro"); }

/* Tipos de Dados Nao Primitivos */
"vazio"                     { return new MucofotiToken(yytext(),yyline, "Subprograma sem retorno"); }
"matriz"                     { return new MucofotiToken(yytext(),yyline, "Estrutura de dados"); }       

/* Operadores Relacionais */ 
"<>"                       { return new MucofotiToken(yytext(),yyline, "Operador Relacional - Diferente"); }
"<"                        { return new MucofotiToken(yytext(),yyline, "Operador Relacional - Menor"); }
"<="                       { return new MucofotiToken(yytext(),yyline, "Operador Relacional - Menor ou igual"); }
">"                        { return new MucofotiToken(yytext(),yyline, "Operador Relacional - Maior"); }
">="                       { return new MucofotiToken(yytext(),yyline, "Operador Relacional - Maior ou igual"); }                 
"=="                       { return new MucofotiToken(yytext(),yyline, "Operador Relacional - Igual"); }           


/* Caracteres Especiais */
";"                        { return new MucofotiToken(yytext(),yyline, "Ponto e virgula"); }
":="                       { return new MucofotiToken(yytext(),yyline, "Atribuicao"); }
"{"                        { return new MucofotiToken(yytext(),yyline, "Caracter especial - Abre chave"); }
"}"                        { return new MucofotiToken(yytext(),yyline, "Caracter especial - Fecha chave"); }
"("                        { return new MucofotiToken(yytext(),yyline, "Caracter especial - Abre Par"); }
")"                        { return new MucofotiToken(yytext(),yyline, "Caracter especial - Fecha Par"); }
"["                        { return new MucofotiToken(yytext(),yyline, "Caracter especial - Abre Par Recto"); }
"]"                        { return new MucofotiToken(yytext(),yyline, "Caracter especial - Fecha Par Recto"); }
"."                        { return new MucofotiToken(yytext(),yyline, "Caracter especial - Ponto"); }

/* Funcoes */
 
. { throw new RuntimeException("Caractere invalido \"" + yytext() +        
                            "\" na linha " + yyline + ", coluna " + yycolumn); } 