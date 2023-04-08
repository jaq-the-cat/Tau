package com.github.wintersteve25.tau.renderer;

import com.github.wintersteve25.tau.theme.DefaultColorScheme;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.IRenderable;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.StringTextComponent;
import com.github.wintersteve25.tau.components.base.DynamicUIComponent;
import com.github.wintersteve25.tau.build.UIBuilder;
import com.github.wintersteve25.tau.components.base.UIComponent;
import com.github.wintersteve25.tau.layout.Layout;

import java.util.ArrayList;
import java.util.List;

public class ScreenUIRenderer extends Screen {
    
    private final UIComponent uiComponent;
    private final List<IRenderable> components;
    private final List<IRenderable> tooltips;
    private final List<DynamicUIComponent> dynamicUIComponents;
    
    private boolean built;
    
    public ScreenUIRenderer(UIComponent uiComponent) {
        super(StringTextComponent.EMPTY);
        this.uiComponent = uiComponent;
        this.components = new ArrayList<>();
        this.tooltips = new ArrayList<>();
        this.dynamicUIComponents = new ArrayList<>();
    }

    @Override
    protected void init() {
        Layout layout = new Layout(width, height, DefaultColorScheme.INSTANCE);

        components.clear();
        tooltips.clear();
        dynamicUIComponents.clear();
        
        UIBuilder.build(layout, uiComponent, components, tooltips, dynamicUIComponents, children);
        
        built = true;
    }

    @Override
    public void tick() {
        if (!built) return;
        
        for (DynamicUIComponent dynamicUIComponent : dynamicUIComponents) {
            dynamicUIComponent.tick();
        }
    }
    
    @Override
    public void render(MatrixStack matrixStack, int pMouseX, int pMouseY, float pPartialTicks) {
        this.renderBackground(matrixStack);
        
        for (IRenderable component : components) {
            component.render(matrixStack, pMouseX, pMouseY, pPartialTicks);
        }
        
        for (IRenderable tooltip : tooltips) {
            tooltip.render(matrixStack, pMouseX, pMouseY, pPartialTicks);
        }
    }
}
