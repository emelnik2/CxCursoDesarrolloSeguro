import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandInjection {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese el nombre del archivo que desea abrir: ");
            String fileName = reader.readLine();

            // Vulnerable code
            String command = "cat " + fileName;
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = processOutputReader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
