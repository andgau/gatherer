package es.sinjava.gatherer.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.sinjava.gatherer.beans.TracedItem;
import es.sinjava.gatherer.dtos.TracedDto;
import es.sinjava.gatherer.services.TracedItemService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@AllArgsConstructor
@Log4j2
public class TracedItemController {

	private TracedItemService tracedItemService;

	private static final ModelMapper modelMapper = new ModelMapper();

	@GetMapping("/home/{name}")
	public ResponseEntity<?> home(@PathVariable String name) {
		log.debug("TracedItemController {} home", name);
		return ResponseEntity.ok(name);
	}

	@GetMapping("/trace/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id) {
		log.debug("TracedItemController {} byId", id);
		Optional<TracedItem> item = tracedItemService.findById(id);
		return ResponseEntity.of(item);
	}

	@GetMapping("/trace")
	public ResponseEntity<?> all() {
		log.debug("TracedItemController {} byId");
		Iterable<TracedItem> item = tracedItemService.findAll();
		return ResponseEntity.ok(item);
	}

	@PostMapping("/trace")
	public ResponseEntity<?> create(@RequestBody TracedDto trace) {
		log.debug("TracedItemController {} create", trace.getHost());
		TracedItem ti = modelMapper.map(trace, TracedItem.class);
		ti.setCreated(LocalDateTime.now());
		ti = tracedItemService.save(ti);
		return ResponseEntity.ok(ti);
	}

}
