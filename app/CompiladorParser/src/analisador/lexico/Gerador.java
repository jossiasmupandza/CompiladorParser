package analisador.lexico;
/**
 *
 * @author Jossias Mupandza
 */

import java.io.File;
import java.nio.file.Paths;

public class Gerador {
    
    public Gerador() {
        
        String rootPath = Paths.get("").toAbsolutePath().toString();
        
        String subPath = "/src/analisador/lexico/";

        String file = rootPath + subPath + "linguagem.lex";

        File sourceCode = new File(file);
        
        jflex.Main.generate(sourceCode);
    }
    
}
