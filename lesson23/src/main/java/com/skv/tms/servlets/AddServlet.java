package com.skv.tms.servlets;

import com.skv.tms.domain.Database;
import com.skv.tms.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private final Database database = new Database();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String ageAsString = req.getParameter("age");
        Integer age = 0;
        if(ageAsString != null && !ageAsString.isBlank()){
            age = Integer.parseInt(ageAsString);
        }
        String city = req.getParameter("city");

        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setCity(city);

        database.addStudent(student);
        req.getRequestDispatcher("/main").forward(req, resp);
    }
}
