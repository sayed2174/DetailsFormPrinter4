package com.example.detailsformprinter4;

import static com.example.detailsformprinter4.R.id;
import static com.example.detailsformprinter4.R.layout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    Button btn;
    public EditText name, password,date,age;
    RadioButton male,female;
    TextView display;
    String gender = "";
    int year,month,day;
    String selectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(layout.activity_main);
        spinner = findViewById(R.id.spinner);
        name = findViewById(R.id.etname);
        password = findViewById(R.id.etpassword);
        age = findViewById(R.id.age);
        date = findViewById(R.id.date);
        male = findViewById(R.id.r1);
        female=findViewById(R.id.r2);
        btn =  findViewById(R.id.btn);
        display = findViewById(R.id.display);
        spinner = findViewById(id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.state,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItem = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this,"Please Select one from dropdown list",Toast.LENGTH_SHORT).show();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = Calendar.getInstance().get(Calendar.YEAR);
                month = Calendar.getInstance().get(Calendar.MONTH);
                day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                DatePickerDialog bpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth +"/"+month+"/"+year);
                       }
                },year,month,day);
                        bpd.show();
            }
        });

        btn.setOnClickListener(v -> {
            String gen;
            if (male.isChecked())
                gen="Male";
            else
                gen="Female";

            String details = "User Name : "+ name.getText() +"\n"+"Gender :"+gen+"\nAge : "+ age.getText() +"\n"+"Date : "+ date.getText() +"\n"+"State Selected : "+selectedItem;
            display.setText(details);


        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}