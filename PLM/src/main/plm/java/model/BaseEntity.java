package java.model;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@IdClass(BaseEntity.BaseEntityPK.class)
public class BaseEntity {

    @Id
    @NonNull
    private String reference;

    @Id
    @NonNull
    private String version;

    @Id
    @NonNull
    private int iteration;

    @Column
    private boolean reserved;

    @Column(length = 100)
    private String reservedBy;

    @ManyToOne
    private LifeCycleTemplate lifeCycleTemplate;

    @Column
    private String lifeCycleState;

    @ManyToOne
    private VersionSchema versionSchema;

    public BaseEntity() {
    }

    public BaseEntity(String reference, String version, int iteration) {
        this.reference = reference;
        this.version = version;
        this.iteration = iteration;
    }

    public String getReference() {
        return reference;
    }

    public String getVersion() {
        return version;
    }

    public int getIteration() {
        return iteration;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public LifeCycleTemplate getLifeCycleTemplate() {
        return lifeCycleTemplate;
    }

    public String getLifeCycleState() {
        return lifeCycleState;
    }

    public VersionSchema getVersionSchema() {
        return versionSchema;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public void setLifeCycleTemplate(LifeCycleTemplate lifeCycleTemplate) {
        this.lifeCycleTemplate = lifeCycleTemplate;
    }

    public void setLifeCycleState(String lifeCycleState) {
        this.lifeCycleState = lifeCycleState;
    }

    public void setVersionSchema(VersionSchema versionSchema) {
        this.versionSchema = versionSchema;
    }

    public static class BaseEntityPK implements Serializable {
        private String reference;
        private String version;
        private int iteration;

        public BaseEntityPK() {
        }

        public BaseEntityPK(String reference, String version, int iteration) {
            this.reference = reference;
            this.version = version;
            this.iteration = iteration;
        }

        @Override
        public int hashCode() {
            return Objects.hash(iteration, reference, version);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            BaseEntityPK other = (BaseEntityPK) obj;
            return iteration == other.iteration && Objects.equals(reference, other.reference) && Objects.equals(version, other.version);
        }
    }
}
