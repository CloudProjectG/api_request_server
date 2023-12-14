package com.server.searchApi;

import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class apiController {

    private final apiClient apiClient;
    private final csvService csvService;

    @GetMapping("/api/naver/search")
    @ResponseBody
    public SearchRes searchStore(@RequestParam String query) throws IOException, CsvException
    {
        SearchRes result = apiClient.search(query);
        Optional<String> category = csvService.readFile(query);

        if (category.isPresent() && result.getItems() != null) {
            for (SearchRes.StoreInfo storeInfo : result.getItems()) {
                storeInfo.setCategory(category.get());
            }
        }

        return result;
    }
}
