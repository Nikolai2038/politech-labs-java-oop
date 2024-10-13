package coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class MainWindowController {

    // Text areas for displaying lab information and output
    @FXML
    private TextArea lab1Info, lab2Info, lab3Info, lab4Info;
    @FXML
    private TextArea lab1Output, lab2Output, lab3Output, lab4Output;

    // This method is called when the UI initializes; it sets the information for each lab
    @FXML
    public void initialize() {
        // Set lab information using the printInfo method of each lab's main class
        lab1Info.setText(getLabInfo(lab_1.Main.class));
        lab2Info.setText(getLabInfo(lab_2.Main.class));
        lab3Info.setText(getLabInfo(lab_3.Main.class));
        lab4Info.setText(getLabInfo(lab_4.Main.class));
    }

    // Methods to handle UI button clicks, which start each lab and display the output
    public void startLab1(ActionEvent actionEvent) {
        lab1Output.setText(runLab(lab_1.Main.class, new String[]{"1230"}));
    }

    public void startLab2(ActionEvent actionEvent) {
        lab2Output.setText(runLab(lab_2.Main.class, new String[]{}));
    }

    public void startLab3(ActionEvent actionEvent) {
        lab3Output.setText(runLab(lab_3.Main.class, new String[]{"lalala dog dog dog look to the window, dog look forward \n"}));
    }

    public void startLab4(ActionEvent actionEvent) {
        lab4Output.setText(runLab(lab_4.Main.class, new String[]{}));
    }

    // This method retrieves and returns the "info" output of a lab using reflection
    private String getLabInfo(Class<?> labClass) {
        // Capture the output of the lab's printInfo method
        return captureOutput(() -> invokeMethod(labClass, "printInfo", new Class<?>[]{}, new Object[]{}));
    }

    // This method runs the main method of the lab and returns the captured output
    private String runLab(Class<?> labClass, String[] args) {
        // Capture the output of the lab's main method with the provided arguments
        return captureOutput(() -> invokeMethod(labClass, "main", new Class<?>[]{String[].class}, new Object[]{args}));
    }

    // Utility method to invoke a specified method of a class using reflection
    private void invokeMethod(Class<?> labClass, String methodName, Class<?>[] paramTypes, Object[] args) {
        try {
            // Find the method in the class (e.g., "main" or "printInfo")
            Method method = labClass.getMethod(methodName, paramTypes);
            // Invoke the method, passing null for static methods (since these labs have static main/printInfo)
            method.invoke(null, args);
        } catch (Exception e) {
            // Wrap and rethrow any reflection-related exceptions as a RuntimeException
            throw new RuntimeException(e);
        }
    }

    // Utility method to capture the output produced during the execution of a runnable task
    private String captureOutput(Runnable task) {
        // Save the original System.out to restore later
        PrintStream originalOut = System.out;
        // Create a stream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Redirect System.out to the new PrintStream (attached to outputStream)
        try (PrintStream ps = new PrintStream(outputStream)) {
            System.setOut(ps); // Redirect the output to our stream
            task.run();        // Run the task that generates output
        } finally {
            // Restore the original System.out after the task completes
            System.setOut(originalOut);
        }

        // Return the captured output as a string
        return outputStream.toString();
    }
}
