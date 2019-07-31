package seventee170897.gmail.com.workshopresponsi

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MyListAdapter(private val context: Activity, private val id: Array<String>, private val name: Array<String>, private val email: Array<String>)
    : ArrayAdapter<String>(context, R.layout.custom_list, name) {
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_list, null, true)
		// TODO : Pada ArrayAdapter dilakukan pembacaan layout xml pada file custom_list 

        val idText = rowView.findViewById(R.id.textViewId) as TextView
        val nameText = rowView.findViewById(R.id.textViewName) as TextView
        val emailText = rowView.findViewById(R.id.textViewEmail) as TextView
		// TODO : pendeklarasian beberapa objek bertipe val yang nilai nya tetap, dengan mengambil id dari custom_list

        idText.text = "Id: ${id[position]}"
        nameText.text = "Name: ${name[position]}"
        emailText.text = "Email: ${email[position]}"
        return rowView
		// TODO : Pengambilan objek dari setiap variabel yang dibuat di EmpModelClass
    }
}