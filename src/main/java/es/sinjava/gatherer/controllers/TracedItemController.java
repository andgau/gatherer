package es.sinjava.gatherer.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

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

	@GetMapping("/home/{name}")
	public ResponseEntity<?> home(@PathVariable String name) {
		log.debug("TracedItemController {} home", name);
		return ResponseEntity.ok(name);
	}

	@GetMapping("/trace/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id) {
		log.debug("TracedItemController {} byId", id);
		Optional<TracedItem> item = tracedItemService.findById(id);
//		return ResponseEntity.ok(item);
		return ResponseEntity.of(item);
	}

	@PostMapping("/trace")
	public ResponseEntity<?> create(@RequestBody TracedDto trace) {
		log.debug("TracedItemController {} create", trace.getHost());
		TracedItem ti = new TracedItem();

		// TODO meter un mapper
		ti.setHost(trace.getHost());
		ti.setClsName(trace.getClsName());
		ti.setMethodName(trace.getMethodName());
		ti.setCreated(LocalDateTime.now());
		ti.setLap(trace.getLap());
		ti = tracedItemService.save(ti);
		return ResponseEntity.ok(ti);
	}

}
