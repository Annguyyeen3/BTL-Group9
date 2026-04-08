package com.example.btl_group9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_group9.adapters.MovieAdapter;
import com.example.btl_group9.models.Movie;
import com.example.btl_group9.models.Showtime;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMovies;
    private MovieAdapter adapter;
    private List<Movie> movieList;
    private FirebaseFirestore db;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
            return;
        }

        db = FirebaseFirestore.getInstance();
        
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        rvMovies = findViewById(R.id.rvMovies);
        progressBar = findViewById(R.id.progressBar);
        
        movieList = new ArrayList<>();
        adapter = new MovieAdapter(movieList, movie -> {
            Intent intent = new Intent(MainActivity.this, ShowtimeActivity.class);
            intent.putExtra("MOVIE_ID", movie.getMovie_id());
            intent.putExtra("MOVIE_TITLE", movie.getTitle());
            startActivity(intent);
        });

        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        rvMovies.setAdapter(adapter);

        fetchMovies();
    }

    private void fetchMovies() {
        progressBar.setVisibility(View.VISIBLE);
        db.collection("movies")
                .get()
                .addOnCompleteListener(task -> {
                    progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        movieList.clear();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Movie movie = document.toObject(Movie.class);
                            movieList.add(movie);
                        }
                        adapter.notifyDataSetChanged();
                    } else {
                        Log.e("Firestore", "Error getting documents: ", task.getException());
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout) {
            mAuth.signOut();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    // Các hàm push dữ liệu mẫu (có thể gọi thủ công nếu cần)
    private void pushSampleData() {
        Movie m1 = new Movie("m1", "Avengers: Endgame", "After the devastating events of Infinity War...", "https://image.tmdb.org/t/p/w500/or06vSqzWkaGvSmyZ0pvcbtY1n2.jpg", 181, 4.8);
        db.collection("movies").document(m1.getMovie_id()).set(m1);
        
        List<String> emptySeats = new ArrayList<>();
        Timestamp time1 = new Timestamp(new Date(System.currentTimeMillis() + 86400000));
        Showtime st1 = new Showtime("st1", "m1", "Theater 1", time1, 120000.0, emptySeats);
        db.collection("showtimes").document(st1.getShowtime_id()).set(st1);
    }
}
