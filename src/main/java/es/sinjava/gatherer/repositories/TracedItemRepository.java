package es.sinjava.gatherer.repositories;

import org.springframework.data.repository.CrudRepository;

import es.sinjava.gatherer.beans.TracedItem;

public interface TracedItemRepository extends CrudRepository<TracedItem, Long> {

}
