package com.goldenlife.android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.goldenlife.android.gson.News;
import com.goldenlife.android.gson.NewsList;

import java.util.List;

/**
 * Created by 森宇 on 2018/5/18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<NewsList> mNewsList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView newsTitile;
        TextView newsTime;

        public ViewHolder(View view){
            super(view);
            newsTitile = (TextView)view.findViewById(R.id.news_title);
            newsTime =  (TextView)view.findViewById(R.id.news_time);
        }
    }

    public NewsAdapter(List<NewsList> newsList){
        mNewsList = newsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsList newsList = mNewsList.get(position);
        holder.newsTitile.setText(newsList.getNewstitle());
        holder.newsTime.setText(newsList.getNewstime());

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }


}
