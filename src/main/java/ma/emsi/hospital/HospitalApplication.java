package ma.emsi.hospital;

import ma.emsi.hospital.entities.*;
import ma.emsi.hospital.repositories.ConsultationRepository;
import ma.emsi.hospital.repositories.MedecinRepository;
import ma.emsi.hospital.repositories.PatientRepository;
import ma.emsi.hospital.repositories.RendezVousRepository;
import ma.emsi.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            IHospitalService iHospitalService,
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            ConsultationRepository consultationRepository,
            RendezVousRepository rendezVousRepository
            ){
        return args -> {
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        iHospitalService.savePatient(patient);
                    });
            Stream.of("Ayman","Rayan","Wissal")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        iHospitalService.saveMedecin(medecin);
                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohamed");

            Medecin medecin=medecinRepository.findByNom("Wissal");

            Rendezvous rendezvous = new Rendezvous();
            rendezvous.setDate(new Date());
            rendezvous.setStatus(StatusRDV.PENDING);
            rendezvous.setPatient(patient);
            rendezVousRepository.save(rendezvous);

            Rendezvous rendezvous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezvous(rendezvous1);
            consultation.setRapport("Rapport de la consultation");
            consultationRepository.save(consultation);



        };
    }

}
