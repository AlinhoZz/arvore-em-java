//Aluno: Alisson da Silva Santana 01565877
//Aluno: Leandro de Moraes Amorim 01554634

package arvoreavl;

public class Arvore {

    private No noraiz;

    public Arvore(No noraiz) {
        this.noraiz = noraiz;
    }

    public boolean isEmpty() {
        if (noraiz == null) {
            return true;
        }
        return false;
    }

    public void imprimirArvore(No raiz, int nivel) {
    	int i;
    	if(raiz != null) {
    		imprimirArvore(raiz.getNoDireita(), nivel+1);
    		System.out.printf("\n\n");
    		
    		for (int j = 0; j < nivel; j++) {
				System.out.printf("\t");
			}
    		System.out.printf("%d", raiz.getValor());
    		imprimirArvore(raiz.getNoEsquerda(), nivel+1);
    	}
    }

    public No inserir(No raiz, int valor) {
    	if(raiz == null) {
    		raiz = new No(valor);
    		return raiz;
    	}else {
    		if(valor<raiz.getValor()) {
    			raiz.setNoEsquerda(inserir(raiz.getNoEsquerda(),valor));
    		}else if(valor > raiz.getValor()) {
    			raiz.setNoDireita(inserir(raiz.getNoDireita(),valor));    			
    		}else {
    			System.out.printf("inserção não realizada!\nO elemento %d¡ existe!\n", valor);
    		}
    	}
    	
    	raiz.setAltura(No.maior(No.alturaNo(raiz.getNoEsquerda()), No.alturaNo(raiz.getNoDireita()))+1);
    	
    	raiz  = balancear(raiz);
    	
        return raiz;
    }

    public No remover(No raiz, int chave) {
    	if(raiz == null) {
    		System.out.println("Valor nÃ£o encontrado!");
    		return null;
    	}else {
    		if(raiz.getValor() == chave) {
    			if(raiz.getNoEsquerda() == null && raiz.getNoDireita() == null) {
    				raiz = null;
    				System.out.printf("Elemento folha removido: %d !\n",chave);
    				return null;
    			}else {
    				if(raiz.getNoEsquerda()!=null && raiz.getNoDireita()!=null) {
    					No aux = raiz.getNoEsquerda();
    					while(aux.getNoDireita()!=null) {
    						aux = aux.getNoDireita();
    					}
    					raiz.setValor(aux.getValor());
    					aux.setValor(chave);
    					System.out.printf("Elemento Trocado: %d !\n",chave);
    					raiz.setNoEsquerda(remover(raiz.getNoEsquerda(), chave));
    					return raiz;
    				}else {
    					No aux;
    					if(raiz.getNoEsquerda()!=null) {
    						aux = raiz.getNoEsquerda();
    					}else {
    						aux = raiz.getNoDireita();
    					}
    					
    					raiz = null;
    					System.out.printf("Elemento com 1 filho removido: %d",chave);
    					return aux;
    				}
    			}
    		}else {
    			if(chave < raiz.getValor()) {
    				raiz.setNoEsquerda(remover(raiz.getNoEsquerda(), chave));
    			}else {
    				raiz.setNoDireita(remover(raiz.getNoDireita(), chave));    				
    			}
    		}
    		
    		raiz.setAltura(No.maior(No.alturaNo(raiz.getNoEsquerda()), 	No.alturaNo(raiz.getNoDireita()))+1);
    		
    		raiz = balancear(raiz);
    		
    		return raiz;
    	}
    }
    
    private No rotacao_Esquerda(No no) {
    	No y, f;
    	
    	y = no.getNoDireita();
    	f = y.getNoEsquerda();
    	
    	y.setNoEsquerda(no);
    	no.setNoDireita(f);
    	
    	no.setAltura(No.maior(No.alturaNo(no.getNoEsquerda()), No.alturaNo(no.getNoDireita()))+1);
    	y.setAltura(No.maior(No.alturaNo(y.getNoEsquerda()), No.alturaNo(y.getNoDireita()))+1);
    	
    	return y;
    }

    private No rotacao_Direita(No no) {
    	No y, f;
    	
    	y = no.getNoEsquerda();
    	f = y.getNoDireita();
    	
    	y.setNoDireita(no);
    	no.setNoEsquerda(f);
    	
    	no.setAltura(No.maior(No.alturaNo(no.getNoEsquerda()), No.alturaNo(no.getNoDireita()))+1);
    	y.setAltura(No.maior(No.alturaNo(y.getNoEsquerda()), No.alturaNo(y.getNoDireita()))+1);
    	
    	return y;
    }
    
    private No rotacao_Direita_Esquerda(No no) {
    	no.setNoDireita(rotacao_Direita(no.getNoDireita()));
    	return rotacao_Esquerda(no);
    }
    
    private No rotacao_Esquerda_Direita(No no) {
    	no.setNoEsquerda(rotacao_Esquerda(no.getNoEsquerda()));
    	return rotacao_Direita(no);
    }
    
    private No balancear(No raiz) {
    	int fb = No.fatorBalanceamento(raiz);
    	
    	if(fb<-1 && No.fatorBalanceamento(raiz.getNoDireita())<=0) {
    		return raiz = rotacao_Esquerda(raiz);
    	}else if(fb>1 && No.fatorBalanceamento(raiz.getNoEsquerda())>=0) {
    		return raiz = rotacao_Direita(raiz);
    	}else if(fb>1 && No.fatorBalanceamento(raiz.getNoEsquerda())<0) {
    		return raiz = rotacao_Esquerda_Direita(raiz);
    	}else if(fb<-1 && No.fatorBalanceamento(raiz.getNoDireita())>0) {
    		return raiz = rotacao_Direita_Esquerda(raiz);    		
    	}
    	
    	return raiz;
    }
}
