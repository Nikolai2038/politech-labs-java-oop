package coursework;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainWindowController {
    @FXML
    private TextArea lab1Info, lab2Info, lab3Info, lab4Info, lab1Output, lab2Output, lab3Output, lab4Output, lab3Input, lab3DictionariesList;
    @FXML
    private TextField lab1Input, lab4InputAverageOfList, lab4InputTransformedStrings, lab4InputUniqueSquares, lab4InputLastElement, lab4InputSumOfEvenNumbers, lab4InputConvertedMap;

    @FXML
    public void initialize() {
        // Set lab information by calling it with "--info" argument
        runLab("lab_1.Main", new String[]{"--info"}, lab1Info);
        runLab("lab_2.Main", new String[]{"--info"}, lab2Info);
        runLab("lab_3.Main", new String[]{"--info"}, lab3Info);
        runLab("lab_4.Main", new String[]{"--info"}, lab4Info);
    }

    public void startLab1() {
        runLab("lab_1.Main", new String[]{lab1Input.getText()}, lab1Output);
    }

    public void startLab2() {
        runLab("lab_2.Main", new String[]{}, lab2Output);
    }

    public void startLab3() {
        ArrayList<String> options = new ArrayList<>();
        options.add(lab3Input.getText());

        // Split text into list and ignore empty lines too
        options.addAll(Arrays.stream(lab3DictionariesList.getText().split("\n")).filter(s -> !s.trim().isEmpty()).toList());

        runLab("lab_3.Main", options.toArray(new String[0]), lab3Output);
    }

    public void startLab4() {
        runLab("lab_4.Main", new String[]{
                // We pass all values as string and then will convert them to arrays inside lab 4
                lab4InputAverageOfList.getText(),
                lab4InputTransformedStrings.getText(),
                lab4InputUniqueSquares.getText(),
                lab4InputLastElement.getText(),
                lab4InputSumOfEvenNumbers.getText(),
                lab4InputConvertedMap.getText(),
        }, lab4Output);
    }

    public void clearOutputForLab1() {
        lab1Output.clear();
    }

    public void clearOutputForLab2() {
        lab2Output.clear();
    }

    public void clearOutputForLab3() {
        lab3Output.clear();
    }

    public void clearOutputForLab4() {
        lab4Output.clear();
    }

    private void runLab(String className, String[] args, TextArea outputArea) {
        // Prepare the command to execute the class in a separate JVM
        List<String> command = new ArrayList<>();
        command.add("/home/nikolai/.jdks/openjdk-23/bin/java");
        command.add("-classpath");
        // Set the correct classpath where lab_x.Main classes are located
        command.add("./target/classes");
        // Class to be run
        command.add(className);
        Collections.addAll(command, args);

        // Start the process using ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process;
        try {
            process = processBuilder.start();
        } catch (IOException e) {
            showError("Error while starting lab process: " + e.getMessage());
            return;
        }

        // We will print both standard and error output in the same text
        StringBuilder outputTextBuilder = new StringBuilder();

        BufferedReader outReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader errReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        try {
            String outLine;
            String errLine;
            do {
                // Capture the process's standard output
                outLine = outReader.readLine();
                if (outLine != null) {
                    outputTextBuilder.append(outLine).append("\n");
                }

                // Capture any errors from the process's standard error
                errLine = errReader.readLine();
                if (errLine != null) {
                    outputTextBuilder.append(errLine).append("\n");
                }
            } while (outLine != null || errLine != null);
        } catch (IOException e) {
            showError("Error while reading lab process standard output: " + e.getMessage());
            return;
        }

        // Wait for the process to exit
        int exitCode;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            showError("Error while waiting for lab process to exit: " + e.getMessage());
            return;
        }

        // If exit code is not zero, change border color of the output box
        if (exitCode == 0) {
            outputArea.setStyle("-fx-background-color: green;");
        } else {
            outputArea.setStyle("-fx-background-color: red;");
        }

        outputArea.setText(outputTextBuilder.toString());
    }

    private void showError(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
