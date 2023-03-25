package com.example.rentacarmain.controller.elasticsearch;

import com.example.rentacarmain.dto.PageableAdvResponse;
import com.example.rentacarmain.entities.elasticsearch.AdvertisementEs;
import com.example.rentacarmain.services.elasticsearch.ElasticsearchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/elasticsearch")
@CrossOrigin(origins = "*")
public record ElasticSearchController(ElasticsearchService service) {


    @GetMapping("/fuzzy")
    public PageableAdvResponse findAdvertisementFuzzy
            (@RequestParam(name = "title") String title,
             @RequestParam(name = "page") int page,
             @RequestParam(name = "count") int count
            ){
        return service.findAdvertisementsFuzzy(title,page,count);
    }


    @GetMapping
    public PageableAdvResponse findAdvertisement
            (@RequestParam(name = "page") int page,
             @RequestParam(name = "count") int count){
        return service.findAdvertisements(page,count);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addAdvertisements(@RequestBody AdvertisementEs advertisementEs){
        service.addAdvertisements(advertisementEs);
    }

    @DeleteMapping
    public void removeAll(){
        service.deleteAll();
    }


}
