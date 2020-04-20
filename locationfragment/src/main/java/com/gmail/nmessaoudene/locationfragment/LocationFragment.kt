package com.gmail.nmessaoudene.locationfragment

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import android.content.DialogInterface


import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class LocationFragment : Fragment(){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.fragbtn)
        var user= view.findViewById<AppCompatTextView>(R.id.userlocation)


        if (context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED
        ) {

            // la permission n’est pas accordée
            Log.d("Error", "pas accordé")

            if(shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)){
                // CREER UNE DIALOG

                val builder = AlertDialog.Builder(context)
                builder.setTitle(" Permission obligatoire")
                builder.setMessage("Nous avons besoin de la permission afin de déterminer votre position GPS")

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 2)
                }

                builder.setNegativeButton(android.R.string.no) { dialog, which ->
                    user.text = "Vous avez refusé la localisation"
                }

                builder.show()

            }
            else{
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 2)
            }

        } else {
            Log.d("Error", "accordé")

            user.text = "Accordé"
        }



        button.setOnClickListener {
            println("EKKKKKKKKk")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.location_fragment, container, false)
    }

}