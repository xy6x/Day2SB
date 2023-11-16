package com.example.trachker.Task;

import com.example.trachker.ApiRes.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {
    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTasks() {

        return tasks;
    }

    @PostMapping("/add")
    public ArrayList<Task> addTask(@RequestBody Task task) {
        tasks.add(task);
        return tasks;
    }

    @PutMapping("/update/{index}")
    public ArrayList<Task> updateTask(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index,task);
        return tasks;
    }
    @DeleteMapping("/delete/{index}")
    public ArrayList<Task> deleteTask(@PathVariable int index){
        tasks.remove(index);
        return tasks;
    }
    @PutMapping("change/{index}")
    public Api Change(@PathVariable int index) {
        Task task = tasks.get(index);
        if (task.getStatus().equalsIgnoreCase("done")) {
            task.setStatus("not done");
            tasks.set(index, task);
        } else {task.setStatus("done");
        tasks.set(index, task);
    }
        return new  Api("200");
    }
    @GetMapping("/search/{title}")
    public Api search(@PathVariable String title ) {
        for (Task t : tasks
        ) {
            if (t.getTitle().equals(title)) {
                return new Api("200" + t);

            }
        }
return  new Api("404");
    }

}

