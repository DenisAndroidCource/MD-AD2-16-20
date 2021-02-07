package by.it.academy.mapsexample

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.SupportMapFragment
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions
import com.google.android.libraries.maps.model.PolylineOptions

private const val LOCATION_PERMISSION_CODE = 1000

class MainActivity : AppCompatActivity() {

    private var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.mapFragmentContainer) as? SupportMapFragment?
        mapFragment?.run {
            getMapAsync { map -> initMap(map) }
        }
    }

    private fun initMap(map: GoogleMap) {
        googleMap = map.apply {
            val startLocation = LatLng(53.904133, 27.557541)
            val cameraLocation = CameraUpdateFactory.newLatLngZoom(startLocation, 10.0f)
            moveCamera(cameraLocation)
            if (checkLocationPermission()) {
                isMyLocationEnabled = true
            } else {
                askLocationPermission()
            }
        }

        addNewMarker(LatLng(53.899328, 27.528687))
        addNewMarker(LatLng(53.142566, 29.244285))
        addNewMarker(LatLng(52.425698, 31.030799))
        addPolyline(LatLng(53.899328, 27.528687), LatLng(52.425698, 31.030799))

        googleMap?.setOnMapClickListener { location -> addNewMarker(location) }
//        googleMap?.setOnMarkerClickListener {  }
    }

    private fun addNewMarker(markerPosition: LatLng) {
        val icon = BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_explore_24)
        val markerOptions = MarkerOptions()
            .position(markerPosition)
//            .icon(BitmapDescriptorFactory.fromBitmap(icon))
            .title("Marker title with position $markerPosition")
        googleMap?.addMarker(markerOptions)
    }

    private fun addPolyline(position1: LatLng, position2: LatLng) {
        val polylineOptions = PolylineOptions()
            .add(position1)
            .add(position2)
            .color(Color.MAGENTA)
        googleMap?.addPolyline(polylineOptions)
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == LOCATION_PERMISSION_CODE && grantResults[0] == PERMISSION_GRANTED) {
            googleMap?.isMyLocationEnabled = true
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun checkLocationPermission() =
        ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) == PERMISSION_GRANTED

    private fun askLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(ACCESS_FINE_LOCATION),
            LOCATION_PERMISSION_CODE
        )
    }
}