package br.com.trmamobilesolutions.androiddevelopersblog.data.home

import br.com.trmamobilesolutions.androiddevelopersblog.domain.home.HomeRemoteRepository
import br.com.trmamobilesolutions.androiddevelopersblog.domain.services.network.RemoteApiService
import io.reactivex.Single

/**
 * Created by tairo on 1/6/18 11:03 PM.
 */
class HomeRemoteDataStore : HomeRemoteRepository {
    override fun listAll(): Single<JobsResponse> {
        return search("remote-jobs")
    }

    override fun search(query: String): Single<JobsResponse> {
        return RemoteApiService.getInstance().getApiService().search(query)
    }
}