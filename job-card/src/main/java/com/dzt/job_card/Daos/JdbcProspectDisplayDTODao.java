package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ProspectDisplayDTO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcProspectDisplayDTODao implements ProspectDisplayDTODao {

    private final JdbcTemplate template;

    public JdbcProspectDisplayDTODao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }


    @Override
    public ProspectDisplayDTO getProspectDisplayData(String jobStatus) {
        String sql = "SELECT jc.job_id, jc.prospect_id, jc.active_job_id, client.first_name, client.last_name " +
                "property.address, property.town, property.county, jc.intake_date, job_type.job_type " +
                "FROM job_card AS jc JOIN client ON " +
                "WHERE job_status = ?;";
        return null;
    }

    @Override
    public List<ProspectDisplayDTO> getProspectDisplayList(String jobStatus) {
        return null;
    }
}
