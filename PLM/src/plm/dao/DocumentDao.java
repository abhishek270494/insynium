package plm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import plm.model.Document;
import plm.model.Part;

@Repository
@Transactional
public class DocumentDao extends GenericDao<Document> {
    // Additional Part-specific methods can be added here
}
