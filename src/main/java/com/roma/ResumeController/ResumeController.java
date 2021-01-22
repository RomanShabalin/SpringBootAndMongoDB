package com.roma.ResumeController;

import java.util.Optional;
import com.roma.Resume.Resume;
import com.roma.ResumeRepository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResumeController {

    @Autowired
    ResumeRepository resumeRepository;

    @RequestMapping("/resume")
    public String resume(Model model) {
        model.addAttribute("resumes", resumeRepository.findAll());
        return "resume";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        return "create";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age,
                       @RequestParam String email, @RequestParam String city, @RequestParam String vacancy,
                       @RequestParam int salary, @RequestParam String educationalInstitution) {
        Resume resume = new Resume();
        resume.setFirstName(firstName);
        resume.setLastName(lastName);
        resume.setAge(age);
        resume.setEmail(email);
        resume.setCity(city);
        resume.setVacancy(vacancy);
        resume.setSalary(salary);
        resume.setEducationalInstitution(educationalInstitution);
        resumeRepository.save(resume);
        return "redirect:/show/" + resume.getId();
    }

    @RequestMapping("/show/{id}")
    public String show(@PathVariable String id, Model model) {
        model.addAttribute("resume", resumeRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String id) {
        Optional<Resume> resume = resumeRepository.findById(id);
        resumeRepository.delete(resume.get());
        return "redirect:/resume";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        model.addAttribute("resume", resumeRepository.findById(id).get());
        return "edit";
    }

    @RequestMapping("/update")
    public String update(@RequestParam String id, @RequestParam String firstName, @RequestParam String lastName,
                         @RequestParam int age, @RequestParam String email, @RequestParam String city,
                         @RequestParam String vacancy, @RequestParam int salary, @RequestParam String educationalInstitution) {
        Optional<Resume> resume = resumeRepository.findById(id);
        resume.get().setFirstName(firstName);
        resume.get().setLastName(lastName);
        resume.get().setAge(age);
        resume.get().setEmail(email);
        resume.get().setCity(city);
        resume.get().setVacancy(vacancy);
        resume.get().setSalary(salary);
        resume.get().setEducationalInstitution(educationalInstitution);
        resumeRepository.save(resume.get());
        return "redirect:/show/" + resume.get().getId();
    }
}