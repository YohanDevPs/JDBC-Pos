package com.api.ProjectJDBC.domain.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ResourceRepository {

//    private JdbcTemplate jdbcTemplate;
//
//    public ResourceRepository(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
////    public List<Resource> getAll() {
////        String sql = "SELECT id, name, quantity FROM tresource";
////        return jdbcTemplate.query(sql, (rs, i) ->  new Resource(
////                rs.getLong("id"),
////                rs.getString("name"),
////                rs.getFloat(3)
////        ));
////    };
//
//    public void save(Resource resource) {
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        String sql = "INSERT INTO tresource (name, quantity) VALUES (?, ?)";
//        jdbcTemplate.update(connection -> {
//            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            pst.setString(1, resource.getName());
//            pst.setFloat(2, resource.getQuantity());
//            return pst;
//        }, keyHolder);
//        resource.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
//    }
//
//    public Resource getById(Long id, Resource resource) {
//        String sql = "SELECT id, name, quantity FROM tresource WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new (
//                rs.getLong("id"),
//                rs.getString("name"),
//                rs.getFloat("quantity")
//        ));
//    }
//
//    public void update(Resource resource) {
//        String sql = "UPDATE tresource SET name = ?, quantity = ? WHERE id = ?";
//        jdbcTemplate.update(sql, resource.getName(), resource.getQuantity(), resource.getId());
//    }
//
//    public void remove(Long id) {
//        String sql = "DELETE FROM tresource WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
}
