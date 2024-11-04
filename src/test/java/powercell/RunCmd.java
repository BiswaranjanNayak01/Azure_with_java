package powercell;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RunCmd {
    public static void main(String[] args) {
        // Define the command to be executed using cmd
//        String[] command = {"cmd.exe", "/c", "dir"};
        String[] command = {"cmd.exe", "/c", "echo Hello from cmd"};

        try {
            // Initialize ProcessBuilder with the command array
            ProcessBuilder processBuilder = new ProcessBuilder(command);

            // Start the process
            Process process = processBuilder.start();

            // Read the output from the process
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line of the output
            }

            // Wait for the process to complete and get the exit code
            int exitCode = process.waitFor();
            System.out.println("\nExited with code: " + exitCode);

        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }
    }
}
