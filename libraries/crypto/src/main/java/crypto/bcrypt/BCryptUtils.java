package crypto.bcrypt;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtils {

    public static void main(String[] args) {
        String text = "OpenBSD-style Blowfish password hashing for Java";

        String hash = BCrypt.hashpw(text, BCrypt.gensalt(12));

        boolean check = BCrypt.checkpw(text, hash);

        System.out.println("BCrypt hash: " + hash);
        System.out.println("Check : " + check);
    }

}
