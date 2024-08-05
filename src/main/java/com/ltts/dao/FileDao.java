package com.ltts.dao;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.ltts.model.FileDB;


public interface FileDao {
	public FileDB store(MultipartFile file) throws IOException;

	public FileDB getFile(String id);

	public Stream<FileDB> getAllFiles();
}
