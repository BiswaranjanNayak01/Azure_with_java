package powercell;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunAzurePowerShellScriptWithParams {

    public static void main(String[] args) {
        // Path to the PowerShell script file
        String scriptPath = "C:\\JavaScript\\Automation_Testing\\Azure_Java_code\\src\\main\\resources\\powercell\\AzurePowerShellScriptWithParams.ps1"; // Update this to your .ps1 file path
        String resourceGroupName = "YourResourceGroupName"; // Update this to the parameter value you want to pass

        // PowerShell command with parameters
        String command = "powershell.exe -ExecutionPolicy Bypass -File " + scriptPath + " -ResourceGroupName " + resourceGroupName;

        try {
            // Using ProcessBuilder to execute the PowerShell command with parameters
            ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-ExecutionPolicy", "Bypass", "-File", scriptPath, "-ResourceGroupName", resourceGroupName);
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
