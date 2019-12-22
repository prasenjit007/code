package com.spring.pracktice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class ProjectTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String acceptanceCriteria;
	
	@NotBlank(message = "Summary can't be blank.")
	private String summary;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public ProjectTask() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProjectTask [id=" + id + ", acceptanceCriteria=" + acceptanceCriteria + ", summary=" + summary
				+ ", status=" + status + "]";
	}
	
	
}
