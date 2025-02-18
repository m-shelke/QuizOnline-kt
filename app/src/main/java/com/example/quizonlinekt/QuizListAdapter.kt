package com.example.quizonlinekt

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizonlinekt.databinding.RecyclerUiBinding

class QuizListAdapter(private val quizModelList: List<QuizModel>) :
    RecyclerView.Adapter<QuizListAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: RecyclerUiBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model: QuizModel){
            //binding all view

            binding.apply {
                quizTitleText.text = model.title
                quizSubtitleText.text = model.subtitle
                quizTimeText.text = model.time + " min"

                root.setOnClickListener{
                    val intent = Intent(root.context,QuizActivity::class.java)
                    root.context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerUiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return quizModelList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(quizModelList[position])
    }
}