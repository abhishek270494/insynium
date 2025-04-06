package plm.services.impl;

import plm.model.Document;

public class CommonOperations {

    static Document mapRevisedDocument(String version, Document document) {
        Document nextDocumentVersion = new Document(document.getReference(), document.getVersionSchema().getNextVersionLabel(version), 1);
        nextDocumentVersion.setReserved(false);
        nextDocumentVersion.setReservedBy(null);
        nextDocumentVersion.setLifeCycleTemplate(document.getLifeCycleTemplate());
        nextDocumentVersion.setLifeCycleState(document.getLifeCycleTemplate().getInitialState());
        nextDocumentVersion.setVersionSchema(document.getVersionSchema());
        nextDocumentVersion.setDocumentAttribute1(document.getDocumentAttribute1());
        nextDocumentVersion.setDocumentAttribute2(document.getDocumentAttribute2());
        return nextDocumentVersion;
    }

    static Document mapReservedDocument(String userId, int iteration, Document document) {
        Document nextIteration = new Document(document.getReference(), document.getVersion(), iteration + 1);
        nextIteration.setReserved(true);
        nextIteration.setReservedBy(userId);
        nextIteration.setLifeCycleTemplate(document.getLifeCycleTemplate());
        nextIteration.setLifeCycleState(document.getLifeCycleState());
        nextIteration.setVersionSchema(document.getVersionSchema());
        nextIteration.setDocumentAttribute1(document.getDocumentAttribute1());
        nextIteration.setDocumentAttribute2(document.getDocumentAttribute2());
        return nextIteration;
    }
}
