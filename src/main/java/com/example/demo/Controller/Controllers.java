package com.example.demo.Controller;

import com.example.demo.Model.Cakes;
import com.example.demo.repository.MySqlEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/cakes")
public class Controllers {
    @Autowired
    MySqlEntry mySqlEntry;

    @GetMapping("/getInfo")
    public List<Cakes> info(){
        return mySqlEntry.findAll();
    }

    @GetMapping("/test")
    public String test(){
        return "Hello there";
    }

    @GetMapping("/getInfo/{id}")
    public Cakes getSingleInfo(@PathVariable("id") Integer id){
        return mySqlEntry.findById(id).get();
    }

    @DeleteMapping("/remove/{id}")
    public boolean deleteRow(@PathVariable("id") Integer id){
        if (!mySqlEntry.findById(id).equals(Optional.empty())){
            mySqlEntry.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update/{id}")
    public Cakes update(@PathVariable("id") Integer id, @RequestBody Map<String, String> body){
        Cakes current = mySqlEntry.findById(id).get();
        current.setName(body.get("name"));
        current.setFlavour(body.get("flavour"));
        current.setPrice(Integer.parseInt(body.get("price")));
        mySqlEntry.save(current);
        return current;

    }

    @PostMapping("/addCake")
    public Cakes addCake(@RequestBody Map<String, String> body){
        String name = body.get("name");
        String flavour = body.get("flavour");
        Integer price = Integer.parseInt(body.get("price"));
        Cakes cakeEntry = new Cakes(name, flavour, price);
        return mySqlEntry.save(cakeEntry);
    }

    @GetMapping("/search")
    public List<Cakes> searchCakes(@RequestParam String flavour) {
        return mySqlEntry.findByFlavourContainingIgnoreCase(flavour);
    }

    @PostMapping("/addMultipleCakes")
    public List<Cakes> addCakes(@RequestBody List<Cakes> cakes) {
        return mySqlEntry.saveAll(cakes);
    }
}
