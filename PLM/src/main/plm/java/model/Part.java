package java.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "part")
public class Part extends BaseEntity {

    @Column(length = 100)
    private String partAttribute1;

    @Column(length = 100)
    private String partAttribute2;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Document> documents = new HashSet<>();

    public Part() {

    }

    public Part(String reference, String version, int iteration) {
        super(reference, version, iteration);
    }

    public String getPartAttribute1() {
        return partAttribute1;
    }

    public void setPartAttribute1(String partAttribute1) {
        this.partAttribute1 = partAttribute1;
    }

    public String getPartAttribute2() {
        return partAttribute2;
    }

    public void setPartAttribute2(String partAttribute2) {
        this.partAttribute2 = partAttribute2;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}
