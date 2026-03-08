INSERT INTO Modele_voiture (marque, modele) VALUES
                                                ('KIA',     'PRIDE'),
                                                ('KIA',     'LACETTI'),
                                                ('HYUNDAI', 'GETZ'),
                                                ('HYUNDAI', 'LACETTI'),
                                                ('DAEWOO',  'GETZ'),
                                                ('DAEWOO',  'LACETTI');

INSERT INTO Piece_auto (id_modele_voiture, numero_serie, prix) VALUES
                                                                   (1, 'SN-KIA-001', 45.00),
                                                                   (1, 'SN-KIA-002', 120.00),
                                                                   (1, 'SN-KIA-003', 75.50),

-- KIA LACETTI (id_modele=2)
                                                                   (2, 'SN-KIA-004', 200.00),
                                                                   (2, 'SN-KIA-005', 95.00),

-- HYUNDAI GETZ (id_modele=3)
                                                                   (3, 'SN-HYU-001', 60.00),
                                                                   (3, 'SN-HYU-002', 150.00),
                                                                   (3, 'SN-HYU-003', 85.00),

-- HYUNDAI LACETTI (id_modele=4)
                                                                   (4, 'SN-HYU-004', 110.00),
                                                                   (4, 'SN-HYU-005', 50.00),

-- DAEWOO GETZ (id_modele=5)
                                                                   (5, 'SN-DAE-001', 35.00),
                                                                   (5, 'SN-DAE-002', 90.00),

-- DAEWOO LACETTI (id_modele=6)
                                                                   (6, 'SN-DAE-003', 130.00),
                                                                   (6, 'SN-DAE-004', 70.00);

INSERT INTO Vente (id_piece_auto, quantite) VALUES
-- Pièces KIA
(1, 3),   -- SN-KIA-001 x3
(2, 5),   -- SN-KIA-002 x5
(3, 2),   -- SN-KIA-003 x2
(4, 4),   -- SN-KIA-004 x4
(5, 1),   -- SN-KIA-005 x1

-- Pièces HYUNDAI
(6, 6),   -- SN-HYU-001 x6
(7, 3),   -- SN-HYU-002 x3
(8, 2),   -- SN-HYU-003 x2
(9, 4),   -- SN-HYU-004 x4
(10, 5),  -- SN-HYU-005 x5

-- Pièces DAEWOO
(11, 2),  -- SN-DAE-001 x2
(12, 7),  -- SN-DAE-002 x7
(13, 3),  -- SN-DAE-003 x3
(14, 1);  -- SN-DAE-004 x1