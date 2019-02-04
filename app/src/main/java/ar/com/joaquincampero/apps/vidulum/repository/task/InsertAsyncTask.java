package ar.com.joaquincampero.apps.vidulum.repository.task;

import android.os.AsyncTask;

import javax.inject.Inject;

import ar.com.joaquincampero.apps.vidulum.dao.BaseDao;

/**
 * Created by Joaquin Campero
 * on 2/3/19.
 */
public class InsertAsyncTask<T> extends AsyncTask<T, Void, Void> {

    private BaseDao<T> mAsyncTaskDao;

    @Inject
    public InsertAsyncTask(BaseDao<T> dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(T... ts) {
        mAsyncTaskDao.insert(ts[0]);
        return null;
    }
}
