/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.resolution;

import org.jboss.weld.literal.DefaultLiteral;
import org.jboss.weld.manager.BeanManagerImpl;

public class DecoratorResolvableBuilder extends ResolvableBuilder {

    public DecoratorResolvableBuilder(BeanManagerImpl manager) {
        super(manager);
    }

    @Override
    public Resolvable create() {
        if (qualifiers.size() == 0) {
            this.qualifierInstances.add(new QualifierInstance(DefaultLiteral.INSTANCE, getMetaAnnotationStore()));
        }
        return new ResolvableImpl(rawType, types, mappedQualifiers, declaringBean, qualifierInstances, true);
    }

}
