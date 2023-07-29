package com.example.drinksorder

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.button)


        var recyclerVIew = findViewById<RecyclerView>(R.id.recyclerVIew)
        recyclerVIew.layoutManager = LinearLayoutManager(this)

        //
        var drinksList : ArrayList<DrinkModel> = ArrayList()
        dataGenerator(drinksList)

        //adapter
        val adapter = Adapter(drinksList)
        recyclerVIew.adapter = adapter

        btn.setOnClickListener(){
            composeEmail(emailBodyGenerator(drinksList))
        }


    }
    //Generates Data and adds it to the ArrayList<DrinkModel>
    private fun dataGenerator(drinkList: ArrayList<DrinkModel>) {

        val d1 : DrinkModel = DrinkModel("Wasser", 0)
        val d2 : DrinkModel = DrinkModel("Wasser-Classic", 0)
        val d3 : DrinkModel = DrinkModel("Wasser-Sanft", 0)
        val d4 : DrinkModel = DrinkModel("Coca-Cola", 0)
        val d5 : DrinkModel = DrinkModel("Cola-Zero", 0)
        val d6 : DrinkModel = DrinkModel("Cola-Light", 0)
        val d7 : DrinkModel = DrinkModel("Apfelschorle", 0)
        val d8 : DrinkModel = DrinkModel("Johannisbeer", 0)
        val d9 : DrinkModel = DrinkModel("Mangoschorle", 0)
        val d10 : DrinkModel = DrinkModel("MultiVItamin", 0)
        val d11 : DrinkModel = DrinkModel("MitArbeiter \nwasser Naturel", 0);
        val d12 : DrinkModel = DrinkModel("MitArbeiter \nwasser Classic", 0);

        drinkList.add(d1)
        drinkList.add(d2)
        drinkList.add(d3)
        drinkList.add(d4)
        drinkList.add(d5)
        drinkList.add(d6)
        drinkList.add(d7)
        drinkList.add(d8)
        drinkList.add(d9)
        drinkList.add(d10)
        drinkList.add(d11)
        drinkList.add(d12)

    }

    fun composeEmail(emailBody: String) {


        //Array String to store all email recipient
        val recipientList = arrayOf("Fabrizio.Musco@primo.cafe")
        //stores the subject of the email
        val subject = "Woche Umsatz"



        // Implicit intent Action that composes the email
        var i = Intent(Intent.ACTION_SENDTO)
        i.setData(Uri.parse("mailto:"))
        i.putExtra(Intent.EXTRA_SUBJECT, subject)
        i.putExtra(Intent.EXTRA_EMAIL, recipientList)
        i.putExtra(Intent.EXTRA_TEXT, emailBody)

        startActivity(i)
    }

    fun emailBodyGenerator(drinkList: ArrayList<DrinkModel>) : String{
        // Email Body:
        var y = "Hallo Zusammen \n Kundennummer: 16222 \n wir möchten bestellen: \n" +
                " "

        for (i in drinkList) {
            if (i.getDrinkQuantity().toInt() > 0) {
                y += "\n ${i.getDrinkName()} : ${i.getDrinkQuantity()} "
            }
        }

        y += "\n \n VG \n Primo Expresso"

        return y
    }


}