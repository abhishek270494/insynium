package java.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.model.Document;

@Repository
@Transactional
public class DocumentDao extends GenericDao<Document> {
    // Additional Part-specific methods can be added here
}
