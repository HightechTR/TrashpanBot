package trashpanbot.data.save;

import trashpanbot.data.io.*;
import trashpanbot.data.task.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Save {
    private Ui ui;
    private String filePath;
    private Parser parser;

    public Save(String filePath, Parser parser, Ui ui) {
        this.filePath = filePath;
        this.parser = parser;
        this.ui = ui;
    }

    public void createFile() {
        File saveFile = new File(filePath);
        File directory = saveFile.getParentFile();

        try {
            directory.mkdir();
            if (saveFile.createNewFile()){
                ui.showFileCreation();
            } else {
                ui.showFileCorrupted();
            }

        } catch (IOException e) {
            ui.showFileUnknownError();
            System.exit(1);
        }
    }

    public ArrayList<Task> readFile() throws IOException {
        File saveFile = new File(filePath);
        ArrayList<Task> output = new ArrayList<>();

        if (!saveFile.exists()) {
            createFile();
            return output;
        }

        ui.showFileReading();
        Scanner s = new Scanner(saveFile);

        while (s.hasNextLine()) {
            output.add(parser.parseFile(s.nextLine().split(" \\| ", 2)));
        }

        return output;
    }

    private void writeToFile(ArrayList<Task> tasks) throws IOException {
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

    public void updateFile(ArrayList<Task> tasks) {
        try {
            writeToFile(tasks);
        } catch (IOException e) {
            ui.showFileWriteError();
        }
    }
}
