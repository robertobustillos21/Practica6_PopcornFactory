package bustillos.roberto.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MovieDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        var bundle = intent.extras

        if(bundle != null){

            var detalle_sinopsis = findViewById<TextView>(R.id.detalle_sinopsis)
            var detalle_imagen = findViewById<ImageView>(R.id.detalle_imagen)
            var detalle_titulo = findViewById<TextView>(R.id.detalle_titulo)

            detalle_sinopsis.text = bundle.getString("sinopsis")
            detalle_imagen.setImageResource(bundle.getInt("image"))
            detalle_titulo.text = title

        }
    }
}