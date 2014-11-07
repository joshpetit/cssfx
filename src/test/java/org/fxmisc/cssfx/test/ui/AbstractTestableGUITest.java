package org.fxmisc.cssfx.test.ui;

/*
 * #%L
 * CSSFX
 * %%
 * Copyright (C) 2014 CSSFX by Matthieu Brouillard
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import javafx.scene.Parent;

import org.loadui.testfx.GuiTest;

public abstract class AbstractTestableGUITest<T extends TestableUI> extends GuiTest {
    private Class<T> uiClass;
    private Parent rootNode;
    private T testedInstance;

    protected AbstractTestableGUITest(Class<T> testableClass) {
        uiClass = testableClass;
    }
    
    protected T getTestedInstance() {
        return testedInstance;
    }

    @Override
    protected Parent getRootNode() {
        try {
            testedInstance = uiClass.newInstance();
            rootNode = testedInstance.getRootNode();
            return rootNode;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    protected Parent builtRootNode() {
        return rootNode;
    }
}
