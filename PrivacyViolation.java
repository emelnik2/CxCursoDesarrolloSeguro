import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrivacyViolation {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese su contraseña: ");
            String password = reader.readLine();
            System.out.println("Su contraseña es: " + password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
