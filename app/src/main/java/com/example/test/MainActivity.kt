package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class Employee(val id:String, val First:String, val Last:String){}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Save.setOnClickListener{
            val First = editTextTextPersonName.text.toString()
            val Last = editTextTextPersonName2.text.toString()

            val fb = FirebaseDatabase.getInstance()
            val ref = fb.getReference("Employee")
            val id:String? = ref.push().key

            val Employee = Employee(id.toString(), First,Last)
            ref.child(id.toString()).setValue(Employee).addOnCompleteListener{

                Toast.makeText(applicationContext, "Complete", Toast.LENGTH_LONG).show()
                textView.setText("")
                textView2.setText("")
            }

        }
        Reset.setOnClickListener{
            editTextTextPersonName.setText("")
            editTextTextPersonName2.setText("")
        }

    }
}