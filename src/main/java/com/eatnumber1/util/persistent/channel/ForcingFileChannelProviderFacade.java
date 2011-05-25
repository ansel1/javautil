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

package com.eatnumber1.util.persistent.channel;

import com.eatnumber1.util.facade.SimpleFacade;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import org.jetbrains.annotations.NotNull;

/**
 * @author Russell Harmon
 * @since Jul 27, 2009
 */
public class ForcingFileChannelProviderFacade extends SimpleFacade<FileChannelProvider> implements FileChannelProvider {
    public ForcingFileChannelProviderFacade() {
    }

    public ForcingFileChannelProviderFacade( FileChannelProvider delegate ) {
        super(delegate);
    }

    @Override
    public <T> T visitValueChannel( @NotNull final FileChannelVisitor<T> visitor ) throws IOException {
        return getDelegate().visitValueChannel(new FileChannelVisitor<T>() {
            @Override
            public T visit( @NotNull FileChannel channel ) throws IOException {
                channel.force(true);
                return visitor.visit(channel);
            }
        });
    }

    @Override
    public void close() throws IOException {
        getDelegate().close();
    }

    @NotNull
    @Override
    public File getFile() {
        return getDelegate().getFile();
    }

    @Override
    public void open() throws IOException {
        getDelegate().open();
    }

    @Override
    public void flush() throws IOException {
        getDelegate().flush();
    }
}