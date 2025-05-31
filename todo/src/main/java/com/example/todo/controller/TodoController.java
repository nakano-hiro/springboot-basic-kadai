package com.example.todo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entity.Task;

@RestController
@RequestMapping("/tasks")
public class TodoController {
	
	@GetMapping("/allTask")
	public List<Task> allTask(){
		return new ArrayList<>();
	}

}
