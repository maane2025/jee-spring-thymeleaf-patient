package ma.maaneaimane.jee_spring_thymeleaf_patient_app.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.maaneaimane.jee_spring_thymeleaf_patient_app.entities.Patient;
import ma.maaneaimane.jee_spring_thymeleaf_patient_app.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Page<Patient> pagePatients = patientRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/deletePatient")
    public String delete(Long id, String keyword, int page) {
        patientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/formPatient")
    public String formPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatient";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "formPatient";
        patientRepository.save(patient);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/editPatient")
    public String editPatient(Model model, Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) throw new RuntimeException("Patient introuvable");
        model.addAttribute("patient", patient);
        return "editPatient";
    }

    @PostMapping("/update")
    public String update(@Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "editPatient";
        patientRepository.save(patient);
        return "redirect:/index";
    }
}
