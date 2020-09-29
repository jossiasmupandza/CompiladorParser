package analisador.auxiliares;


import java.io.*;
public class Validacao {
    BufferedReader br;
    
    public Validacao() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public byte validarByte(String str, byte min, byte max) {
        byte b = 0;
        
        do {
            System.out.println(str);
            try {
                b = Byte.parseByte(br.readLine());
            } catch (NumberFormatException x) {
                System.out.println("O valor introduzido nao é um inteiro!");
            } catch (IOException y) {
                System.out.println(y.getMessage());
            }
            if(b < min || b > max) 
                System.out.println("Valor Invalido, tente novamente!");
        } while (b < min || b > max);
        
        return b;
    }
    
    public short validarShort(String m, short x, short y) {
        short s = 0;
        
        do {
            System.out.println(m);
            try {
                s = Short.parseShort(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("O valor introduzido nao é um inteiro!");
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
            if (s < x || s>y) 
                System.out.println("Valor Invalido!");
        } while (s< x || s> y);
        
        return s;
    }
        
    public int validarInt(String st, int a, int b){
        int i = 0;
        
        do { 
            System.out.println(st);
            try {
                i = Integer.parseInt(br.readLine());
            }  catch (NumberFormatException nf) {
                System.out.println("O valor introduzido nao é um inteiro!");
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }
             if (i < a || i > b) 
                System.out.println("Valor Invalido!");
        } while (i < a || i > b);
        
        return i;
    }  
    
    public long validarLong(String mes, long a, long b) {
        long l = 0;
        
        do {
            System.out.println(mes);
            try {
                l = Long.parseLong(br.readLine());
            } catch (NumberFormatException nf) {
                System.out.println("O valor introduzido nao é um inteiro!");
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }
            if (l < a || l > b)
                System.out.println("Valor Invalido!");
        } while (l < a || l > b);
        
        return l;
    }
    
     public float validarFloat(String msg, float x, float y) {
        float f = 0f;
        
        do {
            System.out.println(msg);
            try {
                f = Float.parseFloat(br.readLine());
            } catch (NumberFormatException nf) {
                System.out.println("O valor introduzido nao é um inteiro!");
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }    
            if (f<x || f>y)
                System.out.println("Valor Invalido!");
        } while (f<x || f>y);
        return f;
    }
    
    
    public double validarDouble(String mes, double t, double r) {
        double d = 0;
        
        do {
            System.out.println(mes);
            try {
                d = Double.parseDouble(br.readLine());
            } catch (NumberFormatException nf) {
                System.out.println("O valor introduzido nao é um inteiro!");
            } catch (IOException io) {
                System.out.println(io);
            }
            if (d < t || d > r)
                System.out.println("Valor Invalido!");
        } while (d < t || d > r);
        
        return d;
    }
    
    public boolean validarBoolean(String str) {
        char res = 's';
        boolean b = false;
        do {
            System.out.println(str);
            try {
                res = br.readLine().charAt(0);
                } catch (IOException io) {
                System.out.println(io);
            }
            if (res == 's' || res == 'S')
                b = true;
            else 
                if(res == 'n' || res == 'N')
                    b = false; 
                else
                    if(res == 's' && res == 'S'&& res == 'n' && res == 'N')
                        System.out.println ("Resposta invalida! Tente de novo ");
        } while(res == 's' && res == 'S'&& res == 'n' && res == 'N'); 
        return b;
    }
    
    public char validarChar(String men, char a, char b, char c, char d) {
        char res = 'a';
        
        do {
            System.out.print(men);
            try {
                res = br.readLine().charAt(0);
            } catch(StringIndexOutOfBoundsException sofb) {
                System.out.println("Nao Introduziu nenhum valor!");
            } catch (IOException io) {
                System.out.println(io);
            }
            if(res != a && res != b && res != c && res != d)
               System.out.println ("Resposta invalida! Tente de novo ");
        } while(res != a && res != b && res != c && res != d);
        
        return res;
    }
    public String validarString(String men, byte i, byte j) {
        String s = "";
        
        do { 
            System.out.println(men);
            try {
                s = br.readLine();
            } catch (IOException io) {
                System.out.println(io);
            }
            if (s.length() < i || s.length() > j) 
                System.out.println("Invalido! palavara de ter entre "+i+"-"+j+" caracteres");
        } while (s.length() < i || s.length() > j); 
        
        return s;
    }
}
