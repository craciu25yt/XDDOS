package de.xddosapi.repository;

import de.xddosapi.entity.XddosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IXddos extends JpaRepository<XddosEntity, Long> {
}
