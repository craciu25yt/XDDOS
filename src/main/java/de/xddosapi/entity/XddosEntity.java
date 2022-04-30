package de.xddosapi.entity;

import de.xddosapi.utils.enums.Methods;
import de.xddosapi.utils.enums.Protocol;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class XddosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Methods method;
    private Protocol protocol;
    private boolean isRunning;

    public XddosEntity() {
    }

    public XddosEntity(final Methods method, final Protocol protocol) {
        this.method = method;
        this.protocol = protocol;
    }
}
