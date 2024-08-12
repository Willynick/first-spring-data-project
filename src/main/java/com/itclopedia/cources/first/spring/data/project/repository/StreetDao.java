package com.itclopedia.cources.first.spring.data.project.repository;

import com.itclopedia.cources.first.spring.data.project.entity.Street;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class StreetDao {

    private final DataSource dataSource;

    public List<Street> getAllStreets() {
        final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate.query ( "SELECT * FROM STREETS", (rs, rowNum) -> {
            Street street = new Street();
            street.setId(rs.getInt ( "ID" ));
            street.setName(rs.getString ( "NAME" ));
            return street;
        });
    }

}
