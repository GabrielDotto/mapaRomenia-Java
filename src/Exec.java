
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
        
        executa.percorreMapa("Oradea", "Eforie");
    	
    }
    
    
    private void imprimeRota(List<Cidade> cidades){
        	
        StringBuilder out = new StringBuilder();
        int custo = 0;
        for (Cidade cidade : cidades) {
            out.append(cidade.getNome());
            out.append(" - ");   
        }        
        System.out.println( out.toString());	
    }
    
    
    public void percorreMapa(String local, String destino) {
    	
    	Mapa mapa = new Mapa();
        mapa.carregarMapa();
        
    	int custo = 0;
    	Cidade localPartida  = mapa.cidadePorNome(local);
    	Cidade localDestino = mapa.cidadePorNome(destino);
    	Cidade posicaoAtual = null;
    	
    	HashSet<Cidade> visitados = new HashSet<>();
    	Stack<Cidade> caminho = new Stack<>();
     	
    	
        
        
        
        
    	posicaoAtual = localPartida;
    	caminho.add(posicaoAtual);
    	
		while( ! posicaoAtual.equals(localDestino) ){
			
			System.out.print(posicaoAtual.getNome() + " ");	
		    
		    visitados.add(posicaoAtual);   
		    
			for(Vizinho vizinho: posicaoAtual.getVizinhos())
			{
    			if( ! vizinho.getCidade().equals(localDestino)){
        				
    				if( ! visitados.contains(vizinho.getCidade())){
    					caminho.add(vizinho.getCidade());   		
    				}
        		}
    			else{
    				posicaoAtual = vizinho.getCidade();
    				break;
    			}
    		} 
			
			if(posicaoAtual != localDestino){
				posicaoAtual = caminho.pop();
				if( ! visitados.contains(posicaoAtual)){
					caminho.add(posicaoAtual);
				}
			}
		}
  	}
  
}
