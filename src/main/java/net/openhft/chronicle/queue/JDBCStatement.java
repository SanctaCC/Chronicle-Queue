/*
 * Copyright 2016-2020 chronicle.software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package net.openhft.chronicle.queue;

import net.openhft.chronicle.core.util.ThrowingSupplier;
import net.openhft.chronicle.queue.internal.jdbc.InternalJDBCComponent;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.SQLException;

@Deprecated(/* to be removed by x.23 */)
public interface JDBCStatement {

    void executeQuery(String query, Object... args);

    void executeUpdate(String query, Object... args);

    static JDBCStatement create(@NotNull ThrowingSupplier<Connection, SQLException> connectionSupplier, JDBCResult resul) throws SQLException {
        return new InternalJDBCComponent(connectionSupplier,resul);
    }

}
