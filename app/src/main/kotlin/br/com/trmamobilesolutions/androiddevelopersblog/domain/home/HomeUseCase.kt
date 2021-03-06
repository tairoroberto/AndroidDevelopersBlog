package br.com.trmamobilesolutions.androiddevelopersblog.domain.home

import com.remoteok.io.app.model.Job
import com.remoteok.io.app.model.JobsResponse
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by tairo on 12/11/17.
 */
class HomeUseCase(private val homeLocalRepository: HomeLocalRepository,
                  private val homeRemoteRepository: HomeRemoteRepository) {

    fun listAllJobs(): Single<JobsResponse> {
        return homeRemoteRepository.listAll()
    }

    fun searchJobs(query: String): Single<JobsResponse> {
        return homeRemoteRepository.search(query)
    }

    fun listJobsFromBD(): Flowable<List<Job>> {
        return homeLocalRepository.getAll()
    }

    fun addAllJobs(jobs: List<Job>?) {
        homeLocalRepository.addAll(jobs)
    }

    fun deleteAllJobs() {
        homeLocalRepository.deleteAll()
    }
}
