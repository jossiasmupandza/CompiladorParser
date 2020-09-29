/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador.auxiliares;

import analisador.lexico.MucofotiToken;

/**
 *
 * @author Jossias Mupandza
 */
public class Visualizacao {

    public Visualizacao() {
    }
    
    public void visAnaliseLexica(MucofotiToken mt) {
        System.out.println(mt.token + " - " + mt.decricao + " na linha " + mt.linha);
    }
}
