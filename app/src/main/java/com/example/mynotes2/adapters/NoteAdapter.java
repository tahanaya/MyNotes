package com.example.mynotes2.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mynotes2.R;
import com.example.mynotes2.models.Note;

import java.util.List;

public class NoteAdapter extends BaseAdapter {
    private Context context;
    private List<Note> noteList;

    public NoteAdapter(Context context, List<Note> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return noteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false);
            holder = new ViewHolder();
            holder.tvNom = convertView.findViewById(R.id.tvNom);
            holder.tvDate = convertView.findViewById(R.id.tvDate);
            holder.viewPriorite = convertView.findViewById(R.id.viewPriorite);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Note note = noteList.get(position);
        holder.tvNom.setText(note.getNom());
        holder.tvDate.setText(note.getDate());

        // Couleur selon la priorité
        int couleur = getCouleurPriorite(note.getPriorite());
        holder.viewPriorite.setBackgroundColor(couleur);

        return convertView;
    }

    private int getCouleurPriorite(String priorite) {
        switch (priorite) {
            case "Haute":
                return Color.parseColor("#FF5252"); // Rouge
            case "Moyenne":
                return Color.parseColor("#FFA726"); // Orange
            case "Basse":
                return Color.parseColor("#66BB6A"); // Vert
            default:
                return Color.GRAY;
        }
    }

    static class ViewHolder {
        TextView tvNom;
        TextView tvDate;
        View viewPriorite;
    }
}