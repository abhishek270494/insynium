package plm.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import plm.dao.PartDao;
import plm.model.Document;
import plm.model.Part;
import plm.services.IPartService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PartService extends CommonOperations implements IPartService {

    @Autowired
    private PartDao partDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(PartService.class);

    @Override
    public void reserve(String userId, String reference, String version, int iteration) {
        Part part = partDao.get(reference, version, iteration);

        if (part == null) {
            LOGGER.error("Part not found: reference={}, version={}, iteration={}", reference, version, iteration);
            return;
        }

        if (!part.isReserved() && !part.getLifeCycleTemplate().isFinal(part.getLifeCycleState())) {
            Part nextPartIteration = getPart(userId, iteration, part);
            part.setDocuments(getLinkedDocuments(part).stream()
                    .map(document -> {
                        Document nextIteration = mapReservedDocument(userId, iteration, document);
                        nextIteration.setPart(part);
                        return nextIteration;
                    })
                    .collect(Collectors.toSet()));
            partDao.create(nextPartIteration);
        }
    }

    @Override
    public void update(String userId, String reference, String version, int iteration, String partAttribute1, String partAttribute2) {
        Part part = partDao.get(reference, version, iteration);
        if (part.isReserved() && part.getReservedBy().equals(userId)) {
            part.setPartAttribute1(partAttribute1);
            part.setPartAttribute2(partAttribute2);
            partDao.update(part);
        }
    }

    @Override
    public void free(String userId, String reference, String version, int iteration) {
        Part part = partDao.get(reference, version, iteration);
        if (part.isReserved() && part.getReservedBy().equals(userId)) {
            part.setReserved(false);
            part.setReservedBy(null);
            part.setDocuments(getLinkedDocuments(part).stream().map(document -> {
                document.setReserved(false);
                document.setReservedBy(null);
                return document;
            }).collect(Collectors.toSet()));
            partDao.update(part);
        }
    }

    @Override
    public void setState(String userId, String reference, String version, int iteration, String state) {
        Part part = partDao.get(reference, version, iteration);
        if (!part.isReserved() && part.getLifeCycleTemplate().isKnown(state)) {
            part.setLifeCycleState(state);
            part.setDocuments(getLinkedDocuments(part).stream().map(document -> {
                document.setLifeCycleState(state);
                return document;
            }).collect(Collectors.toSet()));
            partDao.update(part);
        }
    }

    @Override
    public void revise(String userId, String reference, String version, int iteration) {
        Part part = partDao.get(reference, version, iteration);
        if (!part.isReserved() && part.getLifeCycleTemplate().isFinal(part.getLifeCycleState())) {
            Part nextPartVersion = new Part(part.getReference(), part.getVersionSchema().getNextVersionLabel(version), 1);
            nextPartVersion.setReserved(false);
            nextPartVersion.setReservedBy(null);
            nextPartVersion.setLifeCycleTemplate(part.getLifeCycleTemplate());
            nextPartVersion.setLifeCycleState(part.getLifeCycleTemplate().getInitialState());
            nextPartVersion.setVersionSchema(part.getVersionSchema());
            nextPartVersion.setPartAttribute1(part.getPartAttribute1());
            nextPartVersion.setPartAttribute2(part.getPartAttribute2());
            part.setDocuments(getLinkedDocuments(part).stream()
                    .map(document -> mapRevisedDocument(version, document))
                    .collect(Collectors.toSet()));
            partDao.create(nextPartVersion);
        }
    }

    private Part getPart(String userId, int iteration, Part part) {
        Part nextPartIteration = new Part(part.getReference(), part.getVersion(), iteration + 1);
        nextPartIteration.setReserved(true);
        nextPartIteration.setReservedBy(userId);
        nextPartIteration.setLifeCycleTemplate(part.getLifeCycleTemplate());
        nextPartIteration.setLifeCycleState(part.getLifeCycleState());
        nextPartIteration.setVersionSchema(part.getVersionSchema());
        nextPartIteration.setPartAttribute1(part.getPartAttribute1());
        nextPartIteration.setPartAttribute2(part.getPartAttribute2());
        return nextPartIteration;
    }

    public Set<Document> getLinkedDocuments(Part part) {
        //
        // Implementation and returned value are not relevant for this exercise
        //
        return new HashSet<>();
    }
}
