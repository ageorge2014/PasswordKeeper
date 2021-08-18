//package sample;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Database {

    Map<String, String> DB = new HashMap<String, String>();
    public static final String SALT = "my-salt-text";

    public static void main(String args[]) {

        Database data = new Database();


        System.out.println(data.generateHash("abc123"));

        data.signup("john", "abc123");

        // login should succeed.
        if (data.password("john", "abc123"))
            System.out.println("user login successful.");

        // login should fail because of wrong password.
        if (data.password("john", "blahblah"))
            System.out.println("User login successful.");
        else
            System.out.println("user login failed.");
    }

    public static final String
    readFile(String pathname)
            throws IOException {
        String contents = "";
        try (InputStream in = new BufferedInputStream(new FileInputStream(pathname))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                contents += new String(buffer, 0, lengthRead);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return contents;
    }

    File file = new File("");
    String fileContent = "";
    while(scan.hasNextLine())

    {
        fileContent = fileContent.concat(file.nextLine + "")
    }

}
    Scanner scan = new Scanner // read the first line of the file and put that line as the master password

    //read the remaining lines and parse them to create password entry object

    public void signup(String username, String password) {
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);
        if (hashedPassword != password())
            throw new RuntimeException("Wrong Password! Try again!");
    }

    public Boolean password(String username, String password) {
        //Boolean isAuthenticated = false;

        // use the same SALT value use used while storing password
        // for the first time.
        String saltedPassword = SALT + password;
        String hashedPassword = generateHash(saltedPassword);

        String storedPasswordHash = DB.get(username);
        return hashedPassword.equals(storedPasswordHash);
    }

    //private String getMasterpassword() {
       // return password();
    //}

    public static String generateHash(String input) {
        StringBuilder hash = new StringBuilder();

        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = sha.digest(input.getBytes());
            char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'a', 'b', 'c', 'd', 'e', 'f' };
            for (byte b : hashedBytes) {
                hash.append(digits[(b & 0xf0) >> 4]);
                hash.append(digits[b & 0x0f]);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // handle error here.
        }

        return hash.toString();
    }

}