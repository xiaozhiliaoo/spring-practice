package org.lili.forfun.spring.traning.db.domain;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseEntity {
    private String name;
    private Long personId;
    private Integer open;
    private String teacher;
}
