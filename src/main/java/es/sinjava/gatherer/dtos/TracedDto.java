package es.sinjava.gatherer.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TracedDto {

	private Long id;

	private String host;

	private String clsName;

	private String methodName;

	private Long lap;

	private LocalDateTime created;

}
