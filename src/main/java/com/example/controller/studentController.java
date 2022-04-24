package com.example.controller;

import com.example.model.Countplates;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class studentController {

    @Autowired
    private TimeService timeService;

    @Autowired
    private InstructionService instructionService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private Countplateservice countplateservice;

    @Autowired
    private RateService rateService;

    @GetMapping("/getMesstime")
    public ResponseEntity<?> getMesstime(){
        return ResponseEntity.ok(timeService.fetchTime());
    }

    @GetMapping("/getInstruction")
    public ResponseEntity<?> getInstruction(){
        return ResponseEntity.ok(instructionService.fetchInstruction());
    }

    @GetMapping("/getTodaymenu")
    public ResponseEntity<?> getTodaymenu(){
        return ResponseEntity.ok(menuService.fetchTodaymenu());
    }

    @GetMapping("/getmenu/{day}")
    public ResponseEntity<?> getMenubyday(@PathVariable("day") String day){
        return ResponseEntity.ok(menuService.getMenubyday(day));
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistory(){
        return ResponseEntity.ok(countplateservice.getPlatehistory());
    }

//    requestmapping used when we r sending more than 1 column hv to save
    @PostMapping("/postplatecount")
    public ResponseEntity<?> postPlatecount(@RequestBody Countplates countplates){
        return ResponseEntity.ok(countplateservice.postPlate(countplates));
    }
    @PostMapping("/postrating")
    public ResponseEntity<?> postuserRating(@RequestBody Countplates countplates){
        return ResponseEntity.ok(rateService.postRating(countplates));
    }
}