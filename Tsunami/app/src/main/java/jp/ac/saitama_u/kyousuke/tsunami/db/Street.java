package jp.ac.saitama_u.kyousuke.tsunami.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by usr0200379 on 2014/12/30.
 */
@Table(name = "Street")
public class Street extends Model {
    @Column(name = "Id", notNull = true)
    public Integer id;

    @Column(name = "Distance")
    public Float distance;

    @Column(name = "Intersec_id_1")
    public Integer intersec_id_1;

    @Column(name = "Intersec_id_2")
    public Integer intersec_id_2;

    public Street() {
        super();
    }
}
