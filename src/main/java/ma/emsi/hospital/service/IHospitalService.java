package ma.emsi.hospital.service;

import ma.emsi.hospital.entities.Consultation;
import ma.emsi.hospital.entities.Medecin;
import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.entities.Rendezvous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    Rendezvous savePatient(Rendezvous rendezvous);
    Consultation savePatient(Consultation consultation);
}
