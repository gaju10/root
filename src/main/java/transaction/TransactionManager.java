package transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

public class TransactionManager {
    private DataSource dataSource;

    public TransactionManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> T execute(Transaction<T> transaction) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            ThreadLocalHandler.setConnection(connection);
            T returnedValue = transaction.execute();
            connection.commit();
            return returnedValue;
        } catch (SQLException e) {
            tryToRollback(connection);
        } finally {
            tryToClose(connection);
        }
        return null;
    }

    private void tryToRollback(Connection connection) {
        if (!Objects.equals(connection, null)) {
            try {
                connection.rollback();
            } catch (SQLException e) {
            }
        }

    }

    private void tryToClose(Connection connection) {
        if (!Objects.equals(connection, null)) {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }

    }
}
