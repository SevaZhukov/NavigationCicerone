package com.navigationcicerone.domain

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.androidnavigation.auth.AuthActivity
import com.androidnavigation.main.MainActivity
import com.navigationcicerone.domain.keys.Screens
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import ru.terrakok.cicerone.commands.SystemMessage

class GlobalNavigator(val activity: Activity) : Navigator {
    override fun applyCommands(commands: Array<out Command>) {
        val command = commands[0]
        if (command is Forward) {
            val intent: Intent
            when (command.screenKey) {
                Screens.MAIN.name -> {
                    intent = Intent(activity, MainActivity::class.java)
                    activity.startActivity(intent)
                    activity.finish()
                }
                Screens.AUTH.name -> {
                    intent = Intent(activity, AuthActivity::class.java)
                    activity.startActivity(intent)
                    activity.finish()
                }
            }
        } else if (command is SystemMessage) {
            Toast.makeText(activity, "Сообщение", Toast.LENGTH_SHORT).show()
        }
    }
}