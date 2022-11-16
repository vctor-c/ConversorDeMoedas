package com.example.conversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.editEntrada = findViewById(R.id.edit_valor);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalcular = findViewById(R.id.button_calcular);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);

        this.clearValues();
    }

    private void clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_calcular) {
            String value = this.mViewHolder.editEntrada.getText().toString();
            if (value.equals("")) {
                Toast.makeText(this, R.string.Informe_o_valor, Toast.LENGTH_LONG).show();
            } else {
                    Double mreal;
                    mreal = Double.valueOf(value); 
                this.mViewHolder.textDolar.setText(String.format("%.2f", (mreal / 5.33)));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (mreal / 5.52)));

            }
        }
    }

    private static class ViewHolder {
        EditText editEntrada;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalcular;
    }
}