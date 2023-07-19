package com.geekster.todoApp.controller;

import com.geekster.todoApp.entity.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private List<Todo> myTodo;
    public TodoController(){
        myTodo = new ArrayList<>();
    }

    @GetMapping("getAllTodo")
    public List<Todo> getAllTodos(){
        return myTodo;
    }

    @GetMapping("donoTodo")
    public List<Todo> getDoneTodos(){
        List<Todo> doneTodo = new ArrayList<>();
         for(Todo todo : myTodo){
             if(todo.isTodoStatus()){
                 doneTodo.add(todo);
             }
         }
         return doneTodo;
    }

    @GetMapping ("nonDoneTodo")
    public List<Todo> getNonDoneTodos(){
        List<Todo> unDoneTodo = new ArrayList<>();
        for(Todo todo : myTodo){
            if(!todo.isTodoStatus()){
                unDoneTodo.add(todo);
            }
        }
        return unDoneTodo;
    }

    @PostMapping("todo")
    public String addTodo(@RequestBody Todo todo){
        myTodo.add(todo);
        return "Todo Added";
    }

    @PutMapping("updateStatus/{todoId}/{status}")
    public String updateTodo(@PathVariable Integer todoId ,@PathVariable boolean todoStatus){
        for(Todo todo : myTodo){
            if(todo.getTodoId().equals(todoId)){
                todo.setTodoStatus(todoStatus);
                return " Todo updated for todo ID: "+ todoId;
            }
            return " Todo not found for todo ID: " + todoId;
        }
        return todoId + " not found ";
    }

    @DeleteMapping("deleteTodo")
    public String deleteTodo(@RequestBody Integer todoId){
        for(Todo todo : myTodo){
            if(todo.getTodoId().equals(todoId)){
                myTodo.remove(todo);
                return " Todo deleted "+todoId;
            }
            return todoId + " not found ";
        }
        return todoId + " not found ";
    }
}
