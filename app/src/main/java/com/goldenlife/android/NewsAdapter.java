package com.goldenlife.android;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
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
        View newsView;

        public ViewHolder(View view){
            super(view);
            newsView = view;
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

        final ViewHolder holder = new ViewHolder(view);
        holder.newsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positon = holder.getAdapterPosition();
                NewsList newsList = mNewsList.get(positon);
                WebView webView = new WebView(v.getContext());
                webView.canGoBack();
                webView.loadUrl(newsList.getNewsurl());
            }
        });


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
