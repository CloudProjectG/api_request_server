package com.server.searchApi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class apiController {

    private final apiClient apiClient;

    @GetMapping("/api/naver/search")
    @ResponseBody
    public SearchRes searchStore(@RequestParam String query) {
        return apiClient.search(query);
    }
}
