package org.sabana.reports.logics;

import org.sabana.reports.entities.PrintFormat;
import org.sabana.reports.repositories.PrintFormatRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class PrintFormatHelper {
    private final PrintFormatRepository repository;

    public PrintFormatHelper(PrintFormatRepository repository) {
        this.repository = repository;
    }

    public void deleteReport(Long id) {
        repository.deleteById(id);
    }

    public List<PrintFormat> getReports() {
        return repository.findAll();
    }

    public PrintFormat getReport(Long id) {
        Optional<PrintFormat> report = repository.findById(id);
        if(report.isPresent()) {
            return report.get();
        } else {
            throw new RuntimeException("Report not found");
        }
    }
}
