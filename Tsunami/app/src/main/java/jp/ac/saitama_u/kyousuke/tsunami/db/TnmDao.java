package jp.ac.saitama_u.kyousuke.tsunami.db;

import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by usr0200379 on 2014/12/30.
 */
public enum TnmDao {
    INSTANCE;

    /**
     * 現在地の緯度経度から一番近い交差点を探す
     * @param latitude 緯度
     * @param longitude 経度
     * @param threshold 閾値
     * @return
     */
    public List<Intersection> getNearIntegerSectionList(Float latitude,
                                                        Float longitude,
                                                        Float threshold) {
        return new Select()
                .from(Intersection.class)
                .where("latitude < ? + ? " +
                        "and ? - ? < latitude " +
                        "and longitude < ? + ? " +
                        "and ? - ? < longitude",
                        latitude, threshold,
                        latitude, threshold,
                        longitude, threshold,
                        longitude, threshold
                        )
                .execute();
    }


    /**
     * 現在地の標高を求める
     * @param latitude
     * @param longitude
     * @return
     */
    public Elevation getElevation(Float latitude, Float longitude) {
        return new Select()
                .from(Elevation.class)
                .where("position_bottom < ? " +
                        "and ? < position_top " +
                        "and position_left < ? " +
                        "and ? < position_right",
                        latitude,
                        latitude,
                        longitude,
                        longitude
                )
                .executeSingle();
    }
}
