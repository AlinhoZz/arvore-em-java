//Aluno: Alisson da Silva Santana 01565877
//Aluno: Leandro de Moraes Amorim 01554634

package arvoreavl;
import java.util.Scanner;
public class ArvoreAVL {

    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        Arvore objArvoreAVL = new Arvore(null);
        No raiz = null;
        
        int opc = 0;
        int valor;
        while (opc != 4) {
            System.out.println("#### ARVORE AVL ####");
            System.out.println("1 - Inserir Número");
            System.out.println("2 - Remover Número");
            System.out.println("3 - Imprimir Árvore");
            System.out.println("4 - Sair");
            System.out.println("");
            System.out.print("Informe a opção desejada: ");
            opc = ler.nextInt();
            switch (opc) {
                case 1 -> {
                    //INSERIR
                    System.out.print("Informe o Valor: ");
                    valor = ler.nextInt();
                    raiz = objArvoreAVL.inserir(raiz, valor);
                }
                case 2 -> {
                    //REMOVER
                    System.out.print("Informe o Valor: ");
                    valor = ler.nextInt();
                    raiz = objArvoreAVL.remover(raiz, valor);
                }
                case 3 -> //IMPRIMIR
                    objArvoreAVL.imprimirArvore(raiz, 1);
                case 4 -> System.out.println("Sair");
                default -> System.out.println("Opção inválida!");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }

}
