package e.com.paging3.repository

class Repository(var remoteSource: RemoteSource) {
    suspend fun requestAPI(position: Int) =
        remoteSource.requestAPI(position)

}