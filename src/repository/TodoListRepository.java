package repository;

import entity.Todolist;

public interface TodoListRepository {

    Todolist[] getAll();

    void add(Todolist todoList);

    boolean remove(Integer number);
}
