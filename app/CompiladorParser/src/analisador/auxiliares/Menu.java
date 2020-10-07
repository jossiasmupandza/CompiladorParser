package analisador.auxiliares;   

public class Menu {
    private Tarrefas ta;
    private Validacao val;
    
    public Menu() {
        ta = new Tarrefas();
        val =  new Validacao();
    }
    
    public void menuPrincipal() {
        byte op;
        do {
            System.out.println("========== Analisador Lexico =============");
            System.out.println("1. Gerar novo Analisador Lexico");
            System.out.println("2. Realizar Analise Lexica");
            System.out.println("3.Sair");
            System.out.println("==========================================");
            op = val.validarByte("Introduza uma opcao: ", (byte) 1, (byte) 3);
            System.out.println();
            
            switch (op) {
                case 1:
                    ta.gerarNovoAnalisador();
                    clearScreen();
                    System.out.println("\nNova classe AnaLex.java gerada com sucesso!\n");
                    break;
                case 2: 
                    menuAnaliseLexica();
                    break;
                case 3: System.out.println("\n----- Fim de Execusao -----\n\n");break;
            }
        } while(op != 3);
        
    }
    
    private void menuAnaliseLexica() {
        byte op;
        do {
            System.out.println("========== Analise Lexica =============");
            System.out.println("1. Ler ficheiro padrao (teste.muco)");
            System.out.println("2. Ler novo ficheiro .muco");
            System.out.println("3.voltar");
            System.out.println("==========================================");
            op = val.validarByte("Introduza uma opcao: ", (byte) 1, (byte) 3);
            System.out.println();
            
            switch (op) {
                case 1:
                    ta.lerFicherioPadrao();
                    System.out.println("");
                    break;
                case 2: 
                    ta.lerNovoFicheiro();
                    System.out.println("");
                    break;
            }
        } while(op != 3);
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");   
        System.out.flush();
    }
}
