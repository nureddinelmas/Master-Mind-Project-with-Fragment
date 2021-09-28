package com.nureddinelmas.mastermind

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nureddinelmas.mastermind.databinding.TwoplayerRecyclerviewBinding

class ResultAdapter(private val imageLook: ArrayList<ResultLook>) : RecyclerView.Adapter<ResultAdapter.ResultHolder>() {

    class ResultHolder(val binding: TwoplayerRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
        val binding = TwoplayerRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultHolder(binding)

    }

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {
        val imageLook = imageLook[position]
        holder.binding.p1.setImageResource(imageLook.first)
        holder.binding.p2.setImageResource(imageLook.second)
        holder.binding.p3.setImageResource(imageLook.third)
        holder.binding.p4.setImageResource(imageLook.fourth)
        holder.binding.resultImage1.setImageResource(imageLook.look1)
        holder.binding.resultImage2.setImageResource(imageLook.look2)
        holder.binding.resultImage3.setImageResource(imageLook.look3)
        holder.binding.resultImage4.setImageResource(imageLook.look4)
        holder.binding.player.text = imageLook.player
    }

    override fun getItemCount() = imageLook.size



}