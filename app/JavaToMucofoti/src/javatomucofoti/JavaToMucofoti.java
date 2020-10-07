package javatomucofoti;

import java.io.*;

public class JavaToMucofoti {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n1,n2, maior;
        
        System.out.print("Introduza o 1-o valor:");
        n1 = Integer.parseInt(br.readLine());
        
        System.out.print("Introduza o 2-o valor:");
        n2 = Integer.parseInt(br.readLine());
        
        maior = detMaior(n1,n2);
        visualizar(maior);
    }
    
    private static int detMaior(int n1, int n2) {
       int maior;
        if (n1 > n2) {
            maior = n1;
        } else {
            maior = n2;
        }
        return maior;
    }
    
    private static void visualizar(int maior){
        for(int i = 1; i<=20; i++) {
            System.out.println("maior:" + maior);
        }
    }
}
