package br.unincor.controle;

import java.util.ArrayList;
import java.util.List;
import br.unincor.exception.EvolucaoException;
import br.unincor.model.Pokemon;
import br.unincor.view.Usuario;

public class Main {

	public static void main(String[] args) {
		Usuario u = new Usuario();
		Operacoes o = new Operacoes();
		List<Pokemon> listaPokemons = new ArrayList<Pokemon>();
		
		Long quantPokemon = u.recebeLong("Entre com a qtd de  pokemons: ");
		
		for(int i = 0; i < quantPokemon; i++){
			Pokemon p = new Pokemon(
				u.recebeTexto("Insira o nome do Pokemon: "),
				u.recebeTexto("Insira o tipo do Pokemon: "),
				u.recebeDouble("Insira o peso do Pokemon: "),
				u.recebeDouble("Insira a altura do Pokemon: ")
			);
			
			listaPokemons.add(p);
		}
		
		for(int i = 0; i < listaPokemons.size(); i++){
			try{
				o.evoluir(listaPokemons.get(i));
			}catch(EvolucaoException ee){
				u.exibeMsgErro(ee.getMessage());
			}
		}
		
		u.exibeMsg("Maior CP: \n\n" + o.maiorCp(listaPokemons).verDados());
		u.exibeMsg("Menor CP: \n\n" + o.menorCp(listaPokemons).verDados());
	}

}
