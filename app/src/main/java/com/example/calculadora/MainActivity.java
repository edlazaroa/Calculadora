package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    double numero1 = 0;
    double numero2 = 0;
    double memoria = 0;

    String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView txtPantalla = findViewById(R.id.txtPantalla);

        Button btnPunt = findViewById(R.id.btnPunt);
        Button btnC = findViewById(R.id.btnBorrar);
        Button btnIgual = findViewById(R.id.btnIgual);

        Button btnSumar = findViewById(R.id.btnSuma);
        Button btnRestar = findViewById(R.id.btnResta);
        Button btnMultiplicar = findViewById(R.id.btnMultiplicacio);
        Button btnDividir = findViewById(R.id.btnDivisio);

        Button btnMC = findViewById(R.id.btnMc);
        Button btnMR = findViewById(R.id.btnMr);
        Button btnMSumar = findViewById(R.id.btnMSuma);
        Button btnMRestar = findViewById(R.id.btnMResta);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);


        View.OnClickListener listenerNumeros = view -> {
            Button boto = (Button) view;

            String numero = boto.getText().toString();
            String pantalla = txtPantalla.getText().toString();

            if (numero.equals(".")) {
                if (!pantalla.contains(".")) {
                    txtPantalla.setText(pantalla + ".");
                }

            } else {
                if (pantalla.equals("0")) {
                    txtPantalla.setText(numero);

                } else {
                    txtPantalla.setText(pantalla + numero);
                }
            }
        };


        btn0.setOnClickListener(listenerNumeros);
        btn1.setOnClickListener(listenerNumeros);
        btn2.setOnClickListener(listenerNumeros);
        btn3.setOnClickListener(listenerNumeros);
        btn4.setOnClickListener(listenerNumeros);
        btn5.setOnClickListener(listenerNumeros);
        btn6.setOnClickListener(listenerNumeros);
        btn7.setOnClickListener(listenerNumeros);
        btn8.setOnClickListener(listenerNumeros);
        btn9.setOnClickListener(listenerNumeros);
        btnPunt.setOnClickListener(listenerNumeros);


        View.OnClickListener listenerOperacions = view -> {

            Button boto = (Button) view;

            String signe = boto.getText().toString();
            String pantalla = txtPantalla.getText().toString();


            switch (signe) {
                case "+":
                    numero1 = Double.parseDouble(pantalla);
                    operacion = "+";

                    txtPantalla.setText("0");
                    break;

                case "-":
                    numero1 = Double.parseDouble(pantalla);
                    operacion = "-";

                    txtPantalla.setText("0");
                    break;

                case "X":
                    numero1 = Double.parseDouble(pantalla);
                    operacion = "X";

                    txtPantalla.setText("0");
                    break;

                case "÷":
                    numero1 = Double.parseDouble(pantalla);
                    operacion = "÷";

                    txtPantalla.setText("0");
                    break;

                case "=":
                    numero2 = Double.parseDouble(pantalla);
                    double resultado = 0;

                    switch (operacion) {
                        case "+":
                            resultado = numero1 + numero2;
                            break;

                        case "-":
                            resultado = numero1 - numero2;
                            break;

                        case "X":
                            resultado = numero1 * numero2;
                            break;

                        case "÷":
                            if (numero2 == 0) {
                                txtPantalla.setText("Error");
                                return;
                            }
                            resultado = numero1 / numero2;
                            break;
                    }
                    txtPantalla.setText(String.valueOf(resultado));
                    break;

                case "C":
                    txtPantalla.setText("0");

                    numero1 = 0;
                    numero2 = 0;
                    operacion = "";

                    break;

                case "MC":
                    memoria = 0;
                    break;

                case "MR":
                    txtPantalla.setText(String.valueOf(memoria));
                    break;

                case "M+":
                    memoria = memoria + Double.parseDouble(pantalla);
                    break;

                case "M-":
                    memoria = memoria - Double.parseDouble(pantalla);
                    break;
            }
        };


        btnSumar.setOnClickListener(listenerOperacions);
        btnRestar.setOnClickListener(listenerOperacions);
        btnMultiplicar.setOnClickListener(listenerOperacions);
        btnDividir.setOnClickListener(listenerOperacions);

        btnIgual.setOnClickListener(listenerOperacions);
        btnC.setOnClickListener(listenerOperacions);

        btnMC.setOnClickListener(listenerOperacions);
        btnMR.setOnClickListener(listenerOperacions);
        btnMSumar.setOnClickListener(listenerOperacions);
        btnMRestar.setOnClickListener(listenerOperacions);

/*
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                }
        );*/
    }
}