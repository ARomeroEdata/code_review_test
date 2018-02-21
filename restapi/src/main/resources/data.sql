INSERT INTO `tm_roles` (`id`, `name`)
VALUES
	(1,'role 1'),
	(2,'role 2');

INSERT INTO `tm_users` (`id`, `name`)
VALUES
	(1,'User 1');
INSERT INTO `tm_users_tm_roles` (`id_tm_roles`, `id_tm_users`)
VALUES
	(1,1),
	(2,1);
