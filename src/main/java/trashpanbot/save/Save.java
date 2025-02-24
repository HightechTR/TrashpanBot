package trashpanbot.save;

import trashpanbot.io.*;
import trashpanbot.task.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Save {
    private final Ui ui = new Ui();

    public void createFile(String filePath) {
        File saveFile = new File(filePath);

        try {
            if (saveFile.createNewFile()){
                ui.showFileCreation();
            } else {
                ui.showFileCorrupted();
            }

        } catch (IOException e) {
            ui.showFileDirectoryError();
            System.exit(1);
        }
    }

    public ArrayList<Task> readFile(String filePath) throws IOException {
        File saveFile = new File(filePath);
        ArrayList<Task> output = new ArrayList<>();

        if (!saveFile.exists()) {
            createFile(filePath);
            return output;
        }

        ui.showFileReading();
        Scanner s = new Scanner(saveFile);

        while (s.hasNextLine()) {
            output.add(Parser.parseFile(s.nextLine().split(" \\| ", 2)));
        }

        return output;
    }

    public void writeToFile(ArrayList<Task> tasks, String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);

        for (Task task : tasks) {
            fw.write(task.getTypeIcon() + " | ");
            fw.write(task.getStatusIcon() + " | ");
            fw.write(task.getDescription());

            // save deadline for deadline class
            fw.write(task.getClass() == Deadline.class
                    ? " /by " + task.getDeadline()
                    : "");

            // save dates for event class
            fw.write(task.getClass() == Event.class
                    ? " /from " + task.getFrom() + " /to " + task.getTo()
                    : "");

            fw.write(System.lineSeparator());
        }

        fw.close();
    }

    public void updateFile(ArrayList<Task> tasks, String filePath) {
        try {
            writeToFile(tasks, filePath);
        } catch (IOException e) {
            ui.showFileWriteError();
        }
    }
}
