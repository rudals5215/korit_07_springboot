package com.example.todolist.web;

import com.example.todolist.domain.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PatchMapping("/todos/{id}")
    public ResponseEntity<Void> updateTodoStatus(@PathVariable Long id) {
        todoService.updateTodoStatus(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/todos/completed")
    public ResponseEntity<Void> clearCompletedTodos() {
        todoService.clearCompletedTodos();
        return ResponseEntity.noContent().build();
    }
}
