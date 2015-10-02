/**
 * Copyright (c) 2013-2015, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.github.mock;

import com.jcabi.aspects.Immutable;
import com.jcabi.github.GitHubThread;
import com.jcabi.github.Notification;
import com.jcabi.github.Notifications;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.NotImplementedException;

/**
 * Mock for Github Notifications.
 *
 * @author Giang Le (lthuangiang@gmail.com)
 * @author Paul Polishchuk (ppol@ua.fm)
 * @author Piotr Pradzynski (prondzyn@gmail.com)
 * @version $Id$
 * @since 0.15
 * @see <a href="https://developer.github.com/v3/activity/notifications/">Notifications API</a>
 * @todo #913:30min Implement markAsRead() and thread() operations in
 *  MkNotifications. Don't forget about unit tests.
 */
@Immutable
final class MkNotifications implements Notifications {

    /**
     * Notifications.
     */
    private final transient List<Notification> notifications;

    /**
     * Public ctor.
     * @param quantity Number of notifications.
     */
    @SuppressWarnings("PMD.AvoidInstantiatingObjectsInLoops")
    MkNotifications(final int quantity) {
        this.notifications = new ArrayList<Notification>(quantity);
        for (int index = 0; index < quantity; index += 1) {
            this.notifications.add(index, new MkNotification(index));
        }
    }

    @Override
    public Iterable<Notification> iterate() {
        return this.notifications;
    }

    @Override
    public Notification get(final int number) {
        return this.notifications.get(number);
    }

    @Override
    public void markAsRead() {
        throw new NotImplementedException("MkNotifications#markAsRead");
    }

    @Override
    public GitHubThread thread(final int number) {
        throw new NotImplementedException("MkNotifications#thread");
    }
}
