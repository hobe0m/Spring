package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Member2 extends Base{
    @Id
    private Long seq;

    @Column
    private String subject;

    @Column
    private String content;

}
