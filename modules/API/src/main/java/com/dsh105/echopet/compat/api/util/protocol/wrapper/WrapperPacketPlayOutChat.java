/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.samistine.echopet.compat.api.util.protocol.wrapper;

import com.samistine.echopet.compat.api.plugin.EchoPet;
import com.samistine.echopet.compat.api.reflection.ReflectionConstants;
import com.samistine.echopet.compat.api.util.ReflectionUtil;
import com.samistine.echopet.compat.api.util.protocol.Packet;
import com.samistine.echopet.compat.api.util.protocol.PacketFactory;
import com.samistine.echopet.compat.api.reflection.SafeMethod;

public class WrapperPacketPlayOutChat extends Packet {

    public WrapperPacketPlayOutChat() {
        super(PacketFactory.PacketType.CHAT);
    }

    public void setMessage(String chatComponent) {
        if (EchoPet.isUsingNetty()) {
            this.write(ReflectionConstants.PACKET_CHAT_FIELD_MESSAGE.getName(), new SafeMethod(ReflectionUtil.getNMSClass("ChatSerializer"), ReflectionConstants.PACKET_CHAT_FUNC_SETCOMPONENT.getName(), String.class).invoke(null, chatComponent));
        } else {
            this.write(ReflectionConstants.PACKET_CHAT_FIELD_MESSAGE.getName(), chatComponent);
        }
    }

    public String getMessage() {
        Object value = this.read(ReflectionConstants.PACKET_CHAT_FIELD_MESSAGE.getName());
        if (value instanceof String) {
            return (String) value;
        }
        return (String) new SafeMethod(ReflectionUtil.getNMSClass("ChatSerializer"), ReflectionConstants.PACKET_CHAT_FUNC_GETMESSAGE.getName(), ReflectionUtil.getNMSClass("IChatBaseComponent")).invoke(null, value);
    }
}