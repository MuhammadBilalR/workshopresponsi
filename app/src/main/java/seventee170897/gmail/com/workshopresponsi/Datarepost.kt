package seventee170897.gmail.com.workshopresponsi

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_datarepo.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class Datarepost : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datarepo)

        val url = "https://mysafeinfo.com/api/data?list=presidents&format=json"

        AsyncTaskHandleJson().execute(url)
    }
	// TODO : Dilakukan referensi ke objek bundle yang diteruskan ke method OnCreate dari activity_main, kemudian dibuat tipe data bertipe val dengan nama url dengan nilai https://mysafeinfo.com/api/data?list=presidents&format=json objek tersebut immutable / tidak dapat diubah nilainya. Kemudian dilakukan method AsyncTaskHandleJson().execute untuk mengeksekusi variabel url

    inner class AsyncTaskHandleJson : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg url: String?): String {

            var text: String
            val connection = URL(url[0]).openConnection() as HttpURLConnection
            try {
                connection.connect()
                text = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }
            } finally {
                connection.disconnect()
            }
            return text
        }
		// TODO : Pada inner class dilakukan eksekusi AsyncTask dengan memanggil background thread untuk menjalankan komputasi latar belakang  untuk membuka koneksi dan membaca file yang ada di url

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            handleJson(result)
        }
    }
	// TODO : Pada onPostExecute akan menampilkan data pada result dengan method handleJson

    private fun handleJson(jsonString: String?) {
        val jsonArray = JSONArray(jsonString)

        val list = ArrayList<President>()
        var x = 0
        while (x < jsonArray.length()) {

            val jsonObject = jsonArray.getJSONObject(x)
            list.add(
                President(
                    jsonObject.getInt("id"),
                    jsonObject.getString("nm"),
                    jsonObject.getString("pp"),
                    jsonObject.getString("tm")
                )
            )
            x++
        }
		// TODO : Pada handleJson ini dilakukan perulangan untuk menampilkan data menggunakan array dari file json, pada jsonObject ditambahkan list dengan mengambil data pada President dengan value id, nm, pp dan tm

        val adapter = ListAdapter(this, list)
        presidents_list.adapter = adapter
    }
	// TODO : Variabel val dengan nama adapter ini untuk menghubungkan ke ListAdapter dari president_list

}
