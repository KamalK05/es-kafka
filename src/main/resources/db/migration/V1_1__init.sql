-- -----------------------------------------------------
-- Table `organization_master`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `organization_master` (
  `id` BIGINT(10) NOT NULL AUTO_INCREMENT,
  `unique_id` BIGINT(10) NOT NULL,
  `name` VARCHAR(1024) NOT NULL,
  `type` ENUM('ENTERPRISE', 'STANDALONE') NULL,
  `established_date` DATETIME NULL,
  `status` ENUM('PENDING', 'CONFIRMED', 'CLOSED') NOT NULL DEFAULT 'PENDING',
  `is_deleted` TINYINT(1) NULL DEFAULT 0,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idx_unique_id` (`unique_id` ASC))
ENGINE = InnoDB;
