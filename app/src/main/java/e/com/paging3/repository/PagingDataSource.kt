package e.com.paging3.repository

import androidx.paging.PagingSource
import e.com.paging3.model.Hit
import e.com.paging3.repository.Repository
import retrofit2.HttpException
import java.io.IOException

class PagingDataSource(var repository: Repository) : PagingSource<Int, Hit>() {
    private val initialPageIndex: Int = 1
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hit> {
        val position = params.key ?: initialPageIndex
        return try {
            val response = repository.requestAPI(position)
            val resultantItems = response?.hits ?: emptyList()
            LoadResult.Page(
                data = resultantItems,
                prevKey = if (position == initialPageIndex) null else position - 1,
                nextKey = if (resultantItems.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}

