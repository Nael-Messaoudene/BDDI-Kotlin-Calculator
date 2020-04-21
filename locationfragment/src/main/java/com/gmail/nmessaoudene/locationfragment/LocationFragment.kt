package com.gmail.nmessaoudene.locationfragment


import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


class LocationFragment : Fragment(){

    private lateinit var fusedLocationClient: FusedLocationProviderClient

// Declare values on
    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            context,
            android.R.string.yes, Toast.LENGTH_SHORT
        ).show()
        requestPermissions()
    }
    val negativeButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            context,
            android.R.string.no, Toast.LENGTH_SHORT
        ).show()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val context = context ?: return

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)


        var result = view.findViewById<AppCompatTextView>(R.id.userlocation)

        if (context.let {
                ContextCompat.checkSelfPermission(it, Manifest.permission.ACCESS_FINE_LOCATION) } != PackageManager.PERMISSION_GRANTED) {

            Log.d("Error", "Utilisateur pas accorder")

            if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                Log.d("Error", "Vous avez refusé la géolocalisation")

                val builder = AlertDialog.Builder(context)
                builder.setTitle("Permission obligatoire !")
                builder.setMessage("Nous avons besoin de la permission afin de déterminer votre position GPS ")
                builder.setPositiveButton(
                    "ok",
                    DialogInterface.OnClickListener(function = positiveButtonClick)
                )

                builder.setNegativeButton(
                    android.R.string.no,
                    DialogInterface.OnClickListener(function = negativeButtonClick)
                )
                builder.show()

            } else {

                requestPermissions()
            }
        }else {
            Log.d("Error", "accordé")
            displayLocation(result)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray ) {
        val result = view?.findViewById<AppCompatTextView>(R.id.userlocation)
        if (result != null) {
            when (requestCode) {
                2 -> {
                    if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                        displayLocation(result)

                    } else {
                        result.text = "Error"
                    }
                }
                else -> {
                    //
                }
            }
        }
    }

    private fun requestPermissions() {
        requestPermissions(
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            2
        )
    }

    private fun displayLocation(result: AppCompatTextView){
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                // Got last known location. In some rare situations this can be null.
                val lat = location?.latitude.toString()
                val lon = location?.longitude.toString()

                result.text = "Longitude: ${lon} \n Latitude: ${lat}"
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