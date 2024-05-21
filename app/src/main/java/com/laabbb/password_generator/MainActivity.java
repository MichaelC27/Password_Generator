package com.laabbb.password_generator;

import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    SeekBar seekBar;
    Button btn_generar;
    TextView lbl_seekbar;

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
                // Opcional: Puedes manejar el evento cuando se empieza a interactuar con el SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Opcional: Puedes manejar el evento cuando se deja de interactuar con el SeekBar
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
