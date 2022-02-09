package com.example.android_project_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android_project_v3.databinding.ActivityLessonListBinding;

public class LessonListActivity extends AppCompatActivity {

    private ActivityLessonListBinding binding;

    ListView lessonListView;
    Lesson[] lessons;
    private LessonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLessonListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configure();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xDEBUG", "onResume: lessons[0].isCompleted = " + lessons[0].isCompleted());
        adapter.notifyDataSetChanged();
    }

    private void configure() {
        // lessonListView = findViewById(R.id.listview_lesson_list);
        lessonListView = binding.listviewLessonList;

        lessons = Lesson.getInstances();

        lessonListView.setClickable(true);
        // ArrayAdapter<Lesson> lessonArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lessons);
        adapter = new LessonAdapter(this, lessons);
        // adapter.notifyDataSetChanged();
        lessonListView.setAdapter(adapter);

        lessonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // send info to new activity (LessonDetailActivity)

                Log.d("xDEBUG", "i: " + i);
                Log.d("xDEBUG", "lessons[i].lessonNumber: " + lessons[i].getLessonNumber());
                Intent intent = new Intent(LessonListActivity.this, LessonDetailActivity.class);

                intent.putExtra("lessonNumber", lessons[i].getLessonNumber());

                startActivity(intent);
            }
        });


    }
}