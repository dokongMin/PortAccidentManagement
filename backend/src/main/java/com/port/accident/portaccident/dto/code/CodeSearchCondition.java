package com.port.accident.portaccident.dto.code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeSearchCondition {
    private String code;
    private String name;
}
