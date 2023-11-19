package com.server.searchApi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRes {

//    private String lastBuildDate;
//    private int total;
//    private int start;
//    private int display;
    private List<StoreInfo> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreInfo {
        private String title;
        private String category;
        private String roadAddress;
        private int mapx;
        private int mapy;
    }
}
