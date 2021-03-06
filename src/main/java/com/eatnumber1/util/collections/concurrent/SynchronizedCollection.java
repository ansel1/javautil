/*
 * Copyright 2007 Russell Harmon
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.eatnumber1.util.collections.concurrent;

import com.eatnumber1.util.collections.concurrent.iterators.SynchronizedIterator;
import com.eatnumber1.util.concurrent.lock.ReadWriteLockProvider;
import com.eatnumber1.util.facade.Facade;
import java.util.Collection;
import java.util.Iterator;
import net.jcip.annotations.ThreadSafe;
import org.jetbrains.annotations.NotNull;

/**
 * @author Russell Harmon
 * @since Jul 13, 2007
 */
@ThreadSafe
public interface SynchronizedCollection<T, D extends Collection<T>> extends Collection<T>, ReadWriteLockProvider, Facade<D> {
    @NotNull
    SynchronizedIterator<T, Iterator<T>> synchronizedIterator();
}
