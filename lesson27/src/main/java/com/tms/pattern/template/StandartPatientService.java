package com.tms.pattern.template;

public class StandartPatientService extends PatientService{

    @Override
    public boolean isValid(Patient patient) {
        if(patient.getLogin() == null || patient.getLogin().isBlank()){
            return false;
        }
        if(patient.getPassword() == null || patient.getPassword().isBlank() || patient.getPassword().length() < 8){
            return false;
        }
        return true;
    }
}
