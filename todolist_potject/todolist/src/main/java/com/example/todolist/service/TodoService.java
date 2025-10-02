package com.example.todolist.service;

import com.example.todolist.domain.Todo;
import com.example.todolist.domain.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    boolean isCompleted = true;

    public final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public boolean updateTodoStatus(Long id) {
        boolean CompletedTodo = todoRepository.findById(id).isPresent();
        if (!CompletedTodo){
            return isCompleted;
        }
        return false;
    }

    public boolean clearCompletedTodos(Long id) {
        if(todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
