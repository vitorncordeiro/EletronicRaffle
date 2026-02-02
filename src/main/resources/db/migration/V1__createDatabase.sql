CREATE TABLE `user_model` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `cpf` varchar(255) DEFAULT NULL,
                              `email` varchar(255) DEFAULT NULL,
                              `name` varchar(255) DEFAULT NULL,
                              `password` varchar(255) DEFAULT NULL,
                              `role` enum('ADMIN','USER') DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `UKwxxx62753hssb9t5n93gaweb` (`cpf`),
                              UNIQUE KEY `UKla8xty622mpbfdhq2iixt9lhu` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `raffle_model` (
                                `raffle_id` bigint NOT NULL AUTO_INCREMENT,
                                `date` date DEFAULT NULL,
                                `prize` varchar(255) DEFAULT NULL,
                                `user_id` bigint DEFAULT NULL,
                                PRIMARY KEY (`raffle_id`),
                                KEY `FK7y5g98uyg6gaugcv2gg5fds82` (`user_id`),
                                CONSTRAINT `FK7y5g98uyg6gaugcv2gg5fds82` FOREIGN KEY (`user_id`) REFERENCES `user_model` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `raffle_ticket_model` (
                                       `raffleticket_id` bigint NOT NULL AUTO_INCREMENT,
                                       `raffle_id` bigint DEFAULT NULL,
                                       `user_id` bigint DEFAULT NULL,
                                       PRIMARY KEY (`raffleticket_id`),
                                       KEY `FKfv5wveg3rx3grh0jhndamix6c` (`raffle_id`),
                                       KEY `FK87ew446b1r62qp20j0xbc2f17` (`user_id`),
                                       CONSTRAINT `FK87ew446b1r62qp20j0xbc2f17` FOREIGN KEY (`user_id`) REFERENCES `user_model` (`id`),
                                       CONSTRAINT `FKfv5wveg3rx3grh0jhndamix6c` FOREIGN KEY (`raffle_id`) REFERENCES `raffle_model` (`raffle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
