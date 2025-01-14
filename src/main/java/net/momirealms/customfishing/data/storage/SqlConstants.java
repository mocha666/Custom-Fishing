package net.momirealms.customfishing.data.storage;

public class SqlConstants {

    public static final String SQL_CREATE_BAG_TABLE = "CREATE TABLE IF NOT EXISTS `%s` ( `uuid` VARCHAR(36) NOT NULL , `size` INT(8) NOT NULL , `contents` LONGTEXT NOT NULL , PRIMARY KEY (`uuid`) )";
    public static final String SQL_INSERT_BAG = "INSERT INTO `%s`(`uuid`, `size`, `contents`) VALUES (?, ?, ?)";
    public static final String SQL_UPDATE_BAG_BY_UUID = "UPDATE `%s` SET `size` = ?, `contents` = ? WHERE `uuid` = ?";
    public static final String SQL_SELECT_BAG_BY_UUID = "SELECT * FROM `%s` WHERE `uuid` = ?";
}
