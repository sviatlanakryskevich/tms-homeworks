package com.tms.pattern.template;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("example", "examplesdfg" , "example");
        RegisterService registerService = new RegisterService();
        registerService.register(patient, new VipPatientService());
    }
}
