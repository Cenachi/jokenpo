package com.example.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageButton
import android.widget.Toast
import com.example.jokenpo.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(),  OnClickListener{

    lateinit var binding: ActivityMainBinding
    lateinit var listarBotoes: List<ImageButton>

    var contCpu = 0
    var contUser = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttons()
    }

    private fun buttons() {
        listarBotoes = listOf(binding.btnTesoura, binding.btnPedra, binding.btnPapel)
        listarBotoes.forEach { botao ->
            botao.setOnClickListener(this)
        }

        binding.btnJogar.setOnClickListener(this)
    }

    override fun onClick(botao: View?) {
        when(botao?.id) {
            binding.btnTesoura.id -> {
                binding.escolha.setText("Sua Escolha: TESOURA")
                score("Tesoura")
            }
            binding.btnPedra.id -> {
                binding.escolha.setText("Sua Escolha: PEDRA")
                score("Pedra")
            }
            binding.btnPapel.id -> {
                binding.escolha.setText("Sua Escolha: PAPEL")
                score("Papel")
            }

            binding.btnJogar.id -> {
                binding.escolha.setText("Sua Escolha:")
                binding.cpu.setText("Escolha CPU:")
            }
        }
    }

    private fun cpuChoice(): String {
        val escolhaCpu = listOf("Tesoura", "Pedra", "Papel")
        val numero = (0..2).random()
        binding.cpu.setText("Escolha CPU: ${escolhaCpu[numero].uppercase()}")
        return escolhaCpu[numero]
    }

    private fun score(escolha : String){
        val escolhaCpu = cpuChoice()
        val escolhaJogador = escolha

        if (escolhaCpu == escolhaJogador){
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show()
        } else if (escolhaCpu == "Tesoura" && escolhaJogador == "Papel"){
            contCpu+=1
            binding.placar.setText("$contUser  :  $contCpu")
        } else if (escolhaCpu == "Tesoura" && escolhaJogador == "Pedra"){
            contUser+=1
            binding.placar.setText("$contUser  :  $contCpu")
        } else if (escolhaCpu == "Pedra" && escolhaJogador == "Tesoura"){
            contCpu+=1
            binding.placar.setText("$contUser  :  $contCpu")
        } else if (escolhaCpu == "Pedra" && escolhaJogador == "Papel"){
            contUser+=1
            binding.placar.setText("$contUser  :  $contCpu")
        } else if (escolhaCpu == "Papel" && escolhaJogador == "Tesoura"){
            contUser+=1
            binding.placar.setText("$contUser  :  $contCpu")
        } else if (escolhaCpu == "Papel" && escolhaJogador == "Pedra"){
            contCpu+=1
            binding.placar.setText("$contUser  :  $contCpu")
        }
    }
}