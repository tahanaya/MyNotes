package com.example.mynotes2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynotes2.adapters.NoteAdapter;
import com.example.mynotes2.models.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends AppCompatActivity {
    private static final int REQUEST_ADD_NOTE = 1;
    private ListView listViewNotes;
    private NoteAdapter adapter;
    private List<Note> noteList;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        // Initialisation
        listViewNotes = findViewById(R.id.listViewNotes);
        fabAdd = findViewById(R.id.fabAdd);
        noteList = new ArrayList<>();

        // Adapter
        adapter = new NoteAdapter(this, noteList);
        listViewNotes.setAdapter(adapter);

        // Bouton ajouter
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteListActivity.this, AddNoteActivity.class);
                startActivityForResult(intent, REQUEST_ADD_NOTE);
            }
        });

        // Clic sur une note
        listViewNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = noteList.get(position);
                Intent intent = new Intent(NoteListActivity.this, DetailsNoteActivity.class);
                intent.putExtra("note", note);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD_NOTE && resultCode == RESULT_OK) {
            Note newNote = (Note) data.getSerializableExtra("note");
            noteList.add(newNote);
            adapter.notifyDataSetChanged();
        }
    }
}