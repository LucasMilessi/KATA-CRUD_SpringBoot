package co.com.softka.springBoot.controller;

import co.com.softka.springBoot.models.Todo;
import co.com.softka.springBoot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todo")
    public Iterable<Todo> listTodo(){
        return todoService.listTodo();
    }

    @PostMapping("/saveTodo")
    public Todo saveTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }

    @DeleteMapping(path = "/deleteTodo/{id}")
    public void deleteTodo(@PathVariable("id") Long id){
        todoService.deleteTodo(id);
    }

    @GetMapping(path = "/getTodo/{id}")
    public Todo getTodo(@PathVariable("id") Long id){
        return todoService.getTodo(id);
    }

    @PutMapping("/updateTodo")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }
}
