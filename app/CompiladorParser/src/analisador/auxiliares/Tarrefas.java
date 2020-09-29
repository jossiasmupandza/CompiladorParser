/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador.auxiliares;

import analisador.lexico.AnaLex;
import analisador.lexico.Gerador;
import analisador.lexico.MucofotiToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
        
public class Tarrefas {
    
    private Visualizacao vis;
    private Validacao val;
    
    public Tarrefas() {
        vis = new Visualizacao();
        val = new Validacao();
    }
    
    public void gerarNovoAnalisador() {
        new Gerador();
    }
    
    public void lerFicherioPadrao() {
        try {
            String rootPath = Paths.get("").toAbsolutePath().toString();
            String subPath = "/src/analisador/lexico/";
            String file = rootPath + subPath + "teste.muco";
            
            AnaLex al = new AnaLex(new FileReader(file));
            
            MucofotiToken token;
            while((token = al.yylex()) != null) {
                vis.visAnaliseLexica(token);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void lerNovoFicheiro() {
        try {
            String nome = val.validarString("Introduza o nome do ficheiro .muco:", (byte)1, (byte)100);
            
            String rootPath = Paths.get("").toAbsolutePath().toString();
            String subPath = "/src/analisador/lexico/";
            String file = rootPath + subPath + nome + ".muco";
            
            AnaLex al = new AnaLex(new FileReader(file));
            
            MucofotiToken token;
            while((token = al.yylex()) != null) {
                vis.visAnaliseLexica(token);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao encotrado: " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
}
