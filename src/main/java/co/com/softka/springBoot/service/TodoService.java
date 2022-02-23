package co.com.softka.springBoot.service;

import co.com.softka.springBoot.models.Todo;
import co.com.softka.springBoot.repository.TodoRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    public Iterable<Todo> listTodo(){
        return todoRepository.findAll();
    }

    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id){
        todoRepository.delete(getTodo(id));
    }

    public Todo getTodo(Long id){
        return todoRepository.findById(id).orElseThrow();
    }

    public Todo updateTodo(@NotNull Todo todo){
        Optional<Todo> todoUpdate = todoRepository.findById(todo.getId());

        if (todoUpdate.isPresent()){
            Todo todoSave = todoUpdate.get();
            todoSave.setName(todo.getName());
            todoSave.setCompleted(todo.isCompleted());
            return todoRepository.save(todoSave);
        }
        throw new RuntimeException("No existe el todo con esta id"+todo.getId());
    }
}
