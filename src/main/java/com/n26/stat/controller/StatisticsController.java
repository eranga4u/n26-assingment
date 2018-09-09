package com.n26.stat.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n26.stat.dto.StatisticDTO;
import com.n26.stat.service.StatisticService;

/**
 * 
 * 
 * @author Eranga Kodikara
 *
 */

@RestController
@RequestMapping("/")
public class StatisticsController {

	@Autowired
	private StatisticService statisticService;

	@GetMapping(value = "statistics", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<StatisticDTO> getStatistics() {

		return Optional.ofNullable(statisticService.findStatistic(-60))
				.map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

}
