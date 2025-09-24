package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ProspectDisplayDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.List;

public class JdbcProspectDisplayDTODao implements ProspectDisplayDTODao {

    private final JdbcTemplate template;

    public JdbcProspectDisplayDTODao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    public ProspectDisplayDTO getProspectDisplayData(String jobStatus) {
        String sql = "SELECT jc.job_id, jc.prospect_id, jc.active_job_id, " +
                "client.first_name, client.last_name " +
                "property.address, property.town, property.county, " +
                "jc.intake_date, job_type.job_type " +
                "FROM job_card AS jc " +
                "JOIN job_card_client jcc ON jc.job_id = jcc.job_id " +
                "JOIN client c ON jcc.client_id = c.client_id " +
                "JOIN job_card_property jcp ON jc.job_id = jcp.job_id " +
                "JOIN property p ON jcp.prop_id = p.prop_id " +
                "WHERE job_status = ?;";
        return null;
    }

    @Override
    public List<ProspectDisplayDTO> getProspectDisplayList(String jobStatus) {
        return null;
    }

    private ProspectDisplayDTO mapRowToProspectObject(SqlRowSet rs) {
        ProspectDisplayDTO prospect = new ProspectDisplayDTO();
        prospect.setJobId(rs.getInt("job_id"));
        prospect.setProspectId(rs.getInt("prospect_id"));
        return null;
    }
}
