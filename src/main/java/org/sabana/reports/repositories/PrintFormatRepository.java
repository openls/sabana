package org.sabana.reports.repositories;

import org.sabana.reports.entities.PrintFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintFormatRepository extends JpaRepository<PrintFormat, Long> {
    
}
