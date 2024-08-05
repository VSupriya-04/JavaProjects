package com.ltts.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltts.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
