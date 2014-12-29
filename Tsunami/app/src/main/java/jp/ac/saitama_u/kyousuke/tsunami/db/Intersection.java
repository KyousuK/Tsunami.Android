package jp.ac.saitama_u.kyousuke.tsunami.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by usr0200379 on 2014/12/30.
 */
@Table(name = "Intersection")
public class Intersection extends Model {

    @Column(name = "Id", notNull = true)
    public Integer id;

    @Column(name = "Latitude", index = true)
    public Float latitude;

    @Column(name = "Longitude", index = true)
    public Float longitude;

    public Intersection() {
        super();
    }
}
