package com.greatlearning.services;

import com.greatlearning.interfaces.ICredentials;
import com.greatlearning.models.Employee;

import java.util.Random;

public class CredentialService implements ICredentials {
    @Override
    public String generatePassword() {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        String password = "";

        password += lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password += capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password += specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password += numbers.charAt(random.nextInt(numbers.length()));

        for(int i = 4; i< 8 ; i++) {
            password += combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;

    }

    @Override
    public String generateEmailAddress(Employee e, String department) {
        return e.getFirstName()+e.getLastName()+"@"+department+".abc.com";
    }

    @Override
    public void showCredentials(Employee e, String email , String password) {
        System.out.println(String.format("Hi %s , below are your generated Credentials ." , e.getFirstName() ));
        System.out.println("Email ------> "+email );
        System.out.println("Password ------> " + password);
    }
}
