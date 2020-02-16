package com.socgen.interview.chamber.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.interview.chamber.dto.AnimationRequest;
import com.socgen.interview.chamber.service.ChamberService;

@RestController
@RequestMapping("/animate")
public class ChamberController {

	@Autowired
	private ChamberService chamberService;

	@PostMapping
	public ResponseEntity<String> create(@RequestBody AnimationRequest request) {
		List<String> list = chamberService.animate(request.getSpeed(), request.getInit());
		String ret = list.stream().map(e -> "\"" + e + "\"").collect(Collectors.joining(",\n", "{", "}"));
		return ResponseEntity.ok(ret);
	}
}
