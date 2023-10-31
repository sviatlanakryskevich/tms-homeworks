package com.tms.hibernate.dto;

import com.tms.hibernate.domain.Role;
import com.tms.hibernate.domain.Status;
import com.tms.hibernate.entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSearchDto {
    private LocalDate birthdayFrom;
    private LocalDate birthdayTo;
    private Role role;
    private Status status;

}
