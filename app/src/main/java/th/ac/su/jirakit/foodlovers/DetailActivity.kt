package th.ac.su.jirakit.foodlovers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val caption = intent.getStringExtra("caption")
        val description = intent.getStringExtra("description")
        val imageFile = intent.getStringExtra("imageFile")
        val imageStart = intent.getStringExtra("imageStart")

        tvMain.setText(title)
        tvCaption.setText(caption)
        tvDescription.setText(description)

        val res = resources
        val drawableId:Int =
            res.getIdentifier(imageFile,"drawable",packageName)
        val drawableIdsub: Int = res.getIdentifier(imageStart,"drawable",packageName)

        imgView.setImageResource(drawableId)
        imgRate.setImageResource(drawableIdsub)

    }
}
