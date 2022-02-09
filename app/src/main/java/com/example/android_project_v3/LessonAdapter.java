package com.example.android_project_v3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android_project_v3.databinding.ListItemBinding;

public class LessonAdapter extends ArrayAdapter<Lesson> {

    private static final String TAG = "xDEBUG";

    private ListItemBinding binding;

    public LessonAdapter(Context context, Lesson[] lessonArray) {
        super(context, 0, lessonArray);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        binding = ListItemBinding.bind(convertView);

        Lesson lesson = getItem(position);

        Log.d(TAG, "getView: Lesson = " + position + ". " + lesson.toString());
        Log.d(TAG, "getView: lesson.length = " +  position + ". " + lesson.getLength());
        Log.d(TAG, "getView: lesson.lengthConverter = " +  position + ". " + lesson.lengthConverter(lesson.getLength()));

        // TODO : seperate those to like below

        // binding.textViewListItemName.setText(lesson.toString());
        // binding.textViewListItemLength.setText("");

        binding.textViewListItemName.setText(lesson.getName());
        binding.textViewListItemLength.setText(lesson.lengthConverter(lesson.getLength()));

        if(lesson.isCompleted()) {
            binding.textViewChecked.setVisibility(View.VISIBLE);
        }
        else {
            binding.textViewChecked.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

}
