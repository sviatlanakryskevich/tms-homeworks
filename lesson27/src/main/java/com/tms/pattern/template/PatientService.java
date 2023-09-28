package com.tms.pattern.template;

public abstract class PatientService {
    public void register(Patient patient){
        System.out.println("Send code to email");
        if(isValid(patient)){
            System.out.println("Save patient to DB");
            System.out.println("Add some coupons for patient");
        }
        System.out.println("Send information to patient");
    }
    public abstract boolean isValid(Patient patient);
}
