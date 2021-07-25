package es.sinjava.gatherer.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import es.sinjava.gatherer.services.BaseService;
import lombok.extern.log4j.Log4j2;

// Clase que elimina código repetivo en los servicios
@Log4j2
public abstract class BaseServiceImpl<T, ID, R extends CrudRepository<T, ID>> implements BaseService<T, ID> {

	@Autowired
	protected R repositorio;

	@Override
	public T save(T t) {
		log.trace("Save entity  {} ", t.getClass());
		return repositorio.save(t);
	}

	@Override
	public Optional<T> findById(ID id) {
		log.trace("Find entity  {} ", id);
		return repositorio.findById(id);
	}

	@Override
	public Iterable<T> findAll() {
		log.trace("Find All ");
		return repositorio.findAll();
	}

	@Override
	public T edit(T t) {
		log.trace("Update entity  {}", t.getClass());
		return repositorio.save(t);
	}

	@Override
	public void delete(T t) {
		log.trace("Delete entity  {}", t.getClass());
		repositorio.delete(t);
	}

	@Override
	public void deleteById(ID id) {
		log.trace("Delete entity by Id  {}", id);
		repositorio.deleteById(id);
	}

}
