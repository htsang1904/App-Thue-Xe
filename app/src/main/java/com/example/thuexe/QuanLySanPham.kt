package com.example.thuexe

import Adapter.CarManagementAdapter
import Model.Car
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class QuanLySanPham : AppCompatActivity() {
    private lateinit var QLSPreturnBtn: TextView
    private lateinit var db: DatabaseReference
    private lateinit var carRecyclerview: RecyclerView
    private lateinit var carArraylist: ArrayList<carmanagement>
    private lateinit var carAdapter: CarManagementAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quan_ly_san_pham)
        carRecyclerview = findViewById(R.id.carlist)
        carRecyclerview.layoutManager = LinearLayoutManager(this)
        carRecyclerview.setHasFixedSize(true)

        carArraylist = arrayListOf<carmanagement>()
        getCarData()
    }

    private fun getCarData() {
        db.child("Car").addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                // toast(snapshot.getValue(Car::class.java).toString())
                val comment = snapshot.getValue<Car>()
                carArraylist.add(
                    carmanagement(
                        comment!!.name.toString(),
                        comment!!.gia.toString(),
                        comment!!.vitri.toString()
                    )
                )


            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                TODO("Not yet implemented")
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        val handler = Handler()
        handler.postDelayed({
            carAdapter = CarManagementAdapter(carArrayList)
            carRecyclerview.adapter= carAdapter
        })


    }
}

//    private fun getCarData() {
//        db = FirebaseDatabase.getInstance().getReference("Car")
//
//        db.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if (snapshot.exists()) {
//                    for (userSnapshot in snapshot.children) {
//                        val user = userSnapshot.getValue(carmanagement::class.java)
//                        carArraylist.add(user!!)
//                    }
//                    carRecyclerview.adapter =
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
//
//    }
//}



//
//
//        QLSPreturnBtn = findViewById(R.id.itemBackBtn)
//        QLSPreturnBtn.setOnClickListener(View.OnClickListener {
//            this.finish()
//        })
//    }
//
//    private fun getCarData() {
//        db = FirebaseDatabase.getInstance().getReference("Car")
//        db.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//
//                if (snapshot.exists()) {
//
//                    for (carSnapshot in snapshot.children) {
//
//
//                        val car = carSnapshot.getValue(carmanagement::class.java)
//                        carArraylist.add(car!!)
//
//                    }
//
//                    carRecycleview.adapter = CarManagementAdapter(carArraylist)
//
//
//                }
//
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                TODO("Not yet implemented")
//            }
//        })
//    }
//}