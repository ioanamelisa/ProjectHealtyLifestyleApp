package com.example.healthylifestyle1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InspirationalQuotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspirational_quotes);


        TextView mondayQuoteText = findViewById(R.id.monday_quote_text);
        TextView tuesdayQuoteText = findViewById(R.id.tuesday_quote_text);
        TextView wednesdayQuoteText = findViewById(R.id.wednesday_quote_text);
        TextView thursdayQuoteText = findViewById(R.id.thursday_quote_text);
        TextView fridayQuoteText = findViewById(R.id.friday_quote_text);
        TextView saturdayQuoteText = findViewById(R.id.saturday_quote_text);
        TextView sundayQuoteText = findViewById(R.id.sunday_quote_text);



        mondayQuoteText.setText("You’ve got to get up every morning with determination if you’re going to go to bed with satisfaction.");
        tuesdayQuoteText.setText("You are today where your thoughts have brought you; you will be tomorrow where your thoughts take you.");
        wednesdayQuoteText.setText("People often say that motivation doesn’t last. Well, neither does bathing. That’s why we recommend it daily.");
        thursdayQuoteText.setText("Today you are you, that is truer than true. There is no one alive who is youer than you.");
        fridayQuoteText.setText("Music always sounds better on Friday.");
        saturdayQuoteText.setText("Without the weekend, where would the week be?");
        sundayQuoteText.setText("People rarely succeed unless they have fun in what they are doing.");

    }
}
