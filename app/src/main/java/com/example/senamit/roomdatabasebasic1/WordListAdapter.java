package com.example.senamit.roomdatabasebasic1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private static final String LOG_TAG = WordListAdapter.class.getSimpleName();

    private Context context;
    private List<Word> mWord;

    public WordListAdapter(Context context) {
        Log.i(LOG_TAG, "inside the constructor of recycler adapter");
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i(LOG_TAG, "inside the oncreateviewholder of recycler adapter");
        View itemView = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        return  new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.i(LOG_TAG, "inside the onBindViewHolder of recycler adapter");

        if (mWord!= null){
            Word current = mWord.get(position);
            holder.txtWord.setText(current.getWord());
            Log.i(LOG_TAG, "inside the onBindViewHolder of recycler adapter  "+ holder.txtWord.toString());
        }else {
            holder.txtWord.setText("no word");
        }

    }
    void setWord(List<Word> words){
            mWord = words;
            Log.i(LOG_TAG, "inside the set word method of adapter");
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
