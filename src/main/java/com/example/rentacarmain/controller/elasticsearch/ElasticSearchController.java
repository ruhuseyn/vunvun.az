package com.example.rentacarmain.controller.elasticsearch;

import com.example.rentacarmain.dto.FindAdvRequest;
import com.example.rentacarmain.dto.PageableAdvResponse;
import com.example.rentacarmain.services.elasticsearch.ElasticsearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            (@RequestParam(name = "brand_id",required = false) Long brandId,
             @RequestParam(name = "location_id",required = false) Long locationId,
             @RequestParam(name = "model_id",required = false) Long modelId,
             @RequestParam(name = "page") int page,
             @RequestParam(name = "count") int count){

            return service.findAdvertisements(new FindAdvRequest(brandId, locationId, modelId),page,count);
    }

    @DeleteMapping
    public void removeAll(){
        service.deleteAll();
    }


}
