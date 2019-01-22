package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "spring_demo_table")
@EntityListeners(AuditingEntityListener.class)

public class Data {
    @Id
    private int id;

    @NotBlank
    private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", content=" + content + "]";
	}

	
}