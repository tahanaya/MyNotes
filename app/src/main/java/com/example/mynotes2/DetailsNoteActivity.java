package com.example.mynotes2;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mynotes2.models.Note;

import java.io.File;

public class DetailsNoteActivity extends AppCompatActivity {
    private TextView tvNom, tvDescription, tvDate, tvPriorite;
    private ImageView ivPhoto;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_note);

        tvNom = findViewById(R.id.tvNom);
        tvDescription = findViewById(R.id.tvDescription);
        tvDate = findViewById(R.id.tvDate);
        tvPriorite = findViewById(R.id.tvPriorite);
        ivPhoto = findViewById(R.id.ivPhoto);
        btnRetour = findViewById(R.id.btnRetour);

        Note note = (Note) getIntent().getSerializableExtra("note");

        if (note != null) {
            tvNom.setText(note.getNom());
            tvDescription.setText(note.getDescription());
            tvDate.setText("📅 " + note.getDate());
            tvPriorite.setText("🔔 Priorité: " + note.getPriorite());

            if (note.getPhotoPath() != null && !note.getPhotoPath().isEmpty()) {
                File file = new File(note.getPhotoPath());
                if (file.exists()) {
                    ivPhoto.setImageURI(Uri.fromFile(file));
                    ivPhoto.setVisibility(View.VISIBLE);
                }
            }
        }

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}