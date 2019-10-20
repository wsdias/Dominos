/*
 *  T3 - Projeto e Otimização de Algoritmos
 *
 *  Willian Schmiele Dias
 *
 *  2019/2
 *
 */

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Dominos{

    private static ArrayList<Tupla> entrada;
    private static Tupla[] solucao;
    private static int nPecas;
    private static boolean achou;

    public static void main (String[] args){

        if (args.length > 0 && !args[0].isEmpty()){

            lerArquivo(args[0]);
            IniciarBusca();
            ImprimirResposta();
        }
        else System.out.println("Formato: java Dominos arquivo");
    }

    /* -------------------------------------------------------------------------------- */

    private static void IniciarBusca(){

        ArrayList<Tupla> disponiveis;
        int i, j;
        Tupla t;

        solucao = new Tupla[nPecas];
        achou = false;

        for (i = 0; i < entrada.size(); i++){

            disponiveis = new ArrayList<Tupla>();
            for (j = 0; j < entrada.size(); j++)
                disponiveis.add(entrada.get(j));
            disponiveis.remove(i);

            t = entrada.get(i);
            solucao[0] = t;
            BuscarSolucao(t, disponiveis, 1);
            if (achou) break;

            t.flip();
            BuscarSolucao(t, disponiveis, 1);
            if (achou) break;
        }
    }

    /* -------------------------------------------------------------------------------- */

    private static void BuscarSolucao(Tupla t, ArrayList<Tupla> disponiveis, int pos){

        Tupla u;
        int i;

        if (disponiveis.isEmpty()) achou = true;
        else{

            for (i = 0; i < disponiveis.size(); i++){

                u = disponiveis.get(i);
                if (t.b() == u.a()){

                    disponiveis.remove(u);
                    solucao[pos] = u;
                    BuscarSolucao(u, disponiveis, pos+1);
                }
                else if (t.b() == u.b()){

                    disponiveis.remove(u);
                    u.flip();
                    solucao[pos] = u;
                    BuscarSolucao(u, disponiveis, pos+1);
                }
                if (achou) break;
            }
        }
    }

    /* -------------------------------------------------------------------------------- */

    private static void ImprimirResposta(){

        if (achou){

            for (int i = 0; i < solucao.length; i++)
                System.out.print(solucao[i].a() + " " + solucao[i].b() + " ");
            System.out.println();
        }
        else System.out.println("Não foi encontrada uma solução!");
    }

    /* -------------------------------------------------------------------------------- */

    public static void lerArquivo(String nomeArquivo){

        BufferedReader buffer;
        FileReader arquivo;
        String[] linha;
        int a, b, i;

        entrada = new ArrayList<Tupla>();
        try{

            arquivo = new FileReader(nomeArquivo);
            buffer = new BufferedReader(arquivo);
            linha = new String[2];

            nPecas = Integer.valueOf(buffer.readLine());
            for (i = 0; i < nPecas; i++){

                linha = buffer.readLine().split(" ");
                a = Integer.valueOf(linha[0]);
                b = Integer.valueOf(linha[1]);
                entrada.add(new Tupla(a, b));
            }
            arquivo.close ();
        }
        catch (IOException e){

            System.err.println (e.getMessage ());
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
