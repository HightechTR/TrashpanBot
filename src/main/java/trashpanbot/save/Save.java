package trashpanbot.save;

import trashpanbot.*;
import trashpanbot.task.*;
import trashpanbot.exception.InvalidSaveFormatException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Save {

    public static void readFile(String filePath) throws IOException, ArrayIndexOutOfBoundsException {
        File saveFile = new File(filePath);

        // create a new save file if it doesn't exist
        if (saveFile.createNewFile()) {
            System.out.println(Text.FILE_CREATE);
            return;
        }

        Scanner s = new Scanner(saveFile);

        while (s.hasNextLine()) {
            String[] inputParts = s.nextLine().split(" \\| ", 2);
            String[] parameter = inputParts[1].split(" \\| ", 2);

            // check if parameters in save file are valid
            if (parameter[0].isEmpty()  || parameter[1].isEmpty()) {
                throw new InvalidSaveFormatException();
            }

            // add task based on task icon
            switch (inputParts[0]) {
            case "T" -> Todo.addTodo(parameter, false);
            case "D" -> Deadline.addDeadline(parameter, false);
            case "E" -> Event.addEvent(parameter, false);
            default -> throw new InvalidSaveFormatException();
            }

            // mark task done if status icon is X
            String[] mark = {"mark", Integer.toString(TrashpanMain.listCounter)};
            if (parameter[0].equals("X")) {
                Task.markTask(mark, true, false);
            }
        }
    }

    public static void writeToFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);

        for (int i = 0; i < TrashpanMain.listCounter; i++) {
            fw.write(TrashpanMain.tasks[i].getTypeIcon() + " | ");
            fw.write(TrashpanMain.tasks[i].getStatusIcon() + " | ");
            fw.write(TrashpanMain.tasks[i].getDescription());

            // save deadline for deadline class
            fw.write(TrashpanMain.tasks[i].getClass() == Deadline.class
                    ? " /by " + TrashpanMain.tasks[i].getDeadline()
                    : "");

            // save dates for event class
            fw.write(TrashpanMain.tasks[i].getClass() == Event.class
                    ? " /from " + TrashpanMain.tasks[i].getFrom() + " /to " + TrashpanMain.tasks[i].getTo()
                    : "");

            fw.write(System.lineSeparator());
        }

        fw.close();
    }

    public static void updateFile(String filePath) {
        try {
            writeToFile(filePath);
        } catch (IOException e) {
            System.out.println(Text.FILE_WRITE_ERROR);
        }
    }
}
