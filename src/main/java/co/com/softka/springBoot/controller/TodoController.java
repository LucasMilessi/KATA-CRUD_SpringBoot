package co.com.softka.springBoot.controller;

import co.com.softka.springBoot.models.Todo;
import co.com.softka.springBoot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping(value = "api/todo")
    public Iterable<Todo> listTodo(){
        return todoService.listTodo();
    }

    @PostMapping(value = "api/todo")
    public Todo saveTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }

    @DeleteMapping(value = "api/{id}/todo")
    public void deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTodo(id);
    }

    @GetMapping(value = "/api/{id}/todo")
    public Todo getTodo(@PathVariable("id") Long id){
        return todoService.getTodo(id);
    }

    @PutMapping("api/todo")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }
}
