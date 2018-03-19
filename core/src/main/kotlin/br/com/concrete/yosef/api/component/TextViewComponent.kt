package br.com.concrete.yosef.api.component

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import br.com.concrete.yosef.OnActionListener
import br.com.concrete.yosef.api.property.DynamicPropertyCommand
import br.com.concrete.yosef.api.property.id.IdCommand
import br.com.concrete.yosef.api.property.id.IdCommand.Companion.ID
import br.com.concrete.yosef.api.property.text.TextColorCommand
import br.com.concrete.yosef.api.property.text.TextColorCommand.Companion.TEXT_COLOR
import br.com.concrete.yosef.api.property.text.TextCommand
import br.com.concrete.yosef.api.property.text.TextCommand.Companion.TEXT
import br.com.concrete.yosef.api.property.text.TextSizeCommand
import br.com.concrete.yosef.api.property.text.TextSizeCommand.Companion.TEXT_SIZE
import br.com.concrete.yosef.api.property.text.TextStyleCommand
import br.com.concrete.yosef.api.property.text.TextStyleCommand.Companion.TEXT_STYLE
import br.com.concrete.yosef.entity.DynamicProperty

/**
 * Class that implements the [Component] interface and creates the component
 * TextView([TextView]), applying its properties
 */
class TextViewComponent : Component {

    companion object {
        const val TEXT_TYPE: String = "text"
    }

    private val commands: Map<String, DynamicPropertyCommand> = mapOf(
        TEXT to TextCommand(),
        TEXT_COLOR to TextColorCommand(),
        TEXT_SIZE to TextSizeCommand(),
        ID to IdCommand(),
        TEXT_STYLE to TextStyleCommand()
    )

    override fun applyProperties(
        view: View,
        dynamicProperties: List<DynamicProperty>,
        actionListener: OnActionListener?
    ) {
        dynamicProperties.forEach {
            commands[it.name]?.apply(view, it)
        }
    }

    override fun createView(parent: ViewGroup): View {
        return TextView(parent.context).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }
}
