package java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Document extends BaseEntity {

    @Column(length = 100)
    private String documentAttribute1;

    @Column(length = 100)
    private String documentAttribute2;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "part_reference", referencedColumnName = "reference"),
            @JoinColumn(name = "part_version", referencedColumnName = "version"),
            @JoinColumn(name = "part_iteration", referencedColumnName = "iteration")
    })
    // Add columns (part_reference, part_version, part_iteration) in the document table to enable the foreign key
    private Part part;

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

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

}
