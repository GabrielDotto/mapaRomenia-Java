
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Exec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   		
        
        Exec executa = new Exec();
        
        executa.percorreMapa("Sibiu", "Neamt");
    	
    }
    
    
    private void imprimeRota(List<String> percurso){
    	
    	Cidade cidade = null;
    	Cidade cidadeAnterior = null;
    	int custo = 0;
    	
    	Mapa mapa = new Mapa();
    	mapa.carregarMapa();
    	
    	for (String p : percurso){
    		
    		cidade = mapa.cidadePorNome(p);
    		
    		for(Vizinho vizinho : cidade.getVizinhos()){
    			if(vizinho.getCidade() == cidadeAnterior){
    				custo += vizinho.getDistancia();
    			}
    		}
    		cidadeAnterior = cidade;
    		System.out.println(p);   	
    	}  	
    	System.out.println(custo);
    }
    
    
    public void percorreMapa(String local, String destino) {
    	
    	Mapa mapa = new Mapa();
        mapa.carregarMapa();
        
    	
    	Cidade localPartida  = mapa.cidadePorNome(local);
    	Cidade localDestino = mapa.cidadePorNome(destino);
    	Cidade posicaoAtual = null;
    	
    	HashSet<Cidade> visitados = new HashSet<>();
    	Stack<Cidade> caminho = new Stack<>();	
    	Stack<String> percurso = new Stack<>();

     	

    	posicaoAtual = localPartida;
    	caminho.add(posicaoAtual);
    	percurso.add(posicaoAtual.getNome());
		
    	
		while( ! posicaoAtual.equals(localDestino) ){
			    
			visitados.add(posicaoAtual);
		    System.out.println(percurso);
//		    System.out.println("caminho - " + caminho);
			for(Vizinho vizinho: posicaoAtual.getVizinhos())
			{
    			if( ! vizinho.getCidade().equals(localDestino)){
        				
    				if( ! visitados.contains(vizinho.getCidade())){
    					caminho.add(vizinho.getCidade());   		
    				}
        		}
    			else{
    				posicaoAtual = vizinho.getCidade();
    				percurso.add(posicaoAtual.getNome());
    				imprimeRota(percurso);
    				break;
    			}
    		} 
			
			if(posicaoAtual != localDestino){
				
				if(visitados.contains(caminho.lastElement())){
					
					caminho.pop();
					posicaoAtual = caminho.pop();
					percurso.pop();
				}else{
					posicaoAtual = caminho.pop();					
				}
				if( ! visitados.contains(posicaoAtual)){
					caminho.add(posicaoAtual);
					percurso.add(posicaoAtual.getNome());
				}
			}
		}
  	}
  
}
