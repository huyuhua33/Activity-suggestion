package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    var Activity_list: MutableList<Detail> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        val intent = Intent()
        intent.setClass(this@MainActivity, DetalActivity::class.java)

        val city = arrayListOf<String>("台中市")
        val destination = arrayListOf<String>("西屯", "西","南")
        val type = arrayListOf<String>(
            "noType",
            "Learning",
            "Arts",
            "CategoryEnum.Investm",
            "Sports",
            "Family",
            "Health",
            "Business",
            "Outdoor",
            "Other",
            "CategoryEnum.Startup",
            "Photography",
            "CategoryEnum.Handmad",
            "CategoryEnum.Design"
        )
        val num = arrayListOf<String>("1", "2", "3", "4", "5")
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
        addSpin(spinner2, city)
        addSpin(spinner, destination)
        addSpin(spinner3, type)
        search.setOnClickListener {
            val SelectType = spinner3.selectedItem.toString()//+","+spinner2.selectedItem.toString()
            val discrit = spinner.selectedItem.toString()
            thread(start = true) {
                Connecttoclient(discrit, SelectType)
                runOnUiThread {
                    textView0.text = "1 " + Activity_list[0].Activity_Name
                    textView1.text = "2 " + Activity_list[1].Activity_Name
                    textView2.text = "3 " + Activity_list[2].Activity_Name
                    textView3.text = "4 " + Activity_list[3].Activity_Name
                    textView4.text = "5 " + Activity_list[4].Activity_Name
                    System.out.println(Activity_list)
                }
            }

        }

        val view1 = findViewById(R.id.textView1) as TextView
        view1.setOnClickListener {
            val data = Activity_list[1]
            intent.putExtra(Slist[0], data.Activity_Name)
            intent.putExtra(Slist[1], data.Type)
            intent.putExtra(Slist[2], data.Picture)
            intent.putExtra(Slist[3], data.Activity_url)
            intent.putExtra(Slist[4], data.Activity_StartTime)
            intent.putExtra(Slist[5], data.Activity_EndTime)
            intent.putExtra(Slist[6], data.StartDate)
            intent.putExtra(Slist[7], data.EndtDate)
            intent.putExtra(Slist[8], data.north.toString())
            intent.putExtra(Slist[9], data.east.toString())
            intent.putExtra(Slist[10], data.City)
            intent.putExtra(Slist[11], data.FullAddr)
            intent.putExtra(Slist[12], data.Book_url)
            intent.putExtra(Slist[13], data.Book_StartTime)
            intent.putExtra(Slist[14], data.Book_EndTime)
            intent.putExtra(Slist[15], data.Price.toString())
            startActivity(intent)
        }

        val view2 = findViewById(R.id.textView2) as TextView
        view2.setOnClickListener {
            val data = Activity_list[2]


            intent.putExtra(Slist[0], data.Activity_Name)
            intent.putExtra(Slist[1], data.Type)
            intent.putExtra(Slist[2], data.Picture)
            intent.putExtra(Slist[3], data.Activity_url)
            intent.putExtra(Slist[4], data.Activity_StartTime)
            intent.putExtra(Slist[5], data.Activity_EndTime)
            intent.putExtra(Slist[6], data.StartDate)
            intent.putExtra(Slist[7], data.EndtDate)
            intent.putExtra(Slist[8], data.north.toString())
            intent.putExtra(Slist[9], data.east.toString())
            intent.putExtra(Slist[10], data.City)
            intent.putExtra(Slist[11], data.FullAddr)
            intent.putExtra(Slist[12], data.Book_url)
            intent.putExtra(Slist[13], data.Book_StartTime)
            intent.putExtra(Slist[14], data.Book_EndTime)
            intent.putExtra(Slist[15], data.Price.toString())

            startActivity(intent)
        }

        val view3 = findViewById(R.id.textView3) as TextView
        view3.setOnClickListener {
            val data = Activity_list[3]
            intent.putExtra(Slist[0], data.Activity_Name)
            intent.putExtra(Slist[1], data.Type)
            intent.putExtra(Slist[2], data.Picture)
            intent.putExtra(Slist[3], data.Activity_url)
            intent.putExtra(Slist[4], data.Activity_StartTime)
            intent.putExtra(Slist[5], data.Activity_EndTime)
            intent.putExtra(Slist[6], data.StartDate)
            intent.putExtra(Slist[7], data.EndtDate)
            intent.putExtra(Slist[8], data.north.toString())
            intent.putExtra(Slist[9], data.east.toString())
            intent.putExtra(Slist[10], data.City)
            intent.putExtra(Slist[11], data.FullAddr)
            intent.putExtra(Slist[12], data.Book_url)
            intent.putExtra(Slist[13], data.Book_StartTime)
            intent.putExtra(Slist[14], data.Book_EndTime)
            intent.putExtra(Slist[15], data.Price.toString())

            startActivity(intent)
        }

        val view0 = findViewById(R.id.textView0) as TextView
        view0.setOnClickListener {
            val data = Activity_list[0]
            intent.putExtra(Slist[0], data.Activity_Name)
            intent.putExtra(Slist[1], data.Type)
            intent.putExtra(Slist[2], data.Picture)
            intent.putExtra(Slist[3], data.Activity_url)
            intent.putExtra(Slist[4], data.Activity_StartTime)
            intent.putExtra(Slist[5], data.Activity_EndTime)
            intent.putExtra(Slist[6], data.StartDate)
            intent.putExtra(Slist[7], data.EndtDate)
            intent.putExtra(Slist[8], data.north.toString())
            intent.putExtra(Slist[9], data.east.toString())
            intent.putExtra(Slist[10], data.City)
            intent.putExtra(Slist[11], data.FullAddr)
            intent.putExtra(Slist[12], data.Book_url)
            intent.putExtra(Slist[13], data.Book_StartTime)
            intent.putExtra(Slist[14], data.Book_EndTime)
            intent.putExtra(Slist[15], data.Price.toString())
            startActivity(intent)
        }

        val view4 = findViewById(R.id.textView4) as TextView
        view4.setOnClickListener {
            val data = Activity_list[4]
            intent.putExtra(Slist[0], data.Activity_Name)
            intent.putExtra(Slist[1], data.Type)
            intent.putExtra(Slist[2], data.Picture)
            intent.putExtra(Slist[3], data.Activity_url)
            intent.putExtra(Slist[4], data.Activity_StartTime)
            intent.putExtra(Slist[5], data.Activity_EndTime)
            intent.putExtra(Slist[6], data.StartDate)
            intent.putExtra(Slist[7], data.EndtDate)
            intent.putExtra(Slist[8], data.north.toString())
            intent.putExtra(Slist[9], data.east.toString())
            intent.putExtra(Slist[10], data.City)
            intent.putExtra(Slist[11], data.FullAddr)
            intent.putExtra(Slist[12], data.Book_url)
            intent.putExtra(Slist[13], data.Book_StartTime)
            intent.putExtra(Slist[14], data.Book_EndTime)
            intent.putExtra(Slist[15], data.Price.toString())

            startActivity(intent)
        }


        thread(start = true) {
            Connecttoclient("西屯", "Learning")
            runOnUiThread {
                textView0.text = Activity_list[0].Activity_Name
                textView1.text = Activity_list[1].Activity_Name
                textView2.text = Activity_list[2].Activity_Name
                textView3.text = Activity_list[3].Activity_Name
                textView4.text = Activity_list[4].Activity_Name
                System.out.println(Activity_list)
            }

            // addSpin(spinner4, num)

        }
    }

    private fun addSpin(spinner: Spinner, lunch: ArrayList<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lunch)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                pos: Int,
                id: Long
            ) {
                //Log.i("tag","you select the "+lunch[pos])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun Connecttoclient(discrit: String, Type: String) {
        connecting.text = "Loading"
        val info = Client()
        val act = info.main(discrit, Type)

        var list3 = act.split("$")


        if (!list3.isEmpty()) {
            var j = 0
            for (i in 0..(list3.size / 16) - 1) {
                val n = Detail(
                    list3[0 + i * 16],
                    list3[1 + i * 16],
                    list3[2 + i * 16],
                    list3[3 + i * 16],
                    list3[4 + i * 16],
                    list3[5 + i * 16],
                    list3[6 + i * 16],
                    list3[7 + i * 16],
                    list3[8 + i * 16].toDouble(),
                    list3[9 + i * 16].toDouble(),
                    list3[10 + i * 16],
                    list3[11 + i * 16],
                    list3[12 + i * 16],
                    list3[13 + i * 16],
                    list3[14 + i * 16],
                    list3[15 + i * 16].toDouble()

                )
                //System.out.println(i)
                Activity_list.add(i, n)
                j += 1
            }

            for (i in j..4) {
                val n = Detail(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    0.000000,
                    0.000000,
                    "",
                    "",
                    "",
                    "",
                    "",
                    0.0
                )
                Activity_list.add(j, n)
            }
        } else {
            System.out.println("list3 is null")
            init()
        }
        Thread.sleep(10)
        connecting.text = ""
    }

    private fun init() {
        textView0.text = "1."
        textView1.text = "2."
        textView2.text = "3."
        textView3.text = "4."
        textView4.text = "5."

    }

}


