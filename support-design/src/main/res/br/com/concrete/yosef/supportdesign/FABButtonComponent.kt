package br.com.concrete.yosef.supportdesign

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.view.View
import android.view.ViewGroup
import br.com.concrete.yosef.OnActionListener
import br.com.concrete.yosef.api.component.Component
import br.com.concrete.yosef.api.property.DynamicPropertyCommand
import br.com.concrete.yosef.api.property.color.BackgroundColorCommand
import br.com.concrete.yosef.api.property.id.IdCommand
import br.com.concrete.yosef.api.property.spacing.MarginPropertyCommand
import br.com.concrete.yosef.api.property.spacing.PaddingPropertyCommand
import br.com.concrete.yosef.api.property.text.TextColorCommand
import br.com.concrete.yosef.api.property.text.TextCommand
import br.com.concrete.yosef.entity.DynamicProperty

/**
 * Class that implements the [Component] interface and creates the component
 * FABButton([FloatingActionButton]), applying its properties
 */
class FABButtonComponent : Component {

    companion object {
        /**
         * This constant documents which type is associated with the component
         */
        const val FAB_BUTTON_TYPE = "fabButton"
        private const val ACTION = "action"
    }

    private val commands: Map<String, DynamicPropertyCommand> = mapOf(
        TextCommand.TEXT to TextCommand(),
        TextColorCommand.TEXT_COLOR to TextColorCommand(),
        BackgroundColorCommand.BACKGROUND_COLOR to BackgroundColorCommand(),
        PaddingPropertyCommand.PADDING to PaddingPropertyCommand(),
        MarginPropertyCommand.MARGIN to MarginPropertyCommand(),
        IdCommand.ID to IdCommand()
    )

    override fun createView(context: Context): View {
        return FloatingActionButton(context).apply {
            this.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    override fun applyProperties(
        view: View,
        dynamicProperties: List<DynamicProperty>,
        actionListener: OnActionListener?
    ) {
        (view as FloatingActionButton).setOnClickListener {
            val dynamicWithAction = dynamicProperties.find { FABButtonComponent.ACTION == it.name }
            dynamicWithAction?.value?.let { actionListener?.callAction(it) }
        }
        dynamicProperties.forEach {
            commands[it.name]?.apply(view, it)
        }
    }
}