package com.dev.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.model.common.File;

public interface FileRepository extends JpaRepository<File, String> {

}
