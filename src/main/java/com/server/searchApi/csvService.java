package com.server.searchApi;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class csvService {

    public Optional<String> readFile(String name) throws IOException, CsvException {
        String path = "static/store_info.csv";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
        CSVReader reader = new CSVReader(new InputStreamReader(inputStream));

        List<String[]> csvData = reader.readAll();

        csvData.remove(0);

        for (String[] row : csvData) {
            if (row.length > 0 && row[2].contains(name)) {
                return Optional.ofNullable(row.length > 2 ? row[7] : null);
            }
        }

        return Optional.empty();
    }
}
