package plm.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Part extends AbstractEntity {

    @Column
    private String partAttribute1;

    @Column
    private String partAttribute2;

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
}
