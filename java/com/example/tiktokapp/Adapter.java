package com.example.tiktokapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewTreeViewModelKt;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokapp.databinding.ReelDesignBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.videoHolder> {
   Context context;
   ArrayList<Model> modelArrayList ;
   boolean isPlaying=false;

    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public videoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.reel_design,parent,false);
        return new videoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull videoHolder holder, int position) {

        holder.binding.videoView.setVideoPath(modelArrayList.get(position).getVideoUrl());
        holder.binding.textView.setText(modelArrayList.get(position).getName());
        holder.binding.profile.setImageResource(modelArrayList.get(position).getProfile());
        holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPlaying=true;
            }
        });
        holder.binding.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPlaying=true;
            }
        });
        holder.binding.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying)
                {
                    holder.binding.videoView.pause();
                    isPlaying=false;
                }else {
                    holder.binding.videoView.resume();
                    isPlaying=true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class videoHolder extends RecyclerView.ViewHolder{
      ReelDesignBinding binding;
        public videoHolder(@NonNull View itemView) {
            super(itemView);
            binding=ReelDesignBinding.bind(itemView);
        }
    }
}
