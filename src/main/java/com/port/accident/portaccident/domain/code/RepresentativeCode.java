package com.port.accident.portaccident.domain.code;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.port.accident.portaccident.dto.code.RepresentativeCodeDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "representative_code")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RepresentativeCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "representative_code_id")
    private Integer id;

    //대표코드번호
    @Column(name = "representative_code")
    private String code;

    //대표코드명
    @Column(name = "representative_code_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "representativeCode")
    private List<DetailedCode> detailedCode = new ArrayList<>();

    @Builder
    public RepresentativeCode(Integer id, String name, String code, List<DetailedCode> detailedCode) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.detailedCode = detailedCode;
    }

    public RepresentativeCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public void setDetailedCode(DetailedCode code) {
        detailedCode.add(code);
    }

    public void removeDetailedCode(DetailedCode code) {
        detailedCode.remove(code);
    }

    public void setName(String name) {
        this.name = name;
    }
}
