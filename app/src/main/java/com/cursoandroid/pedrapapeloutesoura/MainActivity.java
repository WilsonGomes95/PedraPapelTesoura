package com.cursoandroid.pedrapapeloutesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int vitoriaMaquina = 0;
    int vitoriaJogador = 0;
    String escolhaJogador = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;







        });



    }
    public void selecionadoPedra(View view){
        this.escolhaJogador = "pedra";
        rodada();
    }

    public void selecionadoPapel(View view){
        this.escolhaJogador = "papel";
        rodada();
    }

    public void selecionadoTesoura(View view){
        this.escolhaJogador = "tesoura";
        rodada();
    }


   public String escolhaComputador() {
       String[] opcoes = {"pedra", "papel", "tesoura"};
       int numeroAleatorio = new Random().nextInt(opcoes.length);
       return opcoes[numeroAleatorio];
   }

   public void rodada(){

        String escolhaComputador = escolhaComputador();
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        //ImageView imagePequenaApp = findViewById(R.id.imagePequenaAPPEscolheu);

        switch (escolhaComputador){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                //imagePequenaApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                //imagePequenaApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                //imagePequenaApp.setImageResource(R.drawable.tesoura);
                break;
            default:
                System.out.println("Escolha inválida do computador");
                return;
        }

        /*switch (escolhaJogador){
            case "pedra":
                //imagePequenaApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                //imagePequenaApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
               //imagePequenaApp.setImageResource(R.drawable.tesoura);
                break;
            default:
                System.out.println("Escolha inválida do jogador");
                return;

        }*/



        if(escolhaJogador.equals(escolhaComputador)){
            //System.out.println("Empate!");
            textResultado.setText("Empate!");
        }
        else if((escolhaJogador.equals("pedra") && escolhaComputador.equals("tesoura")) ||
                (escolhaJogador.equals("papel") && escolhaComputador.equals("pedra")) ||
                (escolhaJogador.equals("tesoura") && escolhaComputador.equals("papel"))) {
            //System.out.println("Você ganhou!");
            textResultado.setText("Você ganhou!");
            vitoriaJogador++;
        } else {
            //System.out.println("Você perdeu!");
            textResultado.setText("Você perdeu!");
            vitoriaMaquina++;
        }

   }





}