package th.ac.su.jirakit.foodlovers.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.list_item_food.view.*
import kotlinx.android.synthetic.main.list_item_food.view.imgPin
import th.ac.su.jirakit.foodlovers.R

class FoodAdapter(private val context: Context,
                        private val dataSource:ArrayList<Food>) : BaseAdapter() {

    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.list_item_food,null)

        rowView.tvTitle.text = dataSource[position].foodloversName
        rowView.tvSubtitle.text = dataSource[position].caption
        rowView.tvDetail.text = dataSource[position].price

        val res = context.resources
        val drawableIdpin: Int = res.getIdentifier(dataSource[position].imagePin,"drawable",context.packageName)
        val drawableId: Int = res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)
        val drawableIdsub: Int = res.getIdentifier(dataSource[position].imageStart,"drawable",context.packageName)

        rowView.imgThumbnail.setImageResource(drawableId)
        rowView.imgStart.setImageResource(drawableIdsub)
        rowView.imgPin.setImageResource(drawableIdpin)

        return rowView
    }
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getCount(): Int {
        return dataSource.size
    }
}