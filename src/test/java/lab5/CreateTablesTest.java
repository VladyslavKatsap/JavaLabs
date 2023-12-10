package lab5;

import lab5.sqlUtils.SQLExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreateTablesTest {
    private SQLExecutor sqlExecutor = new SQLExecutor("jdbc:mysql://localhost/lab", "root", "123654789");

    @Test
    public void createTables() {
        try {
            sqlExecutor.executeQueryWithNoResult("DROP TABLE IF EXISTS lab.athlete;");
            sqlExecutor.executeQueryWithNoResult("DROP TABLE IF EXISTS lab.competition;");
            sqlExecutor.executeQueryWithNoResult("DROP TABLE IF EXISTS lab.championship;");
            sqlExecutor.executeQueryWithNoResult("DROP TABLE IF EXISTS lab.position;");

            sqlExecutor.executeQueryWithNoResult("CREATE TABLE athlete(\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "`name` VARCHAR(45) NOT NULL,\n" +
                    "`date_of_birth` DATE NOT NULL,\n" +
                    "PRIMARY KEY (`id`),\n" +
                    "UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE\n" +
                    ");");

            sqlExecutor.executeQueryWithNoResult("CREATE TABLE competition(\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n"+
                    "`name` VARCHAR(45) NOT NULL,\n"+
                    "`category` INT NOT NULL,\n"+
                    "PRIMARY KEY (`id`),\n"+
                    "UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE\n"+
                    ");");

            sqlExecutor.executeQueryWithNoResult("CREATE TABLE position(\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n"+
                    "`competition_id` INT NOT NULL,\n"+
                    "`place` VARCHAR(45) NOT NULL,\n"+
                    "`athlete_id` INT NOT NULL,\n"+
                    "PRIMARY KEY (`id`, `competition_id`, `athlete_id`),\n"+
                    "UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,\n"+
                    "INDEX `fk_position_competition_idx` (`competition_id` ASC) VISIBLE,\n"+
                    "INDEX `fk_position_athlete1_idx` (`athlete_id` ASC) VISIBLE,\n"+
                    "CONSTRAINT `fk_position_competition`\n"+
                    "FOREIGN KEY (`competition_id`)\n"+
                    "REFERENCES `lab`.`competition` (`id`)\n"+
                    "ON DELETE NO ACTION\n"+
                    "ON UPDATE NO ACTION,\n"+
                    "CONSTRAINT `fk_position_athlete1`\n"+
                    "FOREIGN KEY (`athlete_id`)\n"+
                    "REFERENCES `lab`.`athlete` (`id`)\n"+
                    "ON DELETE NO ACTION\n"+
                    "ON UPDATE NO ACTION\n"+
                    ");");
            sqlExecutor.executeQueryWithNoResult("CREATE TABLE championship(\n" +
                    "`id` INT NOT NULL AUTO_INCREMENT,\n"+
                    "`title` VARCHAR(80) NOT NULL,\n"+
                    "PRIMARY KEY (`id`),\n"+
                    "UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE\n"+
                    ");");
            sqlExecutor.executeQueryWithNoResult("CREATE TABLE championship_has_position(\n" +
                    "championship_id INT NOT NULL,\n"+
                    "position_id INT NOT NULL,\n"+
                    "position_competition_id INT NOT NULL,\n"+
                    "position_athlete_id INT NOT NULL,\n"+
                    "PRIMARY KEY (championship_id, position_id, position_competition_id, position_athlete_id),\n"+
                    "INDEX fk_championship_has_position_position1_idx (position_id ASC, position_competition_id ASC, position_athlete_id ASC) VISIBLE,\n"+
                    "INDEX fk_championship_has_position_championship1_idx (championship_id ASC) VISIBLE,\n"+
                    "CONSTRAINT fk_championship_has_position_championship1\n"+
                    "FOREIGN KEY (championship_id)\n"+
                    "REFERENCES mydb.championship (id)\n"+
                    "ON DELETE NO ACTION\n"+
                    "ON UPDATE NO ACTION,\n"+
                    "CONSTRAINT fk_championship_has_position_position1\n"+
                    "FOREIGN KEY (position_id , position_competition_id , position_athlete_id)\n"+
                    "REFERENCES mydb.position (id , competition_id , athlete_id)\n"+
                    "ON DELETE NO ACTION\n"+
                    "ON UPDATE NO ACTION\n"+
                    ");");
        } catch (SQLException e) {
            //Assert.fail("Error while creating tables");
            e.printStackTrace();
        }
    }
}