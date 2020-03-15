package th.ac.su.jirakit.foodlovers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.jirakit.foodlovers.Utils.getJsonDataFromAsset
import th.ac.su.jirakit.foodlovers.data.Food
import th.ac.su.jirakit.foodlovers.data.FoodAdapter

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<Food> = ArrayList<Food>()
    lateinit var arrayAdapter: ArrayAdapter<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"foodlovers_data.json")

        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Food>>(){}.type

        var foodloversList : ArrayList<Food> = gson.fromJson(jsonFileString,listItemType)

        itemList = foodloversList

        val adapter = FoodAdapter(this@MainActivity,itemList)

        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->

            var intent = Intent(this@MainActivity,DetailActivity::class.java)

            intent.putExtra("title",itemList[position].foodloversName)
            intent.putExtra("caption",itemList[position].caption)
            intent.putExtra("imageFile",itemList[position].imageFile)
            intent.putExtra("description",itemList[position].description)
            intent.putExtra("imageStart",itemList[position].imageStart)

            startActivity(intent)
        }
    }
}