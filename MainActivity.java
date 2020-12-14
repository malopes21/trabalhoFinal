package com.example.clientbandas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.clientbandas.domain.Banda;
import com.example.clientbandas.repositories.BandaRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	//comentário

    private BandaRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        permissions();
        initRepositories();
        initComponents();
    }

    private void initRepositories() {
        repository = new BandaRepository();
    }

    private void permissions() {
        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    private void initComponents() {
        initBtnGet();
        initBtnPost();
        initBtnListAll();
    }

    private void initBtnListAll() {
        Button btnList = findViewById(R.id.btnList);
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Banda> bandas = repository.findAll();
                ArrayAdapter<Banda> adapter = new ArrayAdapter<Banda>(
                        getApplicationContext(), android.R.layout.simple_list_item_1);
                adapter.clear();
                final ListView lvBandas = findViewById(R.id.lvBandas);
                lvBandas.setAdapter(adapter);
                adapter.addAll(bandas);
            }
        });
    }

    private void initBtnPost() {
        Button btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtId = findViewById(R.id.txtId);
                EditText txtNome = findViewById(R.id.txtNome);
                EditText txtAnoFormacao = findViewById(R.id.txtAnoFormacao);
                try {
                    Banda banda = new Banda();
                    banda.setNome(txtNome.getText().toString());
                    banda.setAnoDeFormacao(Integer.parseInt(txtAnoFormacao.getText().toString()));
                    banda = repository.create(banda);
                    txtId.setText(banda.getId().toString());
                }catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initBtnGet() {
        Button btnGet = findViewById(R.id.btnGet);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtId = findViewById(R.id.txtId);
                EditText txtNome = findViewById(R.id.txtNome);
                EditText txtAnoFormacao = findViewById(R.id.txtAnoFormacao);
                Long bandaId = Long.parseLong(txtId.getText().toString());
                try {
                    Banda banda = repository.get(bandaId);
                    txtNome.setText(banda.getNome());
                    txtAnoFormacao.setText(String.valueOf(banda.getAnoDeFormacao()));
                }catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Erro: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                    txtNome.setText("");
                    txtAnoFormacao.setText("");
                }
            }
        });
    }
}
