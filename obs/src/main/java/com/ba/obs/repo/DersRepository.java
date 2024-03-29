package com.ba.obs.repo;

import com.ba.obs.dto.DersDTO;
import com.ba.obs.model.Ders;
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

@Repository @AllArgsConstructor public class DersRepository
{

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<Ders> getAll()
    {
        List<Ders> dersler = new ArrayList<>();
        String sql = "SELECT * FROM \"OBS\".\"DERS\"";
        RowMapper<Ders> rowMapper = new RowMapper<Ders>()
        {
            @Override public Ders mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                // strategy pattern
                return new Ders(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        };

        dersler = jdbcTemplate.query(sql, rowMapper);
        return dersler;

    }

    public List<DersDTO> getAlldersDTO()
    {
        List<DersDTO> dersler = new ArrayList<>();
        String sql = "select D.\"DERS_ID\", D.\"OGRETMEN_ID\", D.\"KONU_ID\", O.\"OGR_NAME\", K.\"KONU\" from \"OBS\".\"DERS\" D INNER JOIN \"OBS\".\"OGRETMEN\" O ON D.\"OGRETMEN_ID\" = O.\"OGR_ID\" INNER JOIN \"OBS\".\"KONU\" K ON D.\"KONU_ID\" = K.\"KONU_ID\"";
        RowMapper<DersDTO> rowMapper = new RowMapper<DersDTO>()
        {
            @Override public DersDTO mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                // strategy pattern
                return new DersDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            }
        };

        dersler = jdbcTemplate.query(sql, rowMapper);
        return dersler;

    }

    public Ders getById(int id)
    {
        // prepstat
        String sql = "SELECT * FROM \"OBS\".\"DERS\" WHERE \"DERS_ID\" = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Ders>()
        {
            @Override public Ders mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                return new Ders(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        }, id);
    }

    public boolean deleteById(int id)
    {
        // prepstat
        String sql = "DELETE FROM \"OBS\".\"DERS\" WHERE \"DERS_ID\" = :DERS_ID";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("DERS_ID", id);
        return namedParameterJdbcTemplate.update(sql, paramMap) != 0;
    }

    public boolean insert(Ders ders)
    {
        // prepstat
        String sql = "INSERT INTO \"OBS\".\"DERS\"(\"OGRETMEN_ID\", \"KONU_ID\") VALUES (:OGRETMEN_ID, :KONU_ID)";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("OGRETMEN_ID", ders.getOgretmen_id());
        paramMap.put("KONU_ID", ders.getKonu_id());
        return namedParameterJdbcTemplate.update(sql, paramMap) != 0;
    }


}