/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador.lexico;

/**
 *
 * @author Jossias Mupandza
 */
public class MucofotiToken {
    public String token;
    public int linha;
    public String decricao;

    public MucofotiToken(String token, int linha, String decricao) {
        this.token = token;
        this.linha = linha;
        this.decricao = decricao;
    }   
}
