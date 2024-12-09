package dataConnection;



import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DataConnect extends Component {
    // Oracle Database Connection Info
 // Your DB password
    private static DefaultTableModel tableModel;
    public DataConnect() {
    }



    public void saveDataPlayer(String id, String fname, String lname, String addr, String pcode, String prov, String phone) {
        String sql = "MERGE INTO Yoon_Min_player target " +
                "USING (SELECT ? AS player_id, ? AS first_name, ? AS last_name, ? AS address, ? AS postal_code, ? AS province, ? AS phone_number FROM dual) source " +
                "ON (target.player_id = source.player_id) " +
                "WHEN MATCHED THEN " +
                "  UPDATE SET target.first_name = source.first_name, target.last_name = source.last_name, " +
                "              target.address = source.address, target.postal_code = source.postal_code, " +
                "              target.province = source.province, target.phone_number = source.phone_number " +
                "WHEN NOT MATCHED THEN " +
                "  INSERT (player_id, first_name, last_name, address, postal_code, province, phone_number) " +
                "  VALUES (source.player_id, source.first_name, source.last_name, source.address, source.postal_code, source.province, source.phone_number)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, fname);
            preparedStatement.setString(3, lname);
            preparedStatement.setString(4, addr);
            preparedStatement.setString(5, pcode);
            preparedStatement.setString(6, prov);
            preparedStatement.setString(7, phone);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected > 0 ? "Data inserted or updated successfully." : "No changes were made.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error: " + e.getMessage());
        }
    }

    public void saveDataPlayerandGame(String playerGameId, String gameId, String playerId, String playingData, String scoreData) {
        String sql = "MERGE INTO Yoon_Min_player_and_game target " +
                "USING (SELECT ? AS player_game_id, ? AS game_id, ? AS player_id, TO_DATE(?, 'YYYY-MM-DD') AS playing_date, ? AS score FROM dual) source " +
                "ON (target.player_game_id = source.player_game_id) " +
                "WHEN MATCHED THEN " +
                "  UPDATE SET target.game_id = source.game_id, " +
                "              target.player_id = source.player_id, " +
                "              target.playing_date = source.playing_date, " +
                "              target.score = source.score " +
                "WHEN NOT MATCHED THEN " +
                "  INSERT (player_game_id, game_id, player_id, playing_date, score) " +
                "  VALUES (source.player_game_id, source.game_id, source.player_id, source.playing_date, source.score)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, playerGameId);
            preparedStatement.setInt(2, Integer.parseInt(gameId));
            preparedStatement.setInt(3, Integer.parseInt(playerId));
            preparedStatement.setString(4, playingData);
            preparedStatement.setInt(5, Integer.parseInt(scoreData));

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected > 0 ? "Data inserted or updated successfully." : "No changes were made.");

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            throw new RuntimeException("Error loading data from database: " + e.getMessage());
        }

    }

    public ArrayList<Object[]> loadDataFromDatabase() {
        ArrayList<Object[]> data = new ArrayList<>();

        String query = "SELECT player_game_id, game_id, player_id, playing_date, score FROM Yoon_Min_player_and_game";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String playerGameId = resultSet.getString("player_game_id");
                Integer gameId = resultSet.getObject("game_id") != null ? resultSet.getInt("game_id") : null;
                Integer playerId = resultSet.getObject("player_id") != null ? resultSet.getInt("player_id") : null;
                java.sql.Date playingDate = resultSet.getDate("playing_date");
                String playingData = (playingDate != null) ? playingDate.toString() : null; // 문자열로 변환
                Integer score = resultSet.getObject("score") != null ? resultSet.getInt("score") : null;

                data.add(new Object[]{playerGameId, gameId, playerId, playingData, score});
            }

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            throw new RuntimeException("Error loading data from database: " + e.getMessage());
        }

        return data;
    }



    }



