package wintersteve25.tau.components;

import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.IRenderable;
import wintersteve25.tau.components.base.DynamicUIComponent;
import wintersteve25.tau.build.UIBuilder;
import wintersteve25.tau.components.base.PrimitiveUIComponent;
import wintersteve25.tau.components.base.UIComponent;
import wintersteve25.tau.layout.Axis;
import wintersteve25.tau.layout.Layout;
import wintersteve25.tau.layout.LayoutSetting;
import wintersteve25.tau.utils.Vector2i;

import java.util.List;

public final class Center implements PrimitiveUIComponent {
    
    private final UIComponent child;
    
    public Center(UIComponent child) {
        this.child = child;
    }
    
    @Override
    public Vector2i build(Layout layout, List<IRenderable> renderables, List<DynamicUIComponent> dynamicUIComponents, List<IGuiEventListener> eventListeners) {
        layout.pushLayoutSetting(Axis.HORIZONTAL, LayoutSetting.CENTER);
        layout.pushLayoutSetting(Axis.VERTICAL, LayoutSetting.CENTER);

        Vector2i size = UIBuilder.build(layout, child, renderables, dynamicUIComponents, eventListeners);

        layout.popLayoutSetting(Axis.HORIZONTAL);
        layout.popLayoutSetting(Axis.VERTICAL);
    
        return size;
    }
}