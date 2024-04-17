package ma.emsi.hospital.service;

import jakarta.transaction.Transactional;
import ma.emsi.hospital.entities.Consultation;
import ma.emsi.hospital.entities.Medecin;
import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.entities.Rendezvous;
import ma.emsi.hospital.repositories.ConsultationRepository;
import ma.emsi.hospital.repositories.MedecinRepository;
import ma.emsi.hospital.repositories.PatientRepository;
import ma.emsi.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public Rendezvous savePatient(Rendezvous rendezvous) {

        return rendezVousRepository.save(rendezvous);
    }

    @Override
    public Consultation savePatient(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
