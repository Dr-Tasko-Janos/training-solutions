package intromethods;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    List<Todo> todos = new ArrayList<>();

    public void addTodo(String caption) {
        todos.add(new Todo(caption));
    }

    public void finishTodos(String caption) {
        for (Todo item : todos) {
            if (item.getCaption().equals(caption)) {
                item.finish();
            }
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {
        for (String itemToFinish : todosToFinish) {
            for (Todo item : todos) {
                if (item.getCaption().equals(itemToFinish.toString())) {
                    item.finish();
                }
            }
        }
    }

    public List<String> todosToFinish() {
        List<String> listTodosToFinish = new ArrayList<>();

        for (Todo item : todos) {
            if (!item.isFinished()) {
                listTodosToFinish.add(item.getCaption());
            }
        }
        return listTodosToFinish;
    }

    public int numberOfFinishedTodos() {
        int counter = 0;

        for (Todo item : todos) {
            if (item.isFinished()) {
                counter++;
            }
        }
        return counter;
    }
}

