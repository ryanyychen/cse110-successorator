package edu.ucsd.cse110.successorator.app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import edu.ucsd.cse110.successorator.app.databinding.ActivityMainBinding;
import edu.ucsd.cse110.successorator.lib.data.InMemoryDataSource;
import edu.ucsd.cse110.successorator.lib.domain.GoalRepository;
import edu.ucsd.cse110.successorator.lib.domain.SimpleGoalRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ActivityMainBinding view;
    private MainViewModel model; // won't need later when we do fragments
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_title);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

        var dataSource = InMemoryDataSource.fromDefault();
        this.model = new MainViewModel(new SimpleGoalRepository(dataSource));
//        var modelOwner = this;
//        var modelFactory = ViewModelProvider.Factory.from(MainViewModel.initializer);
//        var modelProvider = new ViewModelProvider(modelOwner, modelFactory);
//        this.model = modelProvider.get(MainViewModel.class);

        this.view = ActivityMainBinding.inflate(getLayoutInflater());

        model.getDisplayedText().observe(text -> view.placeholderText.setText(text));


        String date = new SimpleDateFormat("EEEE, M/dd", Locale.getDefault()).format(new Date());
        TextView dateTextView = view.dateTextView;
        if (dateTextView != null) {
            dateTextView.setText(date);
        }
        setContentView(view.getRoot());
    }
}
