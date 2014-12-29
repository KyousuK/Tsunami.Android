package jp.ac.saitama_u.kyousuke.tsunami.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by usr0200379 on 2014/12/30.
 */
@Table(name = "Elevation")
public class Elevation extends Model {
    @Column(name = "Id", notNull = true)
    public Integer id;

    @Column(name = "Value", index = true)
    public Integer value;

    @Column(name = "Position_top", index = true)
    public Float position_top;

    @Column(name = "Position_left", index = true)
    public Float position_left;

    @Column(name = "Position_bottom", index = true)
    public Float position_bottom;

    @Column(name = "Position_right", index = true)
    public Float position_right;

    public Elevation() {
        super();
    }
}
