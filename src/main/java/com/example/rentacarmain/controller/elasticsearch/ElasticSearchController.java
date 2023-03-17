package com.example.rentacarmain.controller.elasticsearch;

import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import com.example.rentacarmain.services.elasticsearch.ServiceES;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/elasticsearch")
public class ElasticSearchController {
    private final ServiceES serviceES;


    @GetMapping
    public List<AdvertisementEs> findAdvertisement
            (@RequestParam(name = "title") String title,@RequestParam(name = "pageSize") int pageSize){
        return serviceES.findAdvertisements(title,pageSize);
    }

    @PostMapping
    public void addAdvertisements(@RequestBody AdvertisementEs advertisementEs){
        serviceES.addAdvetisements(advertisementEs);
    }


}
