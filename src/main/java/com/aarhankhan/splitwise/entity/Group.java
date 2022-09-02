package com.aarhankhan.splitwise.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="`group`")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;
    private Long groupBudget;
    private String groupType;

    @OneToMany(mappedBy = "finalSplitGrp")
    @JsonIgnore
    private List<FinalSplit> finalSplits;

    @OneToMany(mappedBy = "expGrp")
    @JsonIgnore
    private  List<Expense> expenses;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "group_users",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "`group_id`")})
    @JsonIgnore
    private List<User> groupUsers;
}
