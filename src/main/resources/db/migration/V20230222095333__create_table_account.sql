CREATE TABLE account
(
    `id`         bigint(20) primary key NOT NULL AUTO_INCREMENT COMMENT '账号ID',
    `open_code`  varchar(255)           NULL DEFAULT NULL COMMENT '登录账号,如手机号等',
    `password`   varchar(255)           NULL DEFAULT NULL COMMENT '密码',
    `created_at` bigint                 NULL DEFAULT NULL COMMENT '创建时间',
    `updated_at` bigint                 NULL DEFAULT NULL COMMENT '修改时间',
    `deleted`    tinyint                NULL DEFAULT 0 COMMENT '逻辑删除:0=未删除,1=已删除'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '账号'