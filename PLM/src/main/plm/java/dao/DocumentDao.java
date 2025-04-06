package java.dao;

import java.model.Document;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DocumentDao extends GenericDao<Document> {
    // Additional Part-specific methods can be added here
}
