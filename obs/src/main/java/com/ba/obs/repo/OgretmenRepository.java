package com.ba.obs.repo;

import com.ba.obs.model.Konu;
import com.ba.obs.model.Ogretmen;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository @AllArgsConstructor public class OgretmenRepository
{

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Ogretmen> getAll()
    {
        List<Ogretmen> ogretmenler = new ArrayList<>();
        String sql = "SELECT * FROM \"OBS\".\"OGRETMEN\"";
        RowMapper<Ogretmen> rowMapper = new RowMapper<Ogretmen>()
        {
            @Override public Ogretmen mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                // strategy pattern
                return new Ogretmen(rs.getInt(1), rs.getString(2));
            }
        };
        ogretmenler = jdbcTemplate.query(sql, rowMapper);
        return ogretmenler;
    }


    public Ogretmen getById(int id)
    {
        // prepstat
        String sql = "SELECT * FROM \"OBS\".\"OGRETMEN\" WHERE \"OGR_ID\" = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Ogretmen>()
        {
            @Override public Ogretmen mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                return new Ogretmen(rs.getInt(1), rs.getString(2));
            }
        }, id);
    }

    public boolean deleteById(int id)
    {
        // prepstat
        String sql = "DELETE FROM \"OBS\".\"OGRETMEN\" WHERE \"OGR_ID\" = :OGRETMEN_ID";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("OGRETMEN_ID", id);
        return namedParameterJdbcTemplate.update(sql, paramMap) != 0;
    }

    public boolean insert(Ogretmen ogretmen)
    {
        // prepstat
        String sql = "INSERT INTO \"OBS\".\"OGRETMEN\"(\"OGR_NAME\") VALUES (:OGR_NAME)";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("OGR_NAME", ogretmen.getOgr_name());
        return namedParameterJdbcTemplate.update(sql, paramMap) != 0;
    }

    public Ogretmen getOgretmenByName(String name)
    {
        String sql = "SELECT * FROM \"OBS\".\"OGRETMEN\" WHERE \"OGR_NAME\" = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Ogretmen>()
        {
            @Override public Ogretmen mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                return new Ogretmen(rs.getInt(1), rs.getString(2));
            }
        }, name);
    }

}