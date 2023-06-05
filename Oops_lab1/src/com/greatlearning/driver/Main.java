package com.greatlearning.driver;

import com.greatlearning.models.Employee;
import com.greatlearning.services.CredentialService;


import java.util.HashMap;
import java.util.Scanner;


public class Main {

    public static Scanner scanner ;
    private static HashMap<Integer, String> hmap;

    static void displayOptions(){
        System.out.println("Please enter the department from the following");

        System.out.println("1. Technical");

        System.out.println("2. Admin");

        System.out.println("3. Human Resource");

        System.out.println("4. Legal");

    }

    public static String getDepartment(Integer dept){
        return hmap.get(dept);
    }
    private static void addToMap() {
        hmap = new HashMap<>();
        hmap.put(1,"tech");
        hmap.put(2,"admin");
        hmap.put(3,"hr");
        hmap.put(4,"legal");
    }
    public static void main(String[] args) {
        String firstName = "Meet";
        String lastName = "Gandhi";
        CredentialService credentialService = new CredentialService();

        scanner = new Scanner(System.in);
        displayOptions();
        Integer dept = scanner.nextInt();
        Employee employee = new Employee(firstName , lastName);
        addToMap();
        String department = getDepartment(dept);
        String email = credentialService.generateEmailAddress(employee,department);
        String password = credentialService.generatePassword();
        credentialService.showCredentials(employee,email,password);

        scanner.close();
    }

}