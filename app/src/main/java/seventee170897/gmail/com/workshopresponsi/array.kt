package seventee170897.gmail.com.workshopresponsi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_array.*
import android.R.layout.simple_list_item_1

class array : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array)
		// TODO : pada kelas ini dilakukan pengaturan UI aktivitas di activity_array dengan meneruskan ID dari layout tersebut
		
        val language =
            listOf("ASUS", "ACER", "LENOVO", "SAMSUNG", "MACBOOK")
        List.adapter =
            ArrayAdapter(this, simple_list_item_1, language)
		// TODO : pada variabel language dengan tipe val tersebut dibuat array data, dan selanjutnya pada List dilakukan akses item melalui ArrayAdapter
		
        List.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Anda memilih:${language[position]}", Toast.LENGTH_SHORT).show()
		// TODO : pada List yang diklik akan menampilkan Toast berupa informasi dalam bentuk text
        }
    }
}
