package com.aarhankhan.splitwise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="finalsplit")
public class FinalSplit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long finalPayTo;
    private Long finalPayBy;
    private Float finalAmt;

    @ManyToOne
    @JoinColumn(name = "split_list")
    private Group finalSplitGrp;

}
