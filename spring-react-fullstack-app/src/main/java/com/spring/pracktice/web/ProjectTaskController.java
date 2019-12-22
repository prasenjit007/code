package com.spring.pracktice.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pracktice.domain.ProjectTask;
import com.spring.pracktice.services.ProjectTaskService;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService projectTaskService;

	@GetMapping("/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<String>("Application Status : UP", HttpStatus.FOUND);
	}

	@PostMapping("")
	public ResponseEntity<?> addPTToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {

		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();

			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}

			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}

		ProjectTask task = projectTaskService.saveAndUpdatePT(projectTask);

		return new ResponseEntity<ProjectTask>(task, HttpStatus.CREATED);

	}

	@GetMapping("/all")
	public Iterable<ProjectTask> getAllPT() {
		return projectTaskService.findAll();
	}

	@GetMapping("/{pt_id}")
	public ResponseEntity<?> getPTById(@PathVariable Long pt_id) {
		ProjectTask pt = projectTaskService.getById(pt_id);
		if (pt != null)
			return new ResponseEntity<ProjectTask>(pt, HttpStatus.OK);
		else
			return new ResponseEntity<String>("Record Not Found With ID : " + pt_id, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{pt_id}")
	public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id) {
		projectTaskService.delete(pt_id);

		return new ResponseEntity<String>("Record Deleted Successfully With ID : " + pt_id, HttpStatus.OK);
	}
}
