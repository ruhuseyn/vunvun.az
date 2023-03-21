package com.example.rentacarmain.controller.elasticsearch;

import com.example.rentacarmain.dto.AllAdvResponse;
import com.example.rentacarmain.dto.PageableAdvResponse;
import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import com.example.rentacarmain.services.elasticsearch.ServiceES;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/elasticsearch")
@CrossOrigin("*")
public class ElasticSearchController {
    private final ServiceES serviceES;

    @GetMapping("/fuzzy")
    public PageableAdvResponse findAdvertisementFuzzy
            (@RequestParam(name = "title") String title,
             @RequestParam(name = "page") int page,
             @RequestParam(name = "count") int count
            ){
        return serviceES.findAdvertisementsFuzzy(title,page,count);
    }


    @GetMapping
    public PageableAdvResponse findAdvertisement
            (@RequestParam(name = "page") int page,
             @RequestParam(name = "count") int count){
        return serviceES.findAdvertisements(page,count);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addAdvertisements(@RequestBody AdvertisementEs advertisementEs){
        serviceES.addAdvertisements(advertisementEs);
    }

    @DeleteMapping
    public void removeAll(){
        serviceES.deleteAll();
    }


}
