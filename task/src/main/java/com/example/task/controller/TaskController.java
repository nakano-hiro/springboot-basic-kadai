package com.example.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.entity.Task;
import com.example.task.service.TaskService;

import jakarta.validation.Valid;

//コントローラー層でやること
//バリデーション、権限チェック（肉付け）
//コントローラー層でバリデーションを行わないとエラー内容がつかみづらい

//API = 異なるアプリをつなげる仕組み（インターフェイス）

@RestController
public class TaskController {

	private final TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}

	//すべてのタスクを取得
	@GetMapping("/allTask")
	public List<Task> getAllTask() {

		String admin = new BCryptPasswordEncoder().encode("admin123");
		String user = new BCryptPasswordEncoder().encode("user123");

		return taskService.allTask();
		//		return new AllayList<>();
	}

	//特定のタスクをIDを指定して取得
	@GetMapping("/{id}")
	public Task getFindById(@PathVariable int id) {
		//taskという名の変数に、idに該当するTaskを代入
		Optional<Task> task = taskService.findById(id);

		//Optionalでラップされた中身が存在しないものだったらnull返す
		if (task.isEmpty()) {
			//	    	return null;
			return new Task();
		} else {
			//Optionalでラップされた中身の値を取得して返す
			return task.get();
		}
	}

	//タスクの追加
	@PostMapping("/createTask")
	public Task createTask(@RequestBody Task task) {
		return taskService.createTask(task);
		//		return "タスクの追加が完了しました";
	}

	//タスクの更新
	//	@PostMapping("/{id}")⇒URLに指定するのはナンセンス
	@PostMapping("/update")
	@PreAuthorize("hasRole('ADMIN')") // ← 管理者のみ許可
	public String updateTask(@RequestBody @Valid Task task) {
		String result = taskService.updateTask(task);

		return result;
	}

}
