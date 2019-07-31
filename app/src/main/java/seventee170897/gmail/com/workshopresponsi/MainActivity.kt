package seventee170897.gmail.com.workshopresponsi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button1) as Button
        val btn1 = findViewById<Button>(R.id.button2) as Button
        val btn2 = findViewById<Button>(R.id.button3) as Button
		// TODO : Pendeklarasian variabel dengan tipe val untuk tipe Button yang nilainya tetap

        btn.setOnClickListener {
            val intent = Intent(this, array::class.java)
            startActivity(intent)
        }
		// TODO : Intent yang dilakukan untuk pemanggilan activity array pada btn ketika diklik

		btn1.setOnClickListener {
			val intent2 = Intent(this, Sqlite::class.java)
			startActivity(intent2)
		}
		// TODO : Intent yang dilakukan untuk pemanggilan activity Sqlite pada btn1 ketika diklik

        btn2.setOnClickListener {
            val intent3 = Intent(this, Datarepost::class.java)
            startActivity(intent3)
        }
		// TODO : Intent yang dilakukan untuk pemanggilan activity Datarepost pada btn2 ketika diklik
    }
}
