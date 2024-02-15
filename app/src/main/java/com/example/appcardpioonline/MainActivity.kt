package com.example.appcardpioonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.appcardpioonline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
        binding.buttonOrder.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calculate){
            calculate()
        }else if(view.id == R.id.button_order){
            finish_order()
        }
    }

    private fun calculate(){
        var potato_price = 0.0f
        var salmon_price = 0.0f
        var shrimp_price = 0.0f
        var squid_price = 0.0f
        var lobster_price = 0.0f
        var chicken_price = 0.0f
        var steak_price = 0.0f
        var fillet_price = 0.0f
        var soda_price = 0.0f
        var juice_price = 0.0f
        var sum = 0.0f

        if(binding.textPotatoesCheckBox.isChecked){
            val formated_price_potato = converterPrice(binding.textPotatoesPrice)
            potato_price+=formated_price_potato
        }else if(!binding.textPotatoesCheckBox.isChecked){
            potato_price = 0.0f
        //Toast.makeText(this, "Operação malsucedida",  Toast.LENGTH_SHORT).show()
        }

        if(binding.textSalmonCheckbox.isChecked){
            val formated_price_salmon = converterPrice(binding.textSalmonPrice)
            salmon_price+=formated_price_salmon
        }else if(!binding.textSalmonCheckbox.isChecked){
            salmon_price = 0.0f
        }

        if(binding.textShrimpCheckbox.isChecked){
            val formated_price_shrimp = converterPrice(binding.textShrimpPrice)
            shrimp_price+=formated_price_shrimp
        }else if(!binding.textShrimpCheckbox.isChecked){
            shrimp_price = 0.0f
        }

        if(binding.textSquidCheckbox.isChecked){
            val formated_price_squid = converterPrice(binding.textSquidPrice)
            squid_price+=formated_price_squid
        }else if(!binding.textSquidCheckbox.isChecked){
            squid_price = 0.0f
        }

        if(binding.textLobsterCheckbox.isChecked){
            val formated_price_lobster = converterPrice(binding.textLobsterPrice)
            lobster_price+=formated_price_lobster
        }else if(!binding.textLobsterCheckbox.isActivated){
            lobster_price = 0.0f
        }

        if(binding.textChickenCheckbox.isChecked){
            val formated_price_chicken = converterPrice(binding.textChickenPrice)
            chicken_price+=formated_price_chicken
        }else if(!binding.textChickenCheckbox.isActivated){
            chicken_price = 0.0f
        }

        if(binding.textSteakCheckbox.isChecked){
            val formated_price_steak = converterPrice(binding.textSteakPrice)
            steak_price+=formated_price_steak
        }else if(!binding.textSteakCheckbox.isActivated){
            steak_price = 0.0f
        }

        if(binding.textFilletCheckbox.isChecked){
            val formated_price_fillet = converterPrice(binding.textFilletPrice)
            fillet_price+=formated_price_fillet
        }else if(!binding.textFilletCheckbox.isActivated){
            fillet_price = 0.0f
        }

        if(binding.textSodaCheckbox.isChecked){
            val formated_price_soda = converterPrice(binding.textSodaPrice)
            soda_price+=formated_price_soda
        }else if(!binding.textSodaCheckbox.isActivated){
            soda_price = 0.0f
        }

        if(binding.textJuiceCheckbox.isChecked){
            val formated_price_juice = converterPrice(binding.textJuicePrice)
            juice_price+=formated_price_juice
        }else if(!binding.textJuiceCheckbox.isActivated){
            juice_price = 0.0f
        }

        sum = potato_price + salmon_price + shrimp_price +
                squid_price + lobster_price + chicken_price +
                steak_price + fillet_price + soda_price + juice_price

        if(sum == 0.0f){
            Toast.makeText(this, "Por favor, escolha uma opção para calcular o valor",  Toast.LENGTH_LONG).show()
        }else{
            binding.textResult.text = "R$ ${"%.2f".format(sum)}"
        }
    }

    private fun isNotchecked(): Boolean{
        return (!binding.textPotatoesCheckBox.isChecked) && (!binding.textSalmonCheckbox.isChecked)
                && (!binding.textShrimpCheckbox.isChecked) && (!binding.textSquidCheckbox.isChecked)
                && (!binding.textLobsterCheckbox.isActivated) && (!binding.textChickenCheckbox.isChecked)
                && (!binding.textSteakCheckbox.isActivated) && (!binding.textFilletCheckbox.isChecked)
                && (!binding.textSodaCheckbox.isChecked) && (!binding.textJuiceCheckbox.isChecked)
    }

    private fun converterPrice(textView: TextView): Float{
        val priceString = textView.text.toString()
        val priceWithoutCurrency = priceString.substring(2).toFloat()
        return priceWithoutCurrency
    }

    private fun finish_order(){
        if(isNotchecked().not()){
            Toast.makeText(this, "Pedido concluido com sucesso",  Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "Seu pedido deve ter pelo menos um produto escolhido",  Toast.LENGTH_LONG).show()
        }

    }


}