package es.sinjava.gatherer.services;

import java.util.Optional;

public interface BaseService<T, ID> {

	T save(T t);

	Optional<T> findById(ID id);

	Iterable<T> findAll();

	T edit(T t);

	void delete(T t);

	void deleteById(ID id);

}