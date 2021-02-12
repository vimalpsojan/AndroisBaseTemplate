import androidx.recyclerview.widget.RecyclerView

abstract class AdvancedRecyclerViewAdapter<T, V : RecyclerView.ViewHolder> : RecyclerView.Adapter<V>() {

    var data: ArrayList<T>? = null

    internal var emptyCallBack: EmptyCallBack? = null

    override fun getItemCount(): Int {
        if (data.isNullOrEmpty()) {
            emptyCallBack?.isEmpty(true)
        } else {
            emptyCallBack?.isEmpty(false)
        }
        return data?.size ?: 0
    }

    /**
     * Adds a single Item to data set
     * @param item item to be added to the data set
     */
    open fun addItem(item: T) {

        if (data == null) {
            data = ArrayList()
        }
        data?.add(item)
        emptyCallBack?.onNewData()
        notifyDataSetChanged()
    }

    /**
     * Set data set
     * @param data data to be set
     */
    open fun setItems(data: List<T>?) {
        this.data?.clear()
        if (data != null) {
            this.data = ArrayList(data)
        }
        emptyCallBack?.onNewData()
        notifyDataSetChanged()
    }

    /**
     * Set data set
     * @param data data to be set
     */
    open fun setItems(data: ArrayList<T>?) {

        this.data?.clear()
        this.data = data
        emptyCallBack?.onNewData()
        notifyDataSetChanged()
    }

    /**
     * Appends data to existing data set
     *
     * @param data dato to be append
     */
    open fun addAll(data: ArrayList<T>) {

        if (this.data == null) {
            setItems(data)
        } else {
            this.data?.addAll(data)
        }
        emptyCallBack?.onNewData()
        notifyDataSetChanged()
    }

    /**
     * Appends data to existing data set
     *
     * @param data dato to be append
     */
    open fun addAll(data: List<T>) {

        if (this.data == null) {
            setItems(ArrayList(data))
        } else {
            this.data?.addAll(data)
        }
        emptyCallBack?.onNewData()
        notifyDataSetChanged()
    }

    /**
     * Clear all data in recyclerview
     */

    open fun clearData() {
        data?.clear()
        data = null
        notifyDataSetChanged()
    }

    interface EmptyCallBack {
        fun isEmpty(isEmpty: Boolean)
        fun onNewData()
    }
}