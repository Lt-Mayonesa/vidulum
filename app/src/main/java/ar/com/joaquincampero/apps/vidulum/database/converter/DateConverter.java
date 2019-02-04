package ar.com.joaquincampero.apps.vidulum.database.converter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by Joaquin Campero
 * on 2/3/19.
 */
public class DateConverter {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }

}
