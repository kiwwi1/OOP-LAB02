package lab002.aimsproject.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        return 0;
    }

    @Override
    public Comparator<Media> thenComparing(Comparator<? super Media> other) {
        return Comparator.super.thenComparing(other);
    }
}
