package plm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Document extends AbstractEntity {

    @Column
    private String documentAttribute1;

    @Column
    private String documentAttribute2;

    public Document() {
    }

    public Document(String reference, String version, int iteration) {
        super(reference, version, iteration);
    }

    public void setDocumentAttribute1(String documentAttribute1) {
        this.documentAttribute1 = documentAttribute1;
    }

    public void setDocumentAttribute2(String documentAttribute2) {
        this.documentAttribute2 = documentAttribute2;
    }

    public String getDocumentAttribute1() {
        return documentAttribute1;
    }

    public String getDocumentAttribute2() {
        return documentAttribute2;
    }

}
