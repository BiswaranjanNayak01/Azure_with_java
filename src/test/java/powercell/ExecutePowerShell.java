package powercell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExecutePowerShell {

    public static void runPowerCell_1() {
        // Define the PowerShell command
        String command = "powershell.exe -Command \"Connect-AzAccount; Get-AzResource\"";

        try {
            // Use ProcessBuilder to execute the PowerShell command
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Read the output from PowerShell
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
    public static void runPowerCell_2() {
        // Define the PowerShell command
        String command = "powershell.exe -Command \"Connect-AzAccount; Get-AzResource\"";


    }

    public static String runPowerCell_3() throws IOException {
        Scanner in=new Scanner(System.in);
        String command;
        String processOutput;

//        command="powershell.exe Get-ExecutionPolicy";
//        command="powershell.exe Get-ExecutionPolicy";
//        command="powershell.exe Get-ExecutionPolicy";
//        command="powershell.exe Get-ExecutionPolicy";
        command="powershell.exe Get-Service";

        //Executing the command
        Process powerShellProcess=Runtime.getRuntime().exec(command);
        powerShellProcess.getOutputStream().close();

        String line;
        processOutput="Standard Output:%n";
        BufferedReader stdout= new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));

        while ((line=stdout.readLine())!=null){
            processOutput+=line+"\n";
//            System.out.println(line);
        }
        processOutput+=line;
        stdout.close();
        processOutput+="\n\nStandard Error:%n";
        BufferedReader stderr= new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));

        while ((line=stderr.readLine())!=null){
            processOutput+=line+"\n";
        }
        in.close();
        stderr.close();

        processOutput+= "Done%n";
        processOutput=String.format(processOutput);
        System.out.println(processOutput);
        return processOutput;
    }

    public static void main(String[] args) throws IOException {
        runPowerCell_3();
    }

    public static String runPowerCell_4() throws IOException {
        Scanner in=new Scanner(System.in);
        String command;
        String processOutput;

//        command="powershell.exe Get-ExecutionPolicy";
//        command="powershell.exe Get-ExecutionPolicy";
//        command="powershell.exe Get-ExecutionPolicy";
//        command="powershell.exe Get-ExecutionPolicy";
        command="powershell.exe Get-Service";

        //Executing the command
//        Process powerShellProcess=Runtime.getRuntime().exec(command);
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.redirectErrorStream(true);
        Process powerShellProcess=processBuilder.start();;
        powerShellProcess.getOutputStream().close();

        String line;
        processOutput="Standard Output:%n";
        BufferedReader stdout= new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));

        while ((line=stdout.readLine())!=null){
            processOutput+=line+"\n";
        }
        processOutput+=line;
        stdout.close();
        processOutput+="\n\nStandard Error:%n";
        BufferedReader stderr= new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));

        while ((line=stderr.readLine())!=null){
            processOutput+=line+"\n";
        }
        in.close();
        stderr.close();

        processOutput+= "Done%n";
        processOutput=String.format(processOutput);
        System.out.println(processOutput);
        return processOutput;
    }

}
