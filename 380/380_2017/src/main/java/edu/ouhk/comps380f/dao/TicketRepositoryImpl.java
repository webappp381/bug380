package edu.ouhk.comps380f.dao;

import edu.ouhk.comps380f.model.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    private DataSource dataSource;
    private JdbcOperations jdbcOp;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcOp = new JdbcTemplate(this.dataSource);
    }
//
//    private static final class TicketRowMapper implements RowMapper<Ticket> {
//
//        @Override
//        public Ticket mapRow(ResultSet rs, int i) throws SQLException {
//            Ticket ticket = new Ticket();
//            ticket.setId(rs.getInt("id"));
//            ticket.setSubject(rs.getString("subject"));
//            ticket.setBody(rs.getString("body"));
//            ticket.setCategories(rs.getString("categories"));
//            ticket.setCustomerName(rs.getString("customername"));
//            
//            
//            
//            
//            
//            return ticket;
//        }
//    }

    private static final String SQL_INSERT_TICKET
            = "insert into ticket (id,customerName,subject,body,categories) values (1,'p','f','d','lab')";
//        private static final String SQL_INSERT_TICKET
//            = "insert into ticket (id,customername,subject,body,categories) values (?,?,?,?,?)";
   // private static final String SQL_INSERT_ROLE
     //       = "insert into user_roles (username, role) values (?, ?)";

    public void create(Ticket ticket) {
        jdbcOp.update(SQL_INSERT_TICKET);
                //ticket.getId());
//                ticket.getSubject(),
//                ticket.getCustomerName(),
//                ticket.getBody(),
//                ticket.getCategories());
      /*  for (String role : user.getRoles()) {
            jdbcOp.update(SQL_INSERT_ROLE,
                    user.getUsername(),
                    role);
        }
*/
    }

  /*  private static final String SQL_SELECT_ALL_TICKET
            = "select id, customername from ticket";
  //  private static final String SQL_SELECT_ROLES
    //        = "select username, role from user_roles where username = ?";

    @Override
    public List<Ticket> findAll() {
        List<Ticket> users = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcOp.queryForList(SQL_SELECT_ALL_TICKET);

        for (Map<String, Object> row : rows) {
            Ticket ticket = new Ticket();
            String username = (String) row.get("username");
            user.setUsername(username);
            user.setPassword((String) row.get("password"));
            List<Map<String, Object>> roleRows = jdbcOp.queryForList(SQL_SELECT_ROLES, username);
            for (Map<String, Object> roleRow : roleRows) {
                user.addRole((String) roleRow.get("role"));
            }
            users.add(user);
        }
        return users;
    }
    private static final String SQL_SELECT_USER
            = "select username, password from users where username = ?";

    @Override
    public TicketUser findByUsername(String username) {
        TicketUser ticketUser = jdbcOp.queryForObject(SQL_SELECT_USER, new TicketUserRowMapper(), username);
        List<Map<String, Object>> rows = jdbcOp.queryForList(SQL_SELECT_ROLES, username);
        for (Map<String, Object> row : rows) {
            ticketUser.addRole((String) row.get("role"));
        }
        return ticketUser;
    }
*/
//    private static final String SQL_DELETE_USER
//            = "delete from users where username = ?";
//    private static final String SQL_DELETE_ROLES
//            = "delete from user_roles where username = ?";
//
//    @Override
//    public void deleteByUsername(String username) {
//        jdbcOp.update(SQL_DELETE_ROLES, username);
//        jdbcOp.update(SQL_DELETE_USER, username);
//    }

}
