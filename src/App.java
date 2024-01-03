import java.util.Scanner;

public class App {

    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        viewTodos();
    }

    /**
     * Show todos
     */
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Makan";
        showTodoList();
    }

    /**
     * Add Todo
     */
    public static void addTodo(String todo) {

        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            var tempModel = model;
            model = new String[model.length * 2];

            for (int i = 0; i < tempModel.length; i++) {
                model[i] = tempModel[i];
            }
        }

        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodo() {
        for (int i = 1; i <= 10; i++) {
            addTodo("Todo List #" + i);
        }

        showTodoList();
    }

    /**
     * Remove Todo
     */
    public static boolean removeTodo(Integer numberTodo) {
        if ((numberTodo - 1) >= model.length) {
            return false;
        } else if (model[numberTodo - 1] == null) {
            return false;
        } else {
            for (int i = (numberTodo - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }

            }
            return true;
        }
    }

    public static void testRemoveTodo() {
        addTodo("Memasak");
        addTodo("Menyuci");
        addTodo("Mandi");

        showTodoList();

        removeTodo(2);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        input("Input nama anda");
        input("input adw");
    }

    // VIEWS TODOSAPP
    public static void viewTodos() {
        while (true) {
            showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodo();
            } else if (input.equals("2")) {
                viewRemoveTodo();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Pilihan salah");
            }
        }
    }

    public static void testViewTodo() {
        addTodo("Makan");
        addTodo("Minum");
        addTodo("Menyanyi");

        viewTodos();

    }

    public static void viewAddTodo() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x jika batal)");

        if (todo.equals("x")) {
            // batal
        } else {
            addTodo(todo);
        }
    }

    public static void testViewAddTodo() {
        addTodo("Makan");
        addTodo("Minum");
        addTodo("Menyanyi");

        viewTodos();

    }

    public static void viewRemoveTodo() {
        System.out.println("MENGAHPUS TODOLIST");

        var number = input("Nomor yang dihapus (x jika batal)");

        if (number.equals("x")) {
            // batal
        } else {
            boolean success = removeTodo(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal Menghapus Todo : " + number);
            }
        }
    }

    public static void testViewRemoveTodo() {
        addTodo("Makan");
        addTodo("Minum");
        addTodo("Menyanyi");

        showTodoList();

        viewRemoveTodo();

        showTodoList();
    }
}
