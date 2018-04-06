package br.com.trmamobilesolutions.androiddevelopersblog.data.home

import br.com.trmamobilesolutions.androiddevelopersblog.data.dao.PostsDao
import br.com.trmamobilesolutions.androiddevelopersblog.domain.home.HomeLocalRepository
import io.reactivex.Flowable
import kotlinx.coroutines.experimental.Job

/**
 * Created by tairo on 1/6/18 10:58 PM.
 */
class HomeLocalDataStore(private val postsDao: PostsDao) : HomeLocalRepository {
    override fun add(job: Job): Long {
        return postsDao.add(job)
    }

    override fun addAll(jobs: List<Job>?) {
        postsDao.addAll(jobs)
    }

    override fun update(job: Job) {
        postsDao.update(job)
    }

    override fun delete(job: Job) {
        postsDao.delete(job)
    }

    override fun deleteAll() {
        postsDao.deleteAll()
    }

    override fun getAll(): Flowable<List<Job>> {
        return postsDao.getAll()
    }

    override fun getByID(id: Int): Flowable<Job> {
        return postsDao.getByID(id)
    }
}