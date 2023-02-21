package bustillos.roberto.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        var bundle = intent.extras
        var ns = 0;
        var id = -1;
        var title = "";

        if(bundle != null){
            var ns = bundle.getInt("numberSeats")
            title = bundle.getString("titulo")!!
            var detalle_sinopsis = findViewById<TextView>(R.id.detalle_sinopsis)
            var detalle_imagen = findViewById<ImageView>(R.id.detalle_imagen)
            var detalle_titulo = findViewById<TextView>(R.id.detalle_titulo)
            var seatsLeft = findViewById<TextView>(R.id.seatsLeft)

            detalle_sinopsis.text = bundle.getString("sinopsis")
            detalle_imagen.setImageResource(bundle.getInt("image"))
            detalle_titulo.text = title
            seatsLeft.setText("$ns seats available ")
            id = bundle.getInt("pos")


        }

        if(ns==0) {
            buyTickets.isActivated = false
        } else {

            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)

                this.startActivity(intent)
            }
        }
    }
}