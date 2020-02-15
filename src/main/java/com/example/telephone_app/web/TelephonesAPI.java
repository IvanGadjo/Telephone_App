package com.example.telephone_app.web;

import com.example.telephone_app.service.TelephonesService;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/telephones", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
public class TelephonesAPI {

    TelephonesService telephonesService;

    public TelephonesAPI(TelephonesService telephonesService){
        this.telephonesService = telephonesService;
    }

    @GetMapping
    public List<Integer> getAllTelephones(){
        return telephonesService.getAllTelephones();
    }

    @GetMapping("/mobile/{id}")
    public List<Integer> getAllMobilePhonesOfUser(@PathVariable("id") String username){
        return telephonesService.getAllMobilePhonesOfUser(username);
    }

    @GetMapping("/home/{id}")
    public List<Integer> getAllHomePhonesOfUser(@PathVariable("id") String username){
        return telephonesService.getAllHomePhonesOfUser(username);
    }

//    @PostMapping("/{id}")
//    public void addMultipleTelephonesToUser(@PathVariable("id") String username,
//                                            @RequestParam("telephones") List<Integer> telephones){
//        System.out.println(username);
//        System.out.println(telephones.get(0)+""+telephones.get(1));
//        telephonesService.addMultipleTelephonesToUser(username,telephones);
//    }

//    @PostMapping("/{id}")
//    public void addMultipleTelephonesToUser(@PathVariable("id") String username,
//                                            @RequestParam("telephone1") int telephone1,
//                                            @RequestParam("telephone2") int telephone2,
//                                            @RequestParam("telephone3") int telephone3,
//                                            @RequestParam("telephone4") int telephone4,
//                                            @RequestParam("telephone5") int telephone5){
//        List<Integer> telephones = new ArrayList<>();
//        telephones.add(telephone1);
//        telephones.add(telephone2);
//        telephones.add(telephone3);
//        telephones.add(telephone4);
//        telephones.add(telephone5);
//
//        telephonesService.addMultipleTelephonesToUser(username,telephones);
//    }

    @PostMapping("/{id}")
    public void addMultipleTelephonesToUser(@PathVariable("id") String username,
                                            @RequestParam("telephone1") String telephone1,
                                            @RequestParam("telephone2") String telephone2,
                                            @RequestParam("telephone3") String telephone3,
                                            @RequestParam("telephone4") String telephone4,
                                            @RequestParam("telephone5") String telephone5){

        List<Integer> telephones = new ArrayList<>();

        if(!telephone1.equals("")) {
            int t1 = Integer.parseInt(telephone1);
            telephones.add(t1);
        }
        if(!telephone2.equals("")) {
            int t2 = Integer.parseInt(telephone2);
            telephones.add(t2);
        }
        if(!telephone3.equals("")) {
            int t3 = Integer.parseInt(telephone3);
            telephones.add(t3);
        }
        if(!telephone4.equals("")) {
            int t4 = Integer.parseInt(telephone4);
            telephones.add(t4);
        }
        if(!telephone5.equals("")) {
            int t5 = Integer.parseInt(telephone5);
            telephones.add(t5);
        }

        if(!telephones.isEmpty())
            telephonesService.addMultipleTelephonesToUser(username,telephones);
    }
}
