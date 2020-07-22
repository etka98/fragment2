package com.example.fragment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mng = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bundle = Bundle()
        bundle.putString("name", nameTxt.text.toString())
        bundle.putString("surname", surnameTxt.text.toString())
        val transac = mng.beginTransaction()
        val fragment1 = MyFragment()
        fragment1.arguments = bundle
        transac.add(R.id.my_container, fragment1, "frag1")
        transac.commit()

        addBtn.setOnClickListener {
            val frag2 = mng.findFragmentByTag("frag1") as MyFragment
            if(frag2 == null){
                val tran = mng.beginTransaction()
                tran.add(R.id.my_container, frag2, "frag2")
                tran.commit()
            }
            else{
                Toast.makeText(this, "This Fragment is already in Stack", Toast.LENGTH_LONG).show()
            }
        }
    }
}