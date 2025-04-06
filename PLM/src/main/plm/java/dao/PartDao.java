package java.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.model.Part;

@Repository
@Transactional
public class PartDao extends GenericDao<Part> {
    // Additional Part-specific methods can be added here
}
