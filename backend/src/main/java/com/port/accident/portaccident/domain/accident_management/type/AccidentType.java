package com.port.accident.portaccident.domain.accident_management.type;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "accident_type")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccidentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_type_id")
    private Integer id;

    @Column(name = "accident_type_name")
    private String name;


    @OneToMany(mappedBy = "accidentType")
    private List<AccidentInfo> accidentInfoList = new ArrayList<>();

    @Builder
    public AccidentType(Integer id, String name, List<AccidentInfo> accidentInfoList) {
        this.id = id;
        this.name = name;
        this.accidentInfoList = accidentInfoList;
    }
}
