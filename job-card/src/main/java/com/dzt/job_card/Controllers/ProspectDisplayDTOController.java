package com.dzt.job_card.Controllers;

import com.dzt.job_card.Daos.ProspectDisplayDTODao;
import com.dzt.job_card.Models.ProspectDisplayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProspectDisplayDTOController {

    @Autowired
    ProspectDisplayDTODao dao;

    @GetMapping("/prospect-display")
    public List<ProspectDisplayDTO> getProspectDisplayList(@RequestBody String jobStatus) {
        return dao.getProspectDisplayList(jobStatus);
    }

}
