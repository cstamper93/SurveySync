package com.dzt.job_card.Daos;

import com.dzt.job_card.Models.ProspectDisplayDTO;

import java.util.List;

public interface ProspectDisplayDTODao {

    ProspectDisplayDTO getProspectDisplayData(String jobStatus);

    List<ProspectDisplayDTO> getProspectDisplayList(String jobStatus);
}
