package com.example.mid_13120220027;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private EditText editNilai, editNilai2, txtHasilPerhitungan;
    private RadioGroup radioGroup;
    private Button btnClear;
    private double hasil=0;
    private boolean pilihOperasi = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNilai = findViewById(R.id.nilai1);
        editNilai2 = findViewById(R.id.nilai2);
        txtHasilPerhitungan = findViewById(R.id.hasil);
        radioGroup = findViewById(R.id.rgOperasi);
        btnClear = findViewById(R.id.btnHapus);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                editNilai.setText("");
                editNilai2.setText("");
                txtHasilPerhitungan.setText("");
                radioGroup.clearCheck();
                pilihOperasi = false;
            }


        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                pilihOperasi = true;
                hitung();
            }
        });

    }

    public void hitung() {
        if(!pilihOperasi || editNilai.getText().toString().isEmpty() ||editNilai2.getText().toString().isEmpty()) {

            return;
        }

        double nilai1 = Double.parseDouble(editNilai.getText().toString());
        double nilai2 = Double.parseDouble(editNilai2.getText().toString());

        if(radioGroup.getCheckedRadioButtonId() == R.id.tambah) {
            hasil = nilai1 + nilai2;
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.kurang) {
            hasil = nilai1 - nilai2;
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.kali) {
            hasil = nilai1 * nilai2;
        }
        else if (radioGroup.getCheckedRadioButtonId() == R.id.bagi) {
            hasil = nilai1/nilai2;
        }
        txtHasilPerhitungan.setText(String.valueOf(hasil));
    }
}