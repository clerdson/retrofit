package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText)findViewById(R.id.editText);
        final TextView name = (TextView)findViewById(R.id.textView);
        final Button button = (Button)findViewById(R.id.button3);
        final ImageView imageView = (ImageView)findViewById(R.id.imageView2);
        final TextView id  = (TextView)findViewById(R.id.textView2);
        final Button tela2  = (Button)findViewById(R.id.button4);

        tela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Call<Usuario> call  = new RetrofitConfig().getUsuarioService().BuscarUsers(editText.getText().toString());

              call.enqueue(new Callback<Usuario>() {
                  @Override
                  public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                      Usuario usuario = response.body();
                      Picasso.get().load(usuario.avatar_url).into(imageView);
                     name.setText(usuario.name);
                     id.setText(String.valueOf(usuario.id));
                      //Toast.makeText(getBaseContext(),"nome do user"+ usuario.name,Toast.LENGTH_LONG).show();
                  }

                  @Override
                  public void onFailure(Call<Usuario> call, Throwable t) {
                      Log.e("CEPService   ", "Erro ao buscar o cep:" + t.getMessage());
                  }
              });
            }
        });



    }
    public void sendMessage(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
