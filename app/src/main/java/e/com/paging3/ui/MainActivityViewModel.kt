package e.com.paging3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import e.com.paging3.repository.PagingDataSource
import e.com.paging3.network.NetworkCalls
import e.com.paging3.repository.RemoteSource
import e.com.paging3.repository.Repository

class MainActivityViewModel : ViewModel() {

    var repository: Repository
    var remoteSource: RemoteSource
    var networkCalls: NetworkCalls = NetworkCalls()
    var pagingSource: PagingDataSource

    init {
        remoteSource = RemoteSource(networkCalls)
        repository = Repository(remoteSource)
        pagingSource = PagingDataSource(repository)
    }

    val apiData =
        Pager(
            PagingConfig(pageSize = 30),
            pagingSourceFactory = { pagingSource }
        ).flow.cachedIn(viewModelScope)

}