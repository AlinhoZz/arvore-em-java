//Aluno: Alisson da Silva Santana 01565877
//Aluno: Leandro de Moraes Amorim 01554634

package arvoreavl;

public class No {

    private int valor;
    private No noEsquerda;
    private No noDireita;
    private int altura;

    No(int valor) {
        this.valor = valor;
        noEsquerda = null;
        noDireita = null;
        altura = 0;
    }
    
    public static int maior(int a, int b) {
    	return (a>b)? a: b;
    }
    
    public static int alturaNo(No no) {
    	if(no == null) {
    		return -1;
    	}else {
    		return no.altura;
    	}
    }
    
    public static int fatorBalanceamento(No no) {
    	if(no != null) {
    		return (alturaNo(no.noEsquerda)- alturaNo(no.noDireita));
    	}else {
    		return 0;
    	}
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getNoEsquerda() {
        return noEsquerda;
    }

    public void setNoEsquerda(No noEsquerda) {
        this.noEsquerda = noEsquerda;
    }

    public No getNoDireita() {
        return noDireita;
    }

    public void setNoDireita(No noDireita) {
        this.noDireita = noDireita;
    }

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

}
