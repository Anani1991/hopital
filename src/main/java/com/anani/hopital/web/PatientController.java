package com.anani.hopital.web;

import com.anani.hopital.entities.Patient;
import com.anani.hopital.repositories.PatientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p></p>
 *
 * @author ndrin.roger 2023-08-09
 */
@Controller
@AllArgsConstructor
public class PatientController {

  private PatientRepository patientRepository;

  @GetMapping("/index")
  public String index(Model model,
      @RequestParam(name = "page", defaultValue = "0") int page,
      @RequestParam(name = "size", defaultValue = "5") int size,
      @RequestParam(name = "keyword", defaultValue = "") String keyword) {
    Page<Patient> pagePatients = patientRepository.findByNonContains(keyword,
        PageRequest.of(page, size));
    model.addAttribute("patients", pagePatients.getContent());
    model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
    model.addAttribute("currentPage", page);
    model.addAttribute("keyword", keyword);
    return "patient";
  }

  @GetMapping("/delete")
  public String delete(
      @RequestParam(name = "id") Long id,
      @RequestParam(name = "keyword", defaultValue = "") String keyword,
      @RequestParam(name = "page", defaultValue = "0") int page) {
    patientRepository.deleteById(id);
    return "redirect:/index?page=" + page + "&keyword=" + keyword;
  }

  @GetMapping("/")
  public String home() {
    return "redirect:/index";
  }
  @GetMapping("/new-patient")
  public String formPatient(Model model){
    model.addAttribute("patient",new Patient());
    return "formPatient";
  }

  @PostMapping("/save-patient")
  public String savePatient(@Valid Patient patient, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
      return "formPatient";
    }
    patientRepository.save(patient);
//    return "formPatient";
    return "redirect:/index?keyword="+patient.getNon();
  }

  @GetMapping("/edit-patient")
  public String editPatient(Model model, @RequestParam(name = "id")Long id){
    Patient patient = this.patientRepository.findById(id).get();
    model.addAttribute("patient",patient);
    return "editPatient";
  }
}
