package com.vimal.advancedrecyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import org.jetbrains.annotations.TestOnly

class AdvancedRecyclerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), SwipeRefreshLayout.OnRefreshListener, AdvancedRecyclerViewAdapter.EmptyCallBack {

    private val recyclerView: RecyclerView
    private val textView: TextView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private var listener: ListRefreshListener? = null
    private lateinit var layoutManager: LinearLayoutManager
    private var isSwipeEnabled = false

    var emptyCallBack: EmptyCallBack? = null

    var emptyText: String? = null

    private var isLoading = false

    private val onScrollListener: RecyclerView.OnScrollListener =
        object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (isSwipeEnabled) {
                    swipeRefresh.isEnabled =
                        layoutManager.findFirstCompletelyVisibleItemPosition() == 0
                }
            }
        }

    var adapter: AdvancedRecyclerViewAdapter<*, *>? = null
        set(value) {
            field = value
            if (value != null) {
                value.emptyCallBack = this
            }
            recyclerView.adapter = value
        }

    companion object {
        @JvmStatic
        private val TAG: String = AdvancedRecyclerView::class.java.simpleName
    }

    init {
        swipeRefresh = LayoutInflater.from(context).inflate(
            R.layout.advanced_recycler_view_layout,
            this,
            false
        ) as SwipeRefreshLayout
        addView(swipeRefresh)
        recyclerView =
            swipeRefresh.findViewById<View>(R.id.list_loading_recyclerview) as RecyclerView
        recyclerView.addOnScrollListener(onScrollListener)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        textView = swipeRefresh.findViewById<View>(R.id.list_loading_text) as TextView
        swipeRefresh.setOnRefreshListener(this)
    }

    fun showLoading() {
        isLoading = true
        swipeRefresh.isRefreshing = true
        recyclerView.visibility = GONE
        textView.visibility = GONE
    }

    fun hideLoading() {
        isLoading = false
        swipeRefresh.isRefreshing = false

        if ((adapter?.data?.size ?: 0) > 0) {
            recyclerView.visibility = VISIBLE
            textView.visibility = GONE
        } else {
            recyclerView.visibility = GONE
            textView.visibility = VISIBLE
        }
    }

    fun showError(text: String?) {
        showText(text)
    }

    override fun onRefresh() {
        isLoading = true
        listener?.onRefresh()
    }

    private fun showText(text: String?) {
        recyclerView.visibility = GONE
        textView.visibility = VISIBLE
        textView.text = text
        isLoading = false
        swipeRefresh.isRefreshing = false
    }

    private fun showList() {
        recyclerView.visibility = VISIBLE
        swipeRefresh.isRefreshing = false
        isLoading = false
        textView.visibility = GONE
    }

    override fun isEmpty(isEmpty: Boolean) {
        if (emptyCallBack?.isEmpty(isEmpty) == true)
            return
        if (isEmpty) {
            showText(emptyText)
        } else {
            showList()
        }

    }

    override fun onNewData() {
        if (emptyCallBack?.onNewData() == true)
            return
        recyclerView.visibility = View.VISIBLE
    }

    fun setListRefreshListener(listRefreshListener: ListRefreshListener) {
        listener = listRefreshListener
    }

    interface ListRefreshListener {
        fun onRefresh()
    }

    @TestOnly
    fun getRecyclerView(): RecyclerView {
        return recyclerView
    }

    interface EmptyCallBack {
        /**
         * return true if handled
         */
        fun isEmpty(isEmpty: Boolean): Boolean

        /**
         * return true if handled
         */
        fun onNewData(): Boolean
    }
}