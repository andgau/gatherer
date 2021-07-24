package es.sinjava.gatherer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.sinjava.gatherer.dtos.TracedDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2

public class TracedItemController {

	@GetMapping("/home/{name}")
	public ResponseEntity<?> home(@PathVariable String name) {
		log.debug("TracedItemController {} home", name);
		return ResponseEntity.ok(name);
	}
	
	@GetMapping("/trace/{id}")
	public ResponseEntity<?> byId(@PathVariable Long id) {
		log.debug("TracedItemController {} byId", id);
		return ResponseEntity.ok(id);
	}
	
	@PostMapping("/trace}")
	public ResponseEntity<?> create(@RequestBody TracedDto trace) {
		log.debug("TracedItemController {} create", trace.getHost());
		return ResponseEntity.ok(trace);
	}
	

}
