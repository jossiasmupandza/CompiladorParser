package analisadorlexico;
/**
 *
 * @author Jossias Mupandza
 */
/*
classe que ira gerar o analisador léxico a cada nova alteração no arquivo de 
especificação. Isso evita o uso da linha de comando para gerar a classe Java 
responsável por implementar o algoritmo de reconhecimento de tokens.

NOTA 1: caso altere a liniguagem no ficheiro linguagem.lex  corra o Gerador.java
para gerar um novo AnalisadorLexico.java

Nota 2: o gerador cria um bug na linha "return null", basta commentar a mesma linha
pa resolver o bug

NOTA 3: comente essa classe quando for testar um conjunto de instrucoes usando a classe
    TesteAnalisadorLexico.java
 */

/*
import java.io.File;
import java.nio.file.Paths;

public class Gerador {
    
    public static void main(String[] args) {
        
        String rootPath = Paths.get("").toAbsolutePath().toString();
        
        String subPath = "/src/analisadorlexico/";

        String file = rootPath + subPath + "linguagem.lex";

        File sourceCode = new File(file);
        
        jflex.Main.generate(sourceCode);
    }
    
}
