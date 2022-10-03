package com.port.accident.portaccident.domain.accident_management.type;

import com.port.accident.portaccident.domain.accident_management.AccidentInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "disaster_type")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DisasterType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disaster_type_id")
    private Integer id;

    @Column(name = "disaster_type_name")
    private String name;


    @OneToMany(mappedBy = "disasterType")
    private List<AccidentInfo> accidentInfoList = new ArrayList<>();

    @Builder
    public DisasterType(Integer id, String name, List<AccidentInfo> accidentInfoList) {
        this.id = id;
        this.name = name;
        this.accidentInfoList = accidentInfoList;
    }


}
