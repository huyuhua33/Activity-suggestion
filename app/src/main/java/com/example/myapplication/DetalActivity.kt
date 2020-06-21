package com.example.myapplication


import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail.*
import java.net.URL
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
//import kotlinx.coroutines.*
import kotlin.system.*

class DetalActivity : AppCompatActivity() {
    override fun onCreate(savedInstantstate: Bundle?) {
        System.out.println("222222222")
        super.onCreate(savedInstantstate)
        setContentView(R.layout.detail)
        val intent = getIntent()


        var data = mutableMapOf<String, String>()
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
            "east",
            "City",
            "FullAddr",
            "Book_url",
            "Book_StartTime",
            "Book_EndTime",
            "Price"
        )
        for (str in Slist) {
            data.set(str, intent.getStringExtra(str))
        }
        textView.text = data["Activity_Name"]
        addr.text = "活動地址\n" + data["FullAddr"]
        time.text =
            time.text.toString() + data["Activity_StartTime"] + " 至 " + data["Activity_EndTime"]
        if (data["StartDate"] == (data["EndtDate"])) {
            date.text = date.text.toString() + data["StartDate"]
        } else {
            date.text = date.text.toString() + data["StartDate"] + " 至 " + data["EndtDate"]
        }
        book_time.text =
            "訂票日期： 自 " + data["Book_StartTime"] + "\n　　　　　 至 " + data["Book_EndTime"]
        Price.text = Price.text.toString() + data["Price"]
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
        val map = findViewById(R.id.addr) as TextView
        map.setOnClickListener {
            val uri: Uri =
                Uri.parse("https://www.google.com.tw/maps/place/${data["east"]}+${data["north"]}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        val t1: List<String>? = data["Activity_StartTime"]?.split(":")
        val t11 = t1?.get(0) + t1?.get(1) + t1?.get(2)
        val t2: List<String>? = data["Activity_EndTime"]?.split(":")
        val t21 = t2?.get(0) + t2?.get(1) + t2?.get(2)
        val d1: List<String>? = data["StartDate"]?.split("-")
        val d11 = d1?.get(0) + d1?.get(1) + d1?.get(2)
        val d2: List<String>? = data["EndtDate"]?.split("-")
        val d21 = d2?.get(0) + d2?.get(1) + d2?.get(2)


        val date = findViewById(R.id.date) as TextView
        date.setOnClickListener{
            val uri: Uri =
                Uri.parse("http://www.google.com/calendar/event?action=TEMPLATE&text=${data["Activity_Name"]}&" +
                        "dates=${d11}T${t11}/${d21}T${t21}&location=${data["FullAddr"]}&trp=false")
            System.out.println(uri.toString())
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }



        thread(start = true)
        {
            System.out.println("url")
            val url = URL(data["Picture"]).openStream()
            //  System.out.println(url)
            val bmp = BitmapFactory.decodeStream(url)
            runOnUiThread() {
                //  System.out.println(data)
                imageView.setImageBitmap(bmp)
            }
        }
    }



}
/*date.setOnClickListener {
     val ur = "http://www.google.com/calendar/event?action=TEMPLATE&text=${data["Activity_Name"]}&dates=[開始時間]/[結束時間]//時間格式為 YYYYMMDDTHHMMSS&details=[詳細的描述]//使用 %0A 作為跳行///&location=[地點]// 標示地點&trp=false"
     val uri: Uri = Uri.parse(data["Book_url"])
     val intent = Intent(Intent.ACTION_VIEW, uri)
     startActivity(intent)
 }*/
//http://www.google.com/calendar/event?action=TEMPLATE&text=[事件名稱]&dates=[開始時間]/[結束時間]//時間格式為 YYYYMMDDTHHMMSS&details=[詳細的描述]//使用 %0A 作為跳行///&location=[地點]// 標示地點&trp=false
//imageView.setImageBitmap(bmp)

// book_url.text = data["Book_url"]

// val book_url = findViewById(R.id.book_url) as TextView

