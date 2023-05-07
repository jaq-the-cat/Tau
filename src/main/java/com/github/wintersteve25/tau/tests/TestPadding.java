package com.github.wintersteve25.tau.tests;

import com.github.wintersteve25.tau.components.*;
import com.github.wintersteve25.tau.components.base.UIComponent;
import com.github.wintersteve25.tau.layout.Layout;
import com.github.wintersteve25.tau.layout.LayoutSetting;
import com.github.wintersteve25.tau.theme.Theme;
import com.github.wintersteve25.tau.utils.Color;
import com.github.wintersteve25.tau.utils.Pad;
import com.github.wintersteve25.tau.utils.Size;

public class TestPadding implements UIComponent {
    @Override
    public UIComponent build(Layout layout, Theme theme) {
        return new Center(new Sized(
            Size.staticSize(200, 200),
            new Container.Builder()
                .withChild(new Padding(
                    new Pad.Builder().all(5).build(),
                    new Container.Builder()
                ))
        ));
    }
}
