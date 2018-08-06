package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnGo;
    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinnerCategory);
        spn2 = findViewById(R.id.spinnerSubCat);
        btnGo = findViewById(R.id.buttonGo);

        alCategory = new ArrayList<>();
        aaCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCategory);
        spn2.setAdapter(aaCategory);



        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alCategory.clear();
                switch (position){
                    case 0:
                        String[] strRP = getResources().getStringArray(R.array.RPsubcategory);
                        alCategory.addAll(Arrays.asList(strRP));
                        spn2.setAdapter(aaCategory);
                        aaCategory.notifyDataSetChanged();
                        break;

                    case 1:
                        String[] strSOI = getResources().getStringArray(R.array.SOIsubcategory);
                        alCategory.addAll(Arrays.asList(strSOI));
                        aaCategory.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(spn2.getSelectedItemPosition() == 0){
                    Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.rp.edu.sg"));
                    startActivity(intent);
                }

                else if (spn2.getSelectedItemPosition() == 1){
                    Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.rp.edu.sg/student-life"));
                    startActivity(intent);
                }


            }
        });

    }
}
