package com.aarhankhan.splitwise.controller;

import com.aarhankhan.splitwise.entity.FinalSplit;
import com.aarhankhan.splitwise.model.FinalSplitModel;
import com.aarhankhan.splitwise.service.FinalSplitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/FinalSplit")
@CrossOrigin(origins = "*")
public class FinalSplitController {
    @Autowired
    private FinalSplitService finalSplitService;

    @GetMapping("/{id}")
    public List<FinalSplitModel> getFinalSplit(@PathVariable("id") Long groupID){
        return finalSplitService.getFinalSplit(groupID);
    }


}
