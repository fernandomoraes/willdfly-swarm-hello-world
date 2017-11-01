package com.moraes;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STATUS_CHECK")
public class StatusCheck {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, updatable = false)
    private Status status;

    @Column(name = "CHECKED_IN", nullable = false, updatable = false)
    private LocalDateTime in;


    protected StatusCheck() {
    }

    private StatusCheck(final Status status, final LocalDateTime in) {
        this.status = status;
        this.in = in;
    }

    static StatusCheck now(final Status status) {
        return new StatusCheck(status, LocalDateTime.now());
    }

    enum Status {
        OK
    }

}
