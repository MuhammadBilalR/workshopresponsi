package seventee170897.gmail.com.workshopresponsi

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import seventee170897.gmail.com.workshopresponsi.President

class ListAdapter(val context: Context, val list: ArrayList<President>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.layout_row,parent,false)
		// TODO : View dengan menggunakan context untuk membaca file layout_row melalui LayoutInflater

        val presidentId = view.findViewById(R.id.president_id) as AppCompatTextView
        val presidentName = view.findViewById(R.id.president_name) as AppCompatTextView
        val presidentPolitic = view.findViewById(R.id.president_politic) as AppCompatTextView
        val presidentTime = view.findViewById(R.id.president_time) as AppCompatTextView
		// TODO : pendeklarasian beberapa objek bertipe val yang nilai nya tetap, dengan mengambil id dari layout_row

        presidentId.text = list[position].id.toString()
        presidentName.text = list[position].name
        presidentPolitic.text = list[position].politic
        presidentTime.text = list[position].time

        return view
    }
	// TODO : Variabel yang sebelumnya, dibuat objek dari data class President

    override fun getItem(position: Int): Any {
        return list[position]
    }
	// TODO : Pengambilan data item

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
	// TODO : Pengambilan data ID dari item

    override fun getCount(): Int {
        return list.size
    }
	// TODO : Pengambukan jumlah data
}