package br.com.concrete.yosef.glide.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import br.com.concrete.yosef.OnActionListener
import br.com.concrete.yosef.api.DynamicViewCreator
import br.com.concrete.yosef.glide.GlideImageComponent
import br.com.concrete.yosef.glide.test.R

class ImageActivity : AppCompatActivity(), OnActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val json = ImageActivity::class.java.getResource(
            "/assets/example_image.json").readText()

        val dynamicView = DynamicViewCreator.Builder()
            .addComponentFor(GlideImageComponent.IMAGE_TYPE, GlideImageComponent())
            .build()

        setContentView(dynamicView.createViewFromJson(this, json, this))
    }

    override fun callAction(value: String) {
        findViewById<TextView>(R.id.textview).text = value
    }
}
