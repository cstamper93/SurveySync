package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ProspectDisplayDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class JdbcProspectDisplayDTODao implements ProspectDisplayDTODao {

    private final JdbcTemplate template;

    public JdbcProspectDisplayDTODao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public ProspectDisplayDTO getProspectDisplayData(String jobStatus) {
        String jobStatusToCompare = jobStatus.toLowerCase();
        System.out.println(jobStatusToCompare);
        ProspectDisplayDTO prospect = new ProspectDisplayDTO();
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
        SqlRowSet results = template.queryForRowSet(sql, jobStatusToCompare);
        if(results.next()) {
            prospect = mapRowToProspectObject(results);
        }
        return prospect;
    }


    @Override
    public List<ProspectDisplayDTO> getProspectDisplayList(String jobStatus) {
        LinkedHashMap<Integer, ProspectDisplayDTO> prospectMap = new LinkedHashMap<>();
        String sql = "SELECT jc.job_id, jc.prospect_id, jc.active_job_id, " +
                "c.first_name, c.last_name, " +
                "p.address, p.town, p.county, " +
                "jc.intake_date, jt.job_type " +
                "FROM job_card AS jc " +
                "JOIN job_card_client jcc ON jc.job_id = jcc.job_id " +
                "JOIN client c ON jcc.client_id = c.client_id " +
                "JOIN job_card_property jcp ON jc.job_id = jcp.job_id " +
                "JOIN property p ON jcp.prop_id = p.prop_id " +
                "JOIN job_type jt ON jc.job_id = jt.job_id " +
                "WHERE jc.job_status = ? " +
                "ORDER BY jc.job_id;";
        SqlRowSet results = template.queryForRowSet(sql, jobStatus);
        while(results.next()) {
            int jobId = results.getInt("job_id");
            ProspectDisplayDTO dto = prospectMap.get(jobId);
            if (dto == null) {
                dto = mapRowToProspectObject(results);
                prospectMap.put(jobId, dto);
            }
            dto.getJobTypes().add(results.getString("job_type"));
        }
        return new ArrayList<>(prospectMap.values());
    }

    private ProspectDisplayDTO mapRowToProspectObject(SqlRowSet rs) {
        ProspectDisplayDTO prospect = new ProspectDisplayDTO();
        prospect.setJobId(rs.getInt("job_id"));
        prospect.setProspectId(rs.getInt("prospect_id"));
        prospect.setActiveJobId(rs.getInt("active_job_id"));
        prospect.setClientFirstName(rs.getString("first_name"));
        prospect.setClientLastName(rs.getString("last_name"));
        prospect.setJobAddress(rs.getString("address"));
        prospect.setJobTown(rs.getString("town"));
        prospect.setJobCounty(rs.getString("county"));
        prospect.setIntakeDate(rs.getDate("intake_date"));
        // prospect.setJobType(rs.getString("job_type")); ==> put this logic within method
        return prospect;
    }
}
