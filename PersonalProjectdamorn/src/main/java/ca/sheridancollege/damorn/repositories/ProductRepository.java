package ca.sheridancollege.damorn.repositories;

import ca.sheridancollege.damorn.models.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductRepository {
    private final NamedParameterJdbcTemplate jdbc;

    public ProductRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Product> getAllProducts() {
        return jdbc.query("SELECT * FROM products", new BeanPropertyRowMapper<>(Product.class));
    }

    public void addProduct(Product p) {
        String sql = "INSERT INTO products (title, description, starting_price, current_bid, seller_id, auction_end) " +
                     "VALUES (:title, :description, :starting_price, :current_bid, :seller_id, :auction_end)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("title", p.getTitle());
        params.addValue("description", p.getDescription());
        params.addValue("starting_price", p.getStartingPrice());
        params.addValue("current_bid", p.getCurrentBid());
        params.addValue("seller_id", p.getSellerId());
        params.addValue("auction_end", p.getAuctionEnd());
        jdbc.update(sql, params);
    }

    public Product getProductById(Long id) {
        String sql = "SELECT * FROM products WHERE id = :id";
        MapSqlParameterSource param = new MapSqlParameterSource("id", id);
        List<Product> list = jdbc.query(sql, param, new BeanPropertyRowMapper<>(Product.class));
        return list.isEmpty() ? null : list.get(0);
    }

    public void updateProduct(Product p) {
        String sql = "UPDATE products SET title=:title, description=:description, starting_price=:starting_price, " +
                     "current_bid=:current_bid, seller_id=:seller_id, auction_end=:auction_end WHERE id=:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", p.getId());
        params.addValue("title", p.getTitle());
        params.addValue("description", p.getDescription());
        params.addValue("starting_price", p.getStartingPrice());
        params.addValue("current_bid", p.getCurrentBid());
        params.addValue("seller_id", p.getSellerId());
        params.addValue("auction_end", p.getAuctionEnd());
        jdbc.update(sql, params);
    }

    public void deleteProduct(Long id) {
        jdbc.update("DELETE FROM products WHERE id = :id", new MapSqlParameterSource("id", id));
    }
}

