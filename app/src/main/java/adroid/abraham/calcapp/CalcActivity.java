package adroid.abraham.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalcActivity extends AppCompatActivity {
    Button btncero, btn7, btn8, btn9,
            btn1, btn2, btn3,
            btn4, btn5, btn6, btndivision,
            btndecimal, btnigual, btnce;
    EditText edtVisor;
    double numeroVisor = 0;
    double primerValor = 0;
    boolean esDecimal = false;
    String operacion = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        edtVisor = findViewById(R.id.edt_visor); // Instanciamos el edittext
        edtVisor.setEnabled(false);
        btn1 = findViewById(R.id.btn1); // Instanciamos el boton 7
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(1);
                setVisor();
            }
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(2);
                setVisor();
            }
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(3);
                setVisor();
            }
        });

        btn4 = findViewById(R.id.btn4); // Instanciamos el boton 7
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(4);
                setVisor();
            }
        });

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(5);
                setVisor();
            }
        });

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(6);
                setVisor();
            }
        });

        btn7 = findViewById(R.id.btn7); // Instanciamos el boton 7
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(7);
                setVisor();
            }
        });

        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(8);
                setVisor();
            }
        });

        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(9);
                setVisor();
            }
        });
        btncero = findViewById(R.id.btncero);
        btncero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero(0);
                setVisor();
            }
        });
        btnce = findViewById(R.id.btnce);
        btnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroVisor = 0;
                primerValor = 0;
                operacion = "";
                esDecimal = false;
                setVisor();
            }
        });

        btndivision = findViewById(R.id.btndivision);
        btndivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operacion = "/";
                primerValor = numeroVisor;
                numeroVisor = 0;
                esDecimal = false;
                setVisor();
            }
        });
        btnigual = findViewById(R.id.btnigual);
        btnigual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( operacion.equals("/") ) {
                    numeroVisor = primerValor / numeroVisor;
                    setVisor();
                }
            }
        });
        btndecimal = findViewById(R.id.btndecimal);
        btndecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                esDecimal = true;
            }
        });

    }
    void numero(int n) {
        if ( numeroVisor != 0 ) {
            if ( esDecimal ) { // 0.455 10.345
                String decimalStr = Double.toString(numeroVisor);
                String[] bloques = decimalStr.split("\\.");
                if ( bloques.length > 0 ) {
                    int p = bloques[1].length() + 1;
                    numeroVisor += n / Math.pow(10, p);
                } else {
                    numeroVisor = (numeroVisor * 10) + n;
                }
            } else {
                numeroVisor = (numeroVisor * 10) + n;
            }
        } else {
            if ( esDecimal ) { // 0.5   0.6
                numeroVisor += n * 0.1;
            } else {
                numeroVisor = n;
            }
        }
    }
    void setVisor() {
        edtVisor.setText("" + numeroVisor);
    }
}
