package com.beginners.sim.repair.controller;

import com.beginners.sim.repair.model.Return;
import com.beginners.sim.repair.service.ReturnService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/returns")
@RequiredArgsConstructor
@Slf4j
public class ReturnController {
    // Todo
    //  Create util package, class Constant, hardcode values
    //  Crete base url, create a method with pagination for getAll

    private ReturnService returnService;

    @GetMapping
    public List<Return> getAllReturns() {
        return returnService.getAllReturns();
    }

    @GetMapping("/{id}")
    public Return getReturnById(@PathVariable int id) {
        return returnService.getReturnById(id);
    }


    @PostMapping
    public Return addReturn(@RequestBody Return returnObj) {
        return returnService.addReturn(returnObj);
    }

    @PutMapping("/{id}")
    public Return updateReturn(@PathVariable int id, @RequestBody Return returnObj) {
        return returnService.updateReturn(id, returnObj);
    }

    @DeleteMapping("/{id}")
    public void deleteReturn(@PathVariable int id) {
        returnService.deleteReturn(id);
    }
}
