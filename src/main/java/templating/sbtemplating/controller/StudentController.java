package templating.sbtemplating.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import templating.sbtemplating.model.Student;
import templating.sbtemplating.service.StudentService;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        Student emptyStudent = new Student();
        model.addAttribute("students", studentService.getStudents());
        model.addAttribute("addStudent", emptyStudent);
        model.addAttribute("deleteStudent", emptyStudent);
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("addStudent") @Valid Student student, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("students", studentService.getStudents());
            model.addAttribute("deleteStudent", new Student());
            return "index";
        }
        studentService.addStudent(student);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("deleteStudent") Student student, Model model) {
        if(studentService.getStudent(student.getId()) == null){
            model.addAttribute("students", studentService.getStudents());
            model.addAttribute("addStudent", new Student());
            model.addAttribute("deleteStudent", student);
            model.addAttribute("errorMessage", "Invalid or non-existent student ID");
            return "index";
        }
        studentService.deleteStudent(student.getId());
        return "redirect:/";
    }
}
