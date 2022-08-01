package com.port.accident.portaccident.dto.staff;

import com.port.accident.portaccident.domain.staff.Staff;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class StaffDto {
    private String name;
    private String corporation;
    private String group;
    private String position;
    private String email;
    private String phoneNumber;

    @Builder
    public StaffDto(String name, String corporation, String group, String position, String email, String phoneNumber) {
        this.name = name;
        this.corporation = corporation;
        this.group = group;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Staff toEntity() {
        return Staff.builder()
                .name(name)
                .corporation(corporation)
                .group(group)
                .position(position)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
