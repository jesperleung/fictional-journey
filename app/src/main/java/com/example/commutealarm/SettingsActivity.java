package com.example.commutealarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final SeekBar seekBarDistance = (SeekBar) findViewById(R.id.seekBarDistance); // initiate the Seekbar
        seekBarDistance.setProgress(1000); // set Seekbar to either default value, or whatever value was selected before

        final TextView distanceValue = (TextView)findViewById(R.id.distanceValue); //initialize the TextView
        final EditText desiredDistance = (EditText)findViewById(R.id.desiredDistance);


        desiredDistance.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "1500")});

        seekBarDistance.setMax(1500); // 1500 maximum value for the Seek bar
        seekBarDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
                distanceValue.setText(String.valueOf(progress));
                desiredDistance.setText(String.valueOf(progress));
            }
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        desiredDistance.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
//                int desiredIntValue = Integer.parseInt(desiredDistance.toString());
//                String desiredStringVal = desiredDistance.getText().toString();
//                seekBarDistance.setProgress(desiredIntValue);

                //Update Seekbar value after entering a number
                String strDesiredDistance = desiredDistance.getText().toString();
                desiredDistance.setSelection(desiredDistance.getText().length());
                if (strDesiredDistance.matches("")) {
                    //does nothing, this should work, double check please
                }else {
                    seekBarDistance.setProgress(Integer.parseInt(editable.toString()));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

        });
    }
}
