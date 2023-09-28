package com.tms.pattern.template;

public class RegisterService {
    public void register(Patient patient, PatientService patientService){
        patientService.register(patient);
    }
}
