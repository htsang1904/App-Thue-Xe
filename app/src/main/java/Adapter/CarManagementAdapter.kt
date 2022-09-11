package Adapter

import Model.CarManagement
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.thuexe.R
import com.example.thuexe.carmanagement

class CarManagementAdapter(private val carList: ArrayList<carmanagement> )
    : RecyclerView.Adapter<CarManagementAdapter.CarViewHolder>()  {
    class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val gia : TextView = itemView.findViewById(R.id.carManagement_price)
        val name : TextView = itemView.findViewById(R.id.carManagement_Name)
        val vitri : TextView = itemView.findViewById(R.id.carManagement_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_cardview_layout, parent  , false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        holder.gia.text = car.gia.toString()
        holder.name.text = car.name
        holder.vitri.text= car.vitri

    }

    override fun getItemCount(): Int {
        return carList.size
    }
}