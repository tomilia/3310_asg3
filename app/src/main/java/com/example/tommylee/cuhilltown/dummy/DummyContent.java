package com.example.tommylee.cuhilltown.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();
    public static final List<String> VideoLink = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.

            addItem(createDummyItem(0));
            addItem(createDummyItem(1));
        addItem(createDummyItem(2));
        addItem(createDummyItem(3));
        addItem(createDummyItem(4));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);

    }

    private static String getFilm(int position) {
        switch(position)
        {
            case 0:
                return "Soaring CUHK";
            case 1:
                return "Humble Cottage";
            case 2:
                return "Green Building Awards";
            case 3:
                return "Space and Earth";
            default:
                return "InfraRed Spots";

        }

    }
    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), getFilm(position), makeDetails(position));
    }

    private static String makeDetails(int position) {
        switch(position)
        {
            case 0:
                return "soaring_cuhk";
            case 1:
                return "http://course.cse.cuhk.edu.hk/~csci3310/1819R2/asg3/humble_cottage_cuhk.mp4";
            case 2:
                return "http://course.cse.cuhk.edu.hk/~csci3310/1819R2/asg3/green_bldg_cuhk.mp4";
            case 3:
                return "http://course.cse.cuhk.edu.hk/~csci3310/1819R2/asg3/connecting_space_cuhk.mp4";
            default:
                return "http://course.cse.cuhk.edu.hk/~csci3310/1819R2/asg3/infrared_cuhk.mp4";

        }
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
