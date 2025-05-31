package com.example.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.entity.Task;
import com.example.task.repository.TaskRepository;

//サービス層でのたること
//実際の処理を作っておく(骨格）

@Service
public class TaskService {
	
	private final TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	//すべてのタスクを取得
	public List<Task> allTask(){
		return taskRepository.findAll();
//		return new AllayList<>();
	}
	
	//特定のタスクをIDを指定して取得
	public Optional<Task> findById(int id) {
		return taskRepository.findById(id);
	}
	
	//タスクの追加
	public Task createTask(Task task) {
		return taskRepository.save(task);
	}
	
	//タスクの更新
	public String updateTask(Task task) {
		//idから既存のタスクを探す
		Optional<Task> targetTask = taskRepository.findById(task.getId());
		
		//タスクが無い場合、nullを返す
		if(targetTask.isEmpty()) {
			return "タスクがありません";
			
		}else {
			 // タスクがある場合、更新予定のタスクを取得
			Task updateTask = targetTask.get();
			
			// task から新しい値を取得し、updateTask に反映
			updateTask.setTitle(task.getTitle());
			updateTask.setDone(task.isDone());
			
			// 更新されたタスクを保存
			taskRepository.save(updateTask);
			
			return "タスクの更新が完了しました";
		}
	}

}
