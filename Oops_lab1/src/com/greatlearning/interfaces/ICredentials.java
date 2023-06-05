package com.greatlearning.interfaces;

import com.greatlearning.models.Employee;

public interface ICredentials {
   public String generatePassword();
   public String generateEmailAddress(Employee e, String department);
   public void showCredentials(Employee e, String email , String password);

}
