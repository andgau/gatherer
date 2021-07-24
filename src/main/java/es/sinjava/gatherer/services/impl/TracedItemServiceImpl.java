package es.sinjava.gatherer.services.impl;

import org.springframework.stereotype.Service;

import es.sinjava.gatherer.beans.TracedItem;
import es.sinjava.gatherer.repositories.TracedItemRepository;
import es.sinjava.gatherer.services.TracedItemService;

@Service
public class TracedItemServiceImpl extends BaseServiceImpl<TracedItem, Long, TracedItemRepository>
		implements TracedItemService {

}
