package com.example.simplechatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var messages = mutableListOf<Message>()
        val adapter = SimpleChatAppAdapter(messages)
        rvMessages.adapter = adapter
        rvMessages.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            val incomingMsg = editTextTextPersonName.text.toString()
            val incomingMsgData = Message(incomingMsg)
            messages.add(incomingMsgData)
            adapter.notifyItemInserted(messages.size - 1)
            editTextTextPersonName.setText("")
        }

        val db = Firebase.firestore

        // Create a new user with a first and last name
        val user = hashMapOf(
            "first" to "Ada",
            "last" to "Lovelace",
            "born" to 1815
        )

// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding document", e)
            }
    }
}