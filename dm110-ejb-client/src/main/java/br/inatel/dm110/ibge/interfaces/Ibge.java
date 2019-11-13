package br.inatel.dm110.ibge.interfaces;

import java.util.List;

import br.inatel.dm110.api.StateTO;

public interface Ibge {
	void saveState(StateTO stateTO);
	List<StateTO> listAll();
}
