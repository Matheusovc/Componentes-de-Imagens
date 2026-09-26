package com.example.visualizandoimagens2;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class VisualizandoImagensActivity extends Activity {

    ImageSwitcher imgFoto, imgSobre;

    Button btanterior, btproximo;

    int indice = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizando_imagens);

        //Carrega o objeto de animação de entrada da imagem
        Animation in = AnimationUtils.loadAnimation
                (this, android.R.anim.slide_in_left);

        //Carrega o objeto de animação de saída de imagem
        Animation out = AnimationUtils.loadAnimation
                (this, android.R.anim.slide_out_right);

        imgFoto = (ImageSwitcher) findViewById(R.id.imgFoto);

        imgFoto.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(ActionBar.
                        LayoutParams.MATCH_PARENT,
                        ActionBar.LayoutParams.MATCH_PARENT));
                return myView;
            }
        });

        imgSobre = (ImageSwitcher) findViewById(R.id.imgSobre);

        imgSobre.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_XY);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(ActionBar.
                        LayoutParams.MATCH_PARENT,
                        ActionBar.LayoutParams.MATCH_PARENT));
                return myView;
            }
        });

        btanterior = (Button) findViewById(R.id.btanterior);
        btproximo = (Button) findViewById(R.id.btproximo);

        //Carrega a foto do dead pool
        imgFoto.setImageResource(R.drawable.foto_deadpool);
        imgFoto.setInAnimation(in);
        imgFoto.setOutAnimation(out);

        //Carrega a info sobre o dead pool
        imgSobre.setImageResource(R.drawable.frase_sobre_deadpool);
        imgSobre.setInAnimation(in);
        imgSobre.setOutAnimation(out);

        btanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (indice > 1)
                {
                    indice--;
                    mostrarInfoPersonagem();
                }
            }
        });

        btproximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Agora sao 4 personagens (exercicio: acrescentado o Cable)
                if (indice < 4)
                {
                    indice++;
                    mostrarInfoPersonagem();
                }
            }
        });
    }

    public void mostrarInfoPersonagem()
    {
        switch (indice)
        {
            case 1:
            {
                imgFoto.setImageResource(R.drawable.foto_deadpool);
                imgSobre.setImageResource(R.drawable.frase_sobre_deadpool);

            }break;
            case 2:
            {
                imgFoto.setImageResource(R.drawable.foto_colossus);
                imgSobre.setImageResource(R.drawable.frase_sobre_colossus);

            }break;
            case 3:
            {
                imgFoto.setImageResource(R.drawable.foto_megasonico);
                imgSobre.setImageResource(R.drawable.frase_sobre_megasonico);

            }break;
            case 4:
            {
                //Exercicio: quarto personagem
                imgFoto.setImageResource(R.drawable.foto_cable);
                imgSobre.setImageResource(R.drawable.frase_sobre_cable);

            }break;

        }
    }
}
