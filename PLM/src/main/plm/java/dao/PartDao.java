package java.dao;

import java.model.Part;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PartDao extends GenericDao<Part> {
    // Additional Part-specific methods can be added here
}
