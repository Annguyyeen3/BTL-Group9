package com.example.btl_group9;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_group9.adapters.ShowtimeAdapter;
import com.example.btl_group9.models.Showtime;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowtimeActivity extends AppCompatActivity {

    private String movieId;
    private String movieTitle;
    private RecyclerView rvShowtimes;
    private ShowtimeAdapter adapter;
    private List<Showtime> showtimeList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtime);

        db = FirebaseFirestore.getInstance();
        
        movieId = getIntent().getStringExtra("MOVIE_ID");
        movieTitle = getIntent().getStringExtra("MOVIE_TITLE");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(movieTitle);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        rvShowtimes = findViewById(R.id.rvShowtimes);
        showtimeList = new ArrayList<>();
        adapter = new ShowtimeAdapter(showtimeList, showtime -> {
            // Chuyển sang màn hình chọn ghế
            Toast.makeText(this, "Chọn suất chiếu: " + showtime.getShowtime_id(), Toast.LENGTH_SHORT).show();
        });

        rvShowtimes.setLayoutManager(new LinearLayoutManager(this));
        rvShowtimes.setAdapter(adapter);

        fetchShowtimes();
    }

    private void fetchShowtimes() {
        Log.d("Firestore", "Fetching showtimes for movie: " + movieId);
        db.collection("showtimes")
                .whereEqualTo("movie_id", movieId)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        showtimeList.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Showtime showtime = document.toObject(Showtime.class);
                            showtimeList.add(showtime);
                        }
                        adapter.notifyDataSetChanged();
                        
                        if (showtimeList.isEmpty()) {
                            Toast.makeText(this, "No showtimes found for this movie.", Toast.LENGTH_SHORT).show();
                            Log.d("Firestore", "No showtimes found in Firestore for movieId: " + movieId);
                        }
                    } else {
                        Log.e("Firestore", "Error getting documents: ", task.getException());
                    }
                });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
