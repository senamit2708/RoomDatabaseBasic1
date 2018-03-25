package com.example.senamit.roomdatabasebasic1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by senamit on 22/3/18.
 */

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

    private Context context;
    private List<Word> mWord;

    public WordListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        return  new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (mWord!= null){
            Word current = mWord.get(position);
            holder.txtWord.setText(current.getWord());
        }else {
            holder.txtWord.setText("no word");
        }

    }
    void setWord(List<Word> words){
            mWord = words;
            notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
       if (mWord!= null){
           return mWord.size();
       }
       else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

      private final TextView txtWord;

        public ViewHolder(View itemView) {
            super(itemView);
            txtWord = itemView.findViewById(R.id.textView);

        }
    }
}
