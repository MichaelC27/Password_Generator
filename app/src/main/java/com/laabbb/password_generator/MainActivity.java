package com.laabbb.password_generator;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    SeekBar seekBar;
    Button btn_generar;
    TextView lbl_seekbar;
    Handler handler = new Handler();
    LottieAnimationView chk1, chk2, chk3,chk4;
    boolean bchk1 = false, bchk2 = false, bchk3 = false,bchk4=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Aplicar insets de la ventana para el diseño edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias a los componentes de la interfaz
        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        chk4 = findViewById(R.id.chk4);
        toolbar = findViewById(R.id.toolbar);
        seekBar = findViewById(R.id.seekBar);
        btn_generar = findViewById(R.id.btn_generar);
        lbl_seekbar = findViewById(R.id.lbl_seekbar);

        // Establecer la toolbar como la action bar
        setSupportActionBar(toolbar);

        // Configurar el listener para el SeekBar
        // Configurar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Actualizar el texto del TextView cuando cambie el progreso del SeekBar
                lbl_seekbar.setText(String.valueOf(progress));

                // Calcular la posición del texto del TextView para que siga el thumb del SeekBar
                int width = seekBar.getWidth() - seekBar.getPaddingLeft() - seekBar.getPaddingRight();
                int thumbPos = seekBar.getPaddingLeft() + width * seekBar.getProgress() / seekBar.getMax();

                // Medir el ancho del TextView
                lbl_seekbar.measure(0, 0);
                int txtW = lbl_seekbar.getMeasuredWidth();
                int delta = txtW / 2;

                // Ajustar la posición del TextView
                lbl_seekbar.setX(seekBar.getX() + thumbPos - delta);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Mostrar el TextView cuando el usuario comienza a interactuar con el SeekBar
                lbl_seekbar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Ocultar el TextView después de 1 segundos cuando el usuario deja de interactuar con el SeekBar
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lbl_seekbar.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
            }
        });

        //Boton Chek 1
        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bchk1) {
                    // Establecer el cuadro máximo como 50 para mostrar solo la mitad de la animación
                    chk1.setMinFrame(0);
                    chk1.setMaxFrame(50);
                    chk1.setSpeed(2f);
                    chk1.playAnimation();
                    bchk1 = true;

                } else {
                    // Reiniciar la animación para mostrar desde el principio
                    chk1.setMinFrame(0);
                    chk1.setMaxFrame(50); // Establecer el cuadro máximo como la duración total de la animación
                    chk1.setSpeed(-4f);
                    chk1.playAnimation();
                    bchk1 = false;
                }
            }
        });

        //Boton Check 2
        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bchk2) {
                    // Establecer el cuadro máximo como 50 para mostrar solo la mitad de la animación
                    chk2.setMinFrame(0);
                    chk2.setMaxFrame(50);
                    chk2.setSpeed(2f);
                    chk2.playAnimation();
                    bchk2 = true;

                } else {
                    // Reiniciar la animación para mostrar desde el principio
                    chk2.setMinFrame(0);
                    chk2.setMaxFrame(50); // Establecer el cuadro máximo como la duración total de la animación
                    chk2.setSpeed(-4f);
                    chk2.playAnimation();
                    bchk2 = false;
                }
            }
        });
        //Boton Check 3
        chk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bchk3) {
                    // Establecer el cuadro máximo como 50 para mostrar solo la mitad de la animación
                    chk3.setMinFrame(0);
                    chk3.setMaxFrame(50);
                    chk3.setSpeed(2f);
                    chk3.playAnimation();
                    bchk3 = true;

                } else {
                    // Reiniciar la animación para mostrar desde el principio
                    chk3.setMinFrame(0);
                    chk3.setMaxFrame(50); // Establecer el cuadro máximo como la duración total de la animación
                    chk3.setSpeed(-4f);
                    chk3.playAnimation();
                    bchk3 = false;
                }
            }
        });
        //Boton Check 4
        chk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!bchk4) {
                    // Establecer el cuadro máximo como 50 para mostrar solo la mitad de la animación
                    chk4.setMinFrame(0);
                    chk4.setMaxFrame(50);
                    chk4.setSpeed(2f);
                    chk4.playAnimation();
                    bchk4 = true;

                } else {
                    // Reiniciar la animación para mostrar desde el principio
                    chk4.setMinFrame(0);
                    chk4.setMaxFrame(50); // Establecer el cuadro máximo como la duración total de la animación
                    chk4.setSpeed(-4f);
                    chk4.playAnimation();
                    bchk4 = false;
                }
            }
        });


        // Configurar el listener para el botón btn_generar
        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el progreso actual del SeekBar
                int progress = seekBar.getProgress();

                // Mostrar un Toast con la selección actual del SeekBar
                Toast.makeText(MainActivity.this, "Selección del SeekBar: " + progress, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflar el menú, esto añade items a la action bar si está presente
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Manejar las acciones de los items del menú
        if (item.getItemId() == R.id.btn_salir) {
            Toast.makeText(this, "Salir", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.btn_restart) {
            Toast.makeText(this, "Reestablecer", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
