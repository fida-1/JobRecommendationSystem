package org.example.repository;

import org.example.entity.CsvReader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsvReaderRepository extends JpaRepository<CsvReader, Long> {
}
