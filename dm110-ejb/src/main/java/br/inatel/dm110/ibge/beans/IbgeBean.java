package br.inatel.dm110.ibge.beans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.api.StateTO;
import br.inatel.dm110.hello.entities.State;
import br.inatel.dm110.ibge.dao.IbgeDao;
import br.inatel.dm110.ibge.interfaces.IbgeLocal;
import br.inatel.dm110.ibge.interfaces.IbgeRemote;

@Stateless
@Local(IbgeLocal.class)
@Remote(IbgeRemote.class)
public class IbgeBean implements IbgeLocal, IbgeRemote {

	@EJB()
	private IbgeDao ibgeDao;
	
	@Override
	public void saveState(StateTO stateTO) {
		
		State state = new State(stateTO.getIbge(), stateTO.getSigla(), stateTO.getNome(), stateTO.getArea());
		ibgeDao.insert(state);
	}

	@Override
	public List<StateTO> listAll() {
		List<State> states = ibgeDao.listAll();
		List<StateTO> statesTO = new ArrayList<>();
		
		states.forEach((state) -> {
			StateTO stateTO = new StateTO(state.getIbge(), state.getArea(), state.getNome(), state.getSigla());
			statesTO.add(stateTO);
		});
		return statesTO;
	}

}
