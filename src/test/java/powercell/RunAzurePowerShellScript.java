package powercell;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class RunAzurePowerShellScript {

    public static void main(String[] args) {
        // Path to the PowerShell script file
//        String scriptPath = "C:\\JavaScript\\Automation_Testing\\Azure_Java_code\\src\\main\\resources\\powercell\\azureScript.ps1"; // Change this to your .ps1 file path
     String scriptPath="C:\\JavaScript\\Automation_Testing\\Azure_Java_code\\src\\main\\resources\\powercell\\trail_1.ps1";
        // PowerShell command to execute the script
        String command = "powershell.exe -ExecutionPolicy Bypass -File " + scriptPath;

        try {
            // Use ProcessBuilder to run the PowerShell command
            ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-ExecutionPolicy", "Bypass", "-File", scriptPath);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Read the output from the script execution
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
