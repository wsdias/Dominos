import java.util.ArrayList;

public class Dominos{

    private static ArrayList<Tupla> entrada;
    private static ArrayList<Tupla> processar;
    private static ArrayList<Tupla> processadas;
    private static int nPecas;

    public static void main (String[] args){

        int a, b;

        nPecas = Integer.valueOf(args[0]);
        entrada = new ArrayList<Tupla>();

        // Corrigir leitura
        for (int i = 1; i <= nPecas; i = i + 2){

            a = Integer.valueOf(args[i]);
            b = Integer.valueOf(args[i+1]);
            entrada.add(new Tupla(a,b));
        }

        for (Tupla t : entrada)
            System.out.println("("+t.a()+", "+t.b()+")");

        //System.out.println(BuscarSolucao());
        Iterativo();
    }

    /*private static boolean BuscarSolucao(){

        boolean aux = true;
        int i = 0;

        while(aux){

            aux = i != processar.size()-1 ? true : false;
            if (aux) aux = Buscar(processar.get(i), i);
        }
        return aux;
    }*/

    /*private static boolean Buscar(Tupla t, int i){

        
    }*/

    public static void Iterativo(){

        int[] sequencia = new int[nPecas];

        int posicao = 0;
        for (int i = 0; i < nPecas; i++){

            for (int j = 0; j < nPecas; j++){

                if (i != j){

                    if (entrada.get(i).b() == entrada.get(j).a()){
                        // ...
                    }
                    // flip...
                }
            }
        }
    }
}

class Tupla{

    private int a;
    private int b;

    Tupla(int a, int b){

        this.a = a;
        this.b = b;
    }

    public int a(){
        return a;
    }

    public int b(){
        return b;
    }

    public void flip(){

        int aux = a;
        a = b;
        b = aux;
    }
}
