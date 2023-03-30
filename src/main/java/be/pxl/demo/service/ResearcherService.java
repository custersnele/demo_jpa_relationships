package be.pxl.demo.service;

import be.pxl.demo.api.dto.ContactType;
import be.pxl.demo.api.dto.ResearcherRequest;
import be.pxl.demo.domain.ContactInformation;
import be.pxl.demo.domain.Researcher;
import be.pxl.demo.exception.ResourceNotFoundException;
import be.pxl.demo.repository.ResearcherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResearcherService {

    private final ResearcherRepository researcherRepository;

    public ResearcherService(ResearcherRepository researcherRepository) {
        this.researcherRepository = researcherRepository;
    }

    public long createResearcher(ResearcherRequest researcherRequest) {
        Researcher researcher = new Researcher();
        researcher.setFirstname(researcherRequest.firstname());
        researcher.setLastname(researcherRequest.lastname());
        ContactInformation contactInformation = new ContactInformation();
        contactInformation.setEmail(researcherRequest.email());
        contactInformation.setPhone(researcherRequest.phone());
        contactInformation.setLinkedIn(researcherRequest.linkedIn());
        researcher.setContactInformation(contactInformation);
        return researcherRepository.save(researcher).getId();
    }

    @Transactional
    public void updateContactInformation(long researcherId, ContactType field, String value) {
        Researcher researcher = researcherRepository.findById(researcherId).orElseThrow(() -> new ResourceNotFoundException("Researcher", "id", researcherId));
        switch (field) {
            case EMAIL -> researcher.getContactInformation().setEmail(value);
            case PHONE -> researcher.getContactInformation().setPhone(value);
        }
    }

    public void deleteResearcher(long researcherId) {
        researcherRepository.deleteById(researcherId);
    }
}
