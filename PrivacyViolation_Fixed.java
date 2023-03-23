import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrivacyMitigation {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese su contraseña: ");
            String password = reader.readLine();
            System.out.println("Contraseña recibida con éxito");

            // Masking the password
            StringBuilder maskedPassword = new StringBuilder();
            for (int i = 0; i < password.length(); i++) {
                maskedPassword.append("*");
            }
            System.out.println("Su contraseña es: " + maskedPassword);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
