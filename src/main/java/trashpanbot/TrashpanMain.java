package trashpanbot;

import java.io.IOException;
import java.util.Scanner;

import trashpanbot.task.*;
import trashpanbot.save.*;

import java.util.ArrayList;

public class TrashpanMain {
    static String userInput;
    static Scanner in = new Scanner(System.in);
    static boolean isRunning = true;

    public static ArrayList<Task> tasks = new ArrayList<>();
    public static final String filePath = "data/TaskList.txt";

    /**
     * Reads in an input and parses it into command and parameter.
     *
     * @return The string array containing the command and parameter
     */
    public static String[] readInput() {
        userInput = in.nextLine();
        return userInput.split(" ", 2);
    }

    /**
     * Exits the program.dd
     */
    public static void exitProgram() {
        System.out.println(Text.BYE);
        isRunning = false;
        System.exit(0);
    }

    /**
     * Calls methods for the task list application based on the command inputted.
     */
    public static void parseTaskListCommand() throws IOException {
        String[] inputParts;
        String command;

        while (isRunning) {
            System.out.println(Text.LINE);
            inputParts = readInput();
            command = inputParts[0];
            System.out.println(Text.LINE);

            switch (command) {
            case "todo" -> Todo.addTodo(inputParts);
            case "deadline" -> Deadline.addDeadline(inputParts);
            case "event" -> Event.addEvent(inputParts);
            case "remove" -> Task.removeTask(inputParts);
            case "todo" -> Todo.addTodo(inputParts, true);
            case "deadline" -> Deadline.addDeadline(inputParts, true);
            case "event" -> Event.addEvent(inputParts, true);
            case "list" -> Task.displayList();
            case "mark" -> Task.markTask(inputParts, true, true);
            case "unmark" -> Task.markTask(inputParts, false, true);
            case "help" -> System.out.println(Text.TASK_LIST_COMMANDS);
            case "bye" -> exitProgram();
            default -> System.out.println(Text.COMMAND_INVALID);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Text.INTRO);

        System.out.println(Text.TASK_LIST);

        try {
            Save.readFile(filePath);
            System.out.println(Text.FILE_READING);
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.out.println(Text.FILE_READ_ERROR);
            return;
        }

        System.out.println(Text.TASK_LIST_COMMANDS);

        try {
            parseTaskListCommand();
        } catch (IOException e) {
            System.out.println(Text.COMMAND_READ_ERROR);
        }
    }
}