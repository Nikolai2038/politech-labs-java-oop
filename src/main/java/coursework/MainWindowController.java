package coursework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

public class MainWindowController {
    @FXML
    private TextArea lab1Output;

    @FXML
    private TextArea lab2Output;

    @FXML
    private TextArea lab3Output;

    @FXML
    private TextArea lab4Output;

    // @FXML
    // public void initialize() {
    // }

    public void startLab1(ActionEvent actionEvent) {
        // Call lab
        String output = this.callLab(lab_1.Main.class, new String[]{"1230"});

        // Update output field
        lab1Output.setText(output);
    }

    public void startLab2(ActionEvent actionEvent) {
        // Call lab
        String output = this.callLab(lab_2.Main.class, new String[]{});

        // Update output field
        lab2Output.setText(output);
    }

    public void startLab3(ActionEvent actionEvent) {
        // Call lab
        String output = this.callLab(lab_3.Main.class, new String[]{"lalala dog dog dog look to the window, dog look forward \n"});

        // Update output field
        lab3Output.setText(output);
    }

    public void startLab4(ActionEvent actionEvent) {
        // Call lab
        String output = this.callLab(lab_4.Main.class, new String[]{});

        // Update output field
        lab4Output.setText(output);
    }

    private String callLab(Class<?> labClass, String[] args) {
        // Save the original System.out for later
        PrintStream originalOut = System.out;

        // Create a ByteArrayOutputStream to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(outputStream);

        // Redirect System.out to the new PrintStream
        System.setOut(ps);

        try {
            // Get the 'main' method of the provided class (labClass)
            Method mainMethod = labClass.getMethod("main", String[].class);

            // Call the 'main' method with args
            mainMethod.invoke(null, (Object) args);  // (Object) args is needed to avoid varargs warning
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Restore System.out to its original stream
            System.setOut(originalOut);
        }

        // Restore System.out to its original stream
        System.setOut(originalOut);

        // Get the output as a string
        return outputStream.toString();
    }
}
