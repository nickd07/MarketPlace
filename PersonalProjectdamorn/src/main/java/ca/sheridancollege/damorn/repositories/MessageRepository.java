package ca.sheridancollege.damorn.repositories;

import ca.sheridancollege.damorn.models.Message;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public MessageRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void saveMessage(Message m) {
        String sql = "INSERT INTO messages (product_id, sender_name, content, sent_time) " +
                     "VALUES (:productId, :senderName, :content, :sentTime)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("productId", m.getProductId());
        params.addValue("senderName", m.getSenderName());
        params.addValue("content", m.getContent());
        params.addValue("sentTime", m.getSentTime());
        jdbc.update(sql, params);
    }

    public List<Message> getMessagesByProductId(Long productId) {
        String sql = "SELECT * FROM messages WHERE product_id = :productId ORDER BY sent_time DESC";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("productId", productId);
        return jdbc.query(sql, params, new BeanPropertyRowMapper<>(Message.class));
    }

}
