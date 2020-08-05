package e.com.paging3.base

import androidx.paging.PagingSource

abstract class PagingData<T : Any> : PagingSource<Int, T>()