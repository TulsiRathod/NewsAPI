package com.kaltak.Rapid24.controller;

import com.kaltak.Rapid24.Entity.NewsEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/news")
public class NewsEntryController {

    private Map<Long, NewsEntry> newsEntries=new HashMap<>();
    @GetMapping
    public List<NewsEntry> getALl(){
        return new ArrayList<>(newsEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody NewsEntry newNews){
        newsEntries.put(newNews.getId(), newNews);
        return true;
    }

    @GetMapping("id/{myID}")
    public NewsEntry getNeweById(@PathVariable Long myID){
        return newsEntries.get(myID);
    }

    @DeleteMapping("id/{myID}")
    public NewsEntry deleteNeweById(@PathVariable Long myID){
        return newsEntries.remove(myID);
    }

    @PutMapping("id/{id}")
    public NewsEntry updateNewsById(@PathVariable Long id, @RequestBody NewsEntry myNews){
        return newsEntries.put(id,myNews);
    }
}
