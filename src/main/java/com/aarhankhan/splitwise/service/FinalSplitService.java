package com.aarhankhan.splitwise.service;

import com.aarhankhan.splitwise.entity.FinalSplit;
import com.aarhankhan.splitwise.model.FinalSplitModel;

import java.util.List;

public interface FinalSplitService {
    List<FinalSplitModel> getFinalSplit(Long groupId);
}
