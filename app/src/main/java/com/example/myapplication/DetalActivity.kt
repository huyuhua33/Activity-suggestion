package com.example.myapplication


import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail.*
import java.net.URL
import kotlin.concurrent.thread


class DetalActivity : AppCompatActivity() {
    override fun onCreate(savedInstantstate: Bundle?) {
        super.onCreate(savedInstantstate)
        setContentView(R.layout.detail)


        thread(start = true) {
            val intent = getIntent()
            val Slist = listOf<String>(
                "Activity_Name",
                "Type",
                "Picture",
                "Activity_url",
                "Activity_StartTime",
                "Activity_EndTime",
                "StartDate",
                "EndtDate",
                "north",
                "south",
                "City",
                "FullAddr",
                "Book_url",
                "Book_StartTime",
                "Book_EndTime",
                "Price"
            )

            var data = mutableMapOf<String, String>()
            for (str in Slist) {
                data.set(str, intent.getStringExtra(str))
            }
            System.out.println(data)
            textView.text = data["Activity_Name"]
            // ac_url.text = data["Activity_url"]
            val url = URL(data["Picture"])
            val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            runOnUiThread {
                imageView.setImageBitmap(bmp)
                addr.text = "活動地址\n" + data["FullAddr"]
                time.text =
                    time.text.toString() + data["Activity_StartTime"] + " 至 " + data["Activity_EndTime"]
                if (data["StartDate"] == (data["EndDate"])) {
                    date.text = date.text.toString() + data["StartDate"]
                } else {
                    date.text = date.text.toString() + data["StartDate"] + " 至 " + data["EndtDate"]
                }
                book_time.text =
                    "訂票日期： 自 " + data["Book_StartTime"] + "\n　　　　　 至 " + data["Book_EndTime"]
                Price.text = Price.text.toString() + data["Price"]
            }
            book_url.setOnClickListener {
                val uri: Uri = Uri.parse(data["Book_url"])
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
            //val ac_url = findViewById(R.id.ac_url) as TextView
            ac_url.setOnClickListener {
                val uri: Uri = Uri.parse(data["Activity_url"])
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
        //imageView.setImageBitmap(bmp)

        // book_url.text = data["Book_url"]

        // val book_url = findViewById(R.id.book_url) as TextView


    }
}