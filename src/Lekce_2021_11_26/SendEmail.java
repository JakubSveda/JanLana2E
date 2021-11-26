package Lekce_2021_11_26;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SendEmail {
    public static void main(String[] args) throws EmailException, FileNotFoundException {
        FileReader f = new FileReader("soubory/Heslo.txt");
        Scanner scanner = new Scanner(f);
        String password = scanner.nextLine();

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("jakub.sveda@student.gyarab.cz", password));
        email.setSSLOnConnect(true);
        email.setFrom("jakub.sveda@student.gyarab.cz");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("jakub.sveda@student.gyarab.cz");
        email.send();
    }
}
