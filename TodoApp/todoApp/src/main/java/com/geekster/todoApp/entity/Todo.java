package com.geekster.todoApp.entity;

public class Todo {
    private Integer todoId;
    private String todoName;
    private boolean isTodoStatus;

    public boolean isTodoStatus() {
        return isTodoStatus;
    }

    public void setTodoStatus(boolean todoStatus) {
        isTodoStatus = todoStatus;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public Integer getTodoId() {
        return todoId;
    }

    public void setTodoId(Integer todoId) {
        this.todoId = todoId;
    }


}
