package trashpanbot.data.save;

import trashpanbot.data.io.*;
import trashpanbot.data.task.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the save functions.
 * Contains methods to handle creation, loading and writing to the save file.
 */
public class Save {
    private Ui ui;
    private String filePath;
    private Parser parser;

    public static final DateTimeFormatter DATE_INPUT_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Save(String filePath, Parser parser, Ui ui) {
        this.filePath = filePath;
        this.parser = parser;
        this.ui = ui;
    }

    /**
     * Creates a new save file if one does not exist.
     */
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

    /**
     * Reads a save file and parses its data into the task list.
     *
     * @return An ArrayList of Task objects loaded from the save file.
     * @throws IOException If the save file format is invalid, i.e. the save file is corrupted.
     */
    public ArrayList<Task> readFile() throws IOException, DateTimeParseException {
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

    /**
     * Writes a single line to the save file corresponding to a single task.
     *
     * @param tasks ArrayList of Task objects to be saved.
     * @throws IOException If an unknown error occurs during save write.
     */
    private void writeToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath);

        for (Task task : tasks) {
            fw.write(task.getTypeIcon() + " | ");
            fw.write(task.getStatusIcon() + " | ");
            fw.write(task.getDescription());

            // save deadline for deadline class
            fw.write(task.getClass() == Deadline.class
                    ? " /by " + task.getDeadline().format(DATE_INPUT_FORMAT)
                    : "");

            // save dates for event class
            fw.write(task.getClass() == Event.class
                    ? " /from " + task.getFrom().format(DATE_INPUT_FORMAT) + " /to " + task.getTo().format(DATE_INPUT_FORMAT)
                    : "");

            fw.write(System.lineSeparator());
        }

        fw.close();
    }

    /**
     * Updates the save file every time the task list changes.
     *
     * @param tasks ArrayList of Task objects to be saved.
     */
    public void updateFile(ArrayList<Task> tasks) {
        try {
            writeToFile(tasks);
        } catch (IOException e) {
            ui.showFileWriteError();
        }
    }
}
