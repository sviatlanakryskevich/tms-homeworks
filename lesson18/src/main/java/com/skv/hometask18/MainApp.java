package com.skv.hometask18;


import com.skv.hometask18.domain.City;
import com.skv.hometask18.domain.Student;
import com.skv.hometask18.service.CityService;
import com.skv.hometask18.service.StudentService;

import java.util.List;

public class MainApp {
    public static void main(String[] args) throws Exception {
        StudentService service = new StudentService();
        List<Student> all = service.findAll();
        System.out.println(all);
        List<Student> allWithCities = service.findAllWithCities();
        System.out.println(allWithCities);
        CityService cityService = new CityService();
        cityService.save(new City("Gdansk"));
        Student student = new Student("Vasia", "D.", true, cityService.findCity("Minsk"));
        service.save(student);
        Student student1 = new Student("Vasia", "D.", true, null);
        service.save(student);
        service.deleteStudentById(2);
        cityService.deleteCityById(2);
    }
}
