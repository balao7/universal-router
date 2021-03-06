package nolambda.linkrouter.examples

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_simple.*
import nolambda.linkrouter.examples.notsimple.NotSimpleActivity

class MainActivity : AppCompatActivity() {

    private val router by lazy { FragmentRouter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_simple)

        btnNavigate.setOnClickListener {
            startActivity(Intent(applicationContext, NotSimpleActivity::class.java))
        }

        btnNavigateTwo.setOnClickListener {
            router.goTo("sample://fragment/first")

            val handler = Handler(Looper.getMainLooper())

            handler.postDelayed({
                router.goTo("sample://fragment/second")
            }, 2000)

            handler.postDelayed({
                router.goTo("sample://fragment/third")
            }, 5000)
        }
    }
}
