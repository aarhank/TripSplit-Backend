package com.aarhankhan.splitwise.model;

import com.aarhankhan.splitwise.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinalSplitModel {
    private Long finalPayTo;
    private Long finalPayBy;
    private Float finalAmt;
    private Group finalSplitGrp;
}
