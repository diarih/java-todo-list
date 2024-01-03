package test.service;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
        testRemoveTodoList();
    }

    public static void testShowTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }

    public static void testAddTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Bermain Bola");
        todoListService.addTodoList("Ngoding PHP ASIK");
        todoListService.addTodoList("Ngoding GOLANG");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList() {
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Bermain Bola");
        todoListService.addTodoList("Ngoding PHP ASIK");
        todoListService.addTodoList("Ngoding GOLANG");

        todoListService.showTodoList();

        todoListService.removeTodoList(2);
        todoListService.removeTodoList(5);

        todoListService.showTodoList();
    }
}
