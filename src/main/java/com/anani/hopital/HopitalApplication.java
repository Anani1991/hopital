package com.anani.hopital;

import com.anani.hopital.entities.Patient;
import com.anani.hopital.repositories.PatientRepository;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner {

  @Autowired
  private PatientRepository patientRepository;
  public static void main(String[] args) {
    SpringApplication.run(HopitalApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    //Patient patient1 = new Patient(null, "Mokobé",new Date(),false,10);

//    patientRepository.save(new Patient(null, "Patient 1",new Date(),false,50));
//    patientRepository.save(new Patient(null, "Patient 2",new Date(),true,100));
//    patientRepository.save(new Patient(null, "Patient 3",new Date(),false,10));
//    patientRepository.save(new Patient(null, "Patient 5",new Date(),true,25));
//    patientRepository.save(new Patient(null, "Patient 6",new Date(),false,10));
//    patientRepository.save(new Patient(null,"Patient 7 ",new Date(),false,50));
  }
}
