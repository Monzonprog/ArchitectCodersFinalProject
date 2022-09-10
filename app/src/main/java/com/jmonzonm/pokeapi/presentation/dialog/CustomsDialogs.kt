package com.jmonzonm.pokeapi.presentation.dialog

import android.app.Activity
import android.app.Dialog
import android.widget.Button
import com.jmonzonm.pokeapi.R

class CustomsDialogs {

    fun showGreetingsDialog(activity: Activity) {
        val dialog = Dialog(activity)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_layout)
        val yesBtn = dialog.findViewById(R.id.btOk) as Button
        yesBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }
}