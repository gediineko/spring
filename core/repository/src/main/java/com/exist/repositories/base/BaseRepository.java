package com.exist.repositories.base;

import com.exist.model.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Serializable>
        extends JpaRepository<T, ID>,
        CrudRepository<T, ID> {
}
