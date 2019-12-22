package com.spring.pracktice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pracktice.domain.ProjectTask;
import com.spring.pracktice.repoaitory.ProjectTaskRepository;

@Service
public class ProjectTaskService {

	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	public ProjectTask saveAndUpdatePT(ProjectTask pt) {
		
		if(pt.getStatus()==null || pt.getStatus().trim().equals("")) {
			pt.setStatus("TO_DO");
		}
		return projectTaskRepository.save(pt);
	}
	
	public Iterable<ProjectTask> findAll() {
		return projectTaskRepository.findAll();
	}
	
	public ProjectTask getById(Long id) {
		return projectTaskRepository.getById(id);
	}
	
	public void delete(Long id) {
		ProjectTask pt = getById(id);
		if(pt!=null)
			projectTaskRepository.delete(pt);
	}
}
