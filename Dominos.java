import java.util.ArrayList;

public class Dominos{

    private static ArrayList<Tupla> entrada;
    private static Tupla[] solucao;
    private static int nPecas;
    private static boolean achou;

    public static void main (String[] args){

        int a, b;

        nPecas = Integer.valueOf(args[0]);
        entrada = new ArrayList<Tupla>();
        solucao = new Tupla[nPecas];

        // Trocar leitura de arquivo padrão
        for (int i = 1; i <= nPecas; i = i + 2){

            a = Integer.valueOf(args[i]);
            b = Integer.valueOf(args[i+1]);
            entrada.add(new Tupla(a,b));
        }
        /* ----------------------------- */

        for (Tupla t : entrada)
            System.out.println("("+t.a()+", "+t.b()+")");

        IniciarBusca();
    }

    private static void IniciarBusca(){

        ArrayList<Tupla> disponiveis;
        int i, j;

        achou = false;
        for (i = 0; i < entrada.size(); i++){

            disponiveis = new ArrayList<Tupla>();
            for (j = 0; j < entrada.size(); j++)
                disponiveis.add(entrada.get(j));
            disponiveis.remove(i);
            solucao[0] = entrada.get(i);
            BuscarSolucao(entrada.get(i), disponiveis, 1);
            if (achou) break;
        }

        ImprimeResposta();
    }

    private static void BuscarSolucao(Tupla t, ArrayList<Tupla> disponiveis, int pos){

        Tupla u;
        int i;

        //System.out.println("pos: " + pos);

        if (disponiveis.isEmpty()) achou = true;
        else{

            for (i = 0; i < disponiveis.size(); i++){

                u = disponiveis.get(i);
                if (t.b() == u.a()){

                    //System.out.println("Igual: "+t.a()+" == "+u.a()+" & "+t.b()+" , "+u.b());
                    disponiveis.remove(u);
                    solucao[pos] = u;
                    BuscarSolucao(u, disponiveis, pos+1);
                }
                else if (t.b() == u.b()){

                    //System.out.println("Igual: "+t.a()+" == "+u.a()+" & "+t.b()+" , "+u.b());
                    disponiveis.remove(u);
                    u.flip();
                    solucao[pos] = u;
                    BuscarSolucao(u, disponiveis, pos+1);
                }
                if (achou) break;
            }
        }
    }

    private static void ImprimeResposta(){

        if (achou){

            for (int i = 0; i < solucao.length; i++)
                if (solucao[i] != null)
                    //System.out.print(solucao[i].a() + " " + solucao[i].b() + " ");
                    System.out.print("[" + solucao[i].a() + " " + solucao[i].b() + "] ");
            System.out.println();
        }
        else System.out.println("Não foi encontrada uma solução!");
    }

    /*private static ArrayList<Tupla> construirDiponiveis(Tupla t, ArrayList<Tupla> tuplas){

        ArrayList<Tupla> disponiveis = new ArrayList<Tupla>();
        for (int i = 0; i < tuplas.size(); i++)
            if (!t.igual(tuplas.get(i)) disponiveis.add(tuplas.get(i));
        return disponiveis;
    }*/
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

    public boolean igual(Tupla t){

        if (a == t.a() && b == t.b())
            return true;
        return false;
    }
}
