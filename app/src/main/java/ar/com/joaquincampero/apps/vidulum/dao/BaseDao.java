package ar.com.joaquincampero.apps.vidulum.dao;

import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by Joaquin Campero
 * on 2/3/19.
 */
public interface BaseDao<T> {

    void insert(T entity);

    void deleteAll();

    LiveData<List<T>> getAll();

}
