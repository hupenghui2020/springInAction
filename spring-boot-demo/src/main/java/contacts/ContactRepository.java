package contacts;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hph
 */
@Repository
public class ContactRepository {

    @Resource
    private JdbcTemplate template;

    public List<Contact> findAll() {
        return template.query("select * from contacts order by lastName", new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet resultSet, int i) throws SQLException {

                Contact contact = new Contact();
                contact.setId(resultSet.getLong(1));
                contact.setFirstName(resultSet.getString(2));
                contact.setLastName(resultSet.getString(3));
                contact.setPhoneNumber(resultSet.getString(4));
                contact.setEmailAddress(resultSet.getString(5));
                return contact;
            }
        });
    }

    public void save(Contact contact) {
        template.update("insert into contacts (firstName, lastName, phoneNumber, emailAddress) values (?, ?, ?, ?)",
                contact.getFirstName(),
                contact.getLastName(),
                contact.getPhoneNumber(),
                contact.getEmailAddress());
    }
}
