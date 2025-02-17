package com.example.quizonlinekt

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizonlinekt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var quizModelList: MutableList<QuizModel>

    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        quizModelList = mutableListOf()
        getDataFromFirebase()

    }

    private fun setUpRecyclerView(){
        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    private fun getDataFromFirebase(){
//        dummy data to RecyclerView
        quizModelList.add(QuizModel("1","Promgramming","Programming basis Fundaments And Principals","20"))
        quizModelList.add(QuizModel("1","Arts","Programming basis Fundaments And Principals","10"))
        quizModelList.add(QuizModel("1","Science","Programming basis Fundaments And Principals","12"))
        quizModelList.add(QuizModel("1","Commerce","Programming basis Fundaments And Principals","25"))
        quizModelList.add(QuizModel("1","Designing","Programming basis Fundaments And Principals","30"))

        setUpRecyclerView()
    }
}