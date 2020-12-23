package intromethods;

import java.util.Arrays;
import java.util.List;

public class TodoListMain {

    public static void main(String[] args) {

        TodoList myTodoList = new TodoList();

        myTodoList.addTodo("Get up!");
        myTodoList.addTodo("Brush your teeth");
        myTodoList.addTodo("Eat up your breakfast");
        System.out.println("List of my todos to finish: " + myTodoList.todosToFinish());

        List<String> morningCustoms = Arrays.asList("Get up!", "Brush your teeth", "Eat up your breakfast");
        myTodoList.finishAllTodos(morningCustoms);
        System.out.println("List of my todos to finish after running finnishAllTodos method with morning  customs list as parameter: " + myTodoList.todosToFinish());
        System.out.println("List of my todos to finish: " + myTodoList.todosToFinish());
        System.out.println("The number of task has benn finished today: " + myTodoList.numberOfFinishedTodos());

        myTodoList.addTodo("Go to work");
        myTodoList.addTodo("Finish my daily task");
        System.out.println("Here is my the list of my unfinished daily task list: " + myTodoList.todosToFinish());
        //Finished my daily work at my workplace
        myTodoList.finishTodos("Finish my daily task");
        System.out.println("After I finished my daily task the following task remained unfinished: " + myTodoList.todosToFinish());

        myTodoList.addTodo("Do the shopping");
        myTodoList.addTodo("Try arrive home in safe and sound! :-)");

        System.out.println("List of the finished tasks: " + myTodoList.todosToFinish());

        System.out.println("Number of tasks which has finished till now: " + myTodoList.numberOfFinishedTodos());

        //ArrayList toString()
        System.out.println("ArrazList toString method: ");
        System.out.println(myTodoList);
    }
}
