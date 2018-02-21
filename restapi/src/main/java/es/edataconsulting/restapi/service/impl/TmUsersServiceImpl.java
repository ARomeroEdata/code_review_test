package es.edataconsulting.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.edataconsulting.restapi.entity.TmUsers;
import es.edataconsulting.restapi.repository.TmUsersRepository;
import es.edataconsulting.restapi.service.TmUsersService;

@Service("tmUsersServiceImpl")
public class TmUsersServiceImpl implements TmUsersService{
	@Autowired
	@Qualifier("tmUsersRepository")
	private TmUsersRepository tmUsersRepository;
	@Override
	public List<TmUsers> findAll() {
		return tmUsersRepository.findAll();
	}

	@Override
	public TmUsers findById(int id) {
		return tmUsersRepository.findById(id);
	}

	@Override
	public TmUsers save(TmUsers tmUsers) {
		return tmUsersRepository.save(tmUsers);
	}

}
