package com.example.bodymash;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bodymash.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtText, edtweight, edtheight;
        Button btncalculate;
        TextView txtresult;
        LinearLayout llmain;

        edtText = findViewById(R.id.edtheight);
        edtweight =findViewById(R.id.edtweight);
        edtheight = findViewById(R.id.edtheight);
        btncalculate= findViewById(R.id.btncalculate);
        txtresult= findViewById(R.id.txtresult);
        llmain= findViewById(R.id.llmain);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtheight.getText().toString());
                int inc = Integer.parseInt(edtheight.getText().toString());

                int totalIn  = (ft*12) +inc;

                double totalCm = totalIn*2.54;

                double  totalIm= totalCm/100;

                double bmi = wt/(totalIm*totalIm);

                if(bmi>25){
                    txtresult.setText("You are Over Weight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.overwight));
                } else if (bmi<18.5) {
                    txtresult.setText("Your under weight");
                    llmain.setBackgroundColor(getResources().getColor(R.color.Underwight));
                }
                else {
                    txtresult.setText("Your are healthy");
                    llmain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }

            }
        });


    }

}