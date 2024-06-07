package com.example.springboot3todoapplication.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import com.example.springboot3todoapplication.services.TodoItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.example.springboot3todoapplication.models.TodoItem;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class TodoFormController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "new-todo-item";
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {

        TodoItem item = new TodoItem();
        item.setCreatedAt(todoItem.getDescription());
        item.setIsComplete(todoItem.getIsComplete());

        todoItemService.save(todoItem);
        return "redirect:/";
    }
}
