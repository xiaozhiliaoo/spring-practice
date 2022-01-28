package org.lili.forfun.spring.training.db.domain;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person extends BaseEntity {
    private String name;
    private String age;
    private String sex;
    private String status;
    private String level;
}
