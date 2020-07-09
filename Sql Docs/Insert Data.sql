/* ___________________________________________________________ */

INSERT INTO Existence.Province VALUES ('Tehran');
INSERT INTO Existence.Province VALUES ('Esfahan');
INSERT INTO Existence.Province VALUES ('Kermanshah');
INSERT INTO Existence.Province VALUES ('Shiraz');
INSERT INTO Existence.Province VALUES ('Tabriz');
INSERT INTO Existence.Province VALUES ('Ahvaz');
INSERT INTO Existence.Province VALUES ('Mashahd');


/* ___________________________________________________________ */

INSERT INTO Existence.City VALUES ('Tehran', 1);
INSERT INTO Existence.City VALUES ('Najaf Abad', 2);
INSERT INTO Existence.City VALUES ('Gilan gharb', 3);
INSERT INTO Existence.City VALUES ('Shiraz', 4);
INSERT INTO Existence.City VALUES ('Tabriz', 5);
INSERT INTO Existence.City VALUES ('Mahshahr', 6);
INSERT INTO Existence.City VALUES ('Mashahd', 7);


/* ___________________________________________________________ */

INSERT INTO Production.ProductionType VALUES ('Foodstaff', NULL);
INSERT INTO Production.ProductionType VALUES ('Sanitary', NULL);
INSERT INTO Production.ProductionType VALUES ('Stationery', NULL);
INSERT INTO Production.ProductionType VALUES ('Cosmetic', NULL);
INSERT INTO Production.ProductionType VALUES ('Home Appliances', NULL);
INSERT INTO Production.ProductionType VALUES ('Clothing', NULL);

/* ___________________________________________________________ */

INSERT INTO Existence.Company VALUES ('Iran food', 1, 1, '02111111111', NULL);
INSERT INTO Existence.Company VALUES ('Iran home', 1, 5, '02111111112', NULL);
INSERT INTO Existence.Company VALUES ('Ketab Afzar', 1, 3, '02111111113', NULL);
INSERT INTO Existence.Company VALUES ('Iran Pooshak', 1, 6, '02111111114', NULL);
INSERT INTO Existence.Company VALUES ('Iran Pak', 1, 2, '02111111115', NULL);
INSERT INTO Existence.Company VALUES ('Iran Ziba', 1, 4, '02111111116', NULL);
INSERT INTO Existence.Company VALUES ('Esfahan food', 2, 1, '03111111111', NULL);
INSERT INTO Existence.Company VALUES ('Esfahan home', 2, 5, '03111111112', NULL);
INSERT INTO Existence.Company VALUES ('Esfahan Afzar', 2, 3, '03111111113', NULL);
INSERT INTO Existence.Company VALUES ('Esfahan Pooshak', 2, 6, '03111111114', NULL);
INSERT INTO Existence.Company VALUES ('Esfahan Pak', 2, 2, '03111111115', NULL);
INSERT INTO Existence.Company VALUES ('Esfahan Ziba', 2, 4, '03111111116', NULL);
INSERT INTO Existence.Company VALUES ('Kermanshah food', 3, 1, '08341111111', NULL);
INSERT INTO Existence.Company VALUES ('Kermanshah Pak', 3, 2, '08341111115', NULL);
INSERT INTO Existence.Company VALUES ('Zagros food', 3, 1, '08341111112', NULL);
INSERT INTO Existence.Company VALUES ('Zagros Pak', 3, 2, '08341111114', NULL);
INSERT INTO Existence.Company VALUES ('Shiraz food', 4, 1, '04111111111', NULL);
INSERT INTO Existence.Company VALUES ('Shiraz Pak', 4, 2, '04111111115', NULL);
INSERT INTO Existence.Company VALUES ('Tabriz Shoes1', 5, 6, '05111111111', NULL);
INSERT INTO Existence.Company VALUES ('Tabriz cloth', 5, 6, '05111111115', NULL);
INSERT INTO Existence.Company VALUES ('Ahvaz food', 8, 1, '05111111111', NULL);
INSERT INTO Existence.Company VALUES ('Ahvaz Pak', 8, 2, '05111111115', NULL);
INSERT INTO Existence.Company VALUES ('Mashhad food', 7, 1, '07111111111', NULL);
INSERT INTO Existence.Company VALUES ('Mashhad Pak', 7, 2, '07111111115', NULL);

/* ___________________________________________________________ */

INSERT INTO Person.SupplierType VALUES ('Visitor', NULL);
INSERT INTO Person.SupplierType VALUES ('Transporter', NULL);

/* ___________________________________________________________ */

INSERT INTO Person.Supplier VALUES ('Amir', 'Amiri', 'Male', '09181111111', NULL,6,  1, 7, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Mohamad', 'Mohamadi', 'Male', '09181111112', NULL, 6,  2, 7, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Ali', 'Ali', 'Male', '09181111113', NULL,6,  1, 8, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Hamid', 'Hamidi', 'Male', '09181111114', NULL, 6,  2, 8, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Fatemeh', 'Hamedi', 'Female', '09181111115', NULL,6,  1, 9, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Naser', 'Naseri', 'Male', '09181111116', NULL, 6,  2, 9, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Behrooz', 'Behrooz', 'Male', '09181111117', NULL,6,  1, 10, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Nader', 'Naderi', 'Male', '09181111118', NULL, 6,  2, 10, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdi', 'Behroozi', 'Male', '09181111119', NULL,6,  1, 11, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Ali', 'Naderi', 'Male', '09181111120', NULL, 6,  2, 11, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdi', 'Behrooziii', 'Male', '09181111121', NULL,6,  1, 12, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Ali', 'Naderii', 'Male', '09181111122', NULL, 6,  2, 12, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdii', 'Behrooziii', 'Male', '09181111121', NULL,6,  1, 13, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Alii', 'Naderii', 'Male', '09181111122', NULL, 6,  2, 13, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiii', 'Behrooziii', 'Male', '09181111121', NULL,6,  1, 14, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliii', 'Naderii', 'Male', '09181111122', NULL, 6,  2, 14, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdii', 'Behrooiziii', 'Male', '09181111121', NULL,6,  1, 15, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Alii', 'Naderiii', 'Male', '09181111122', NULL, 6,  2, 15, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiii', 'Behrooziii', 'Male', '09181111121', NULL,6,  1, 16, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliii', 'Naderii', 'Male', '09181111122', NULL, 6,  2, 16, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiiii', 'Behrooziii', 'Male', '09181111121', NULL,6,  1, 17, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiii', 'Naderii', 'Male', '09181111122', NULL, 6,  2, 17, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiiiii', 'Behrooziii', 'Male', '09181111121', NULL,6,  1, 18, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiiii', 'Naderii', 'Male', '09181111122', NULL, 6,  2, 18, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiiiiii', 'Behrooziii', 'Male', '09181111121', NULL,6,  1, 19, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiiiii', 'Naderii', 'Male', '09181111122', NULL, 6,  2, 19, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiiiii', 'Behrooziii', 'Male', '09181111121', NULL,6,  1, 20, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiiii', 'Naderii', 'Male', '09181111122', NULL, 6,  2, 20, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiiiiii', 'Behrooziii', 'Male', '09181111121', NULL,6,  1, 21, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiiiii', 'Naderii', 'Male', '09181111122', NULL, 6,  2, 21, GETDATE(), NULL);





INSERT INTO Person.Supplier VALUES ('Mehdiiiii', 'Behrooziiii', 'Male', '09181111121', NULL,6,  1, 22, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiiii', 'Naderiii', 'Male', '09181111122', NULL, 6,  2, 22, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiiiii', 'Behrooziiiii', 'Male', '09181111121', NULL,6,  1, 23, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiiii', 'Naderiiii', 'Male', '09181111122', NULL, 6,  2, 23, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiiiii', 'Behrooziiiiii', 'Male', '09181111121', NULL,6,  1, 24, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiiii', 'Naderiiiii', 'Male', '09181111122', NULL, 6,  2, 24, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdiiiii', 'Behrooziiiiioi', 'Male', '09181111121', NULL,6,  1, 25, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiiii', 'Naderiiiiio', 'Male', '09181111122', NULL, 6,  2, 25, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdriiiii', 'Behrooziiiiioi', 'Male', '09181111121', NULL,6,  1, 26, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliiriii', 'Naderiiiiio', 'Male', '09181111122', NULL, 6,  2, 26, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehdrieiipii', 'Behrooziiieiioi', 'Male', '09181111121', NULL,6,  1, 29, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Aliirieiip', 'Naderiiiieio', 'Male', '09181111122', NULL, 6,  2, 29, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehddrieiipii', 'Behrooziiieiioi', 'Male', '09181111121', NULL,6,  1, 30, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Alidirieiip', 'Naderiiiieio', 'Male', '09181111122', NULL, 6,  2, 30, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehddrieiipiiv', 'Behrooziiieiioi', 'Male', '09181111121', NULL,6,  1, 31, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Alidirieiipv', 'Naderiiiieio', 'Male', '09181111122', NULL, 6,  2, 31, GETDATE(), NULL);

INSERT INTO Person.Supplier VALUES ('Mehddrieiipiiv', 'Behrooziilieiioi', 'Male', '09181111121', NULL,6,  1, 32, GETDATE(), NULL);
INSERT INTO Person.Supplier VALUES ('Alidirieiipvl', 'Naderiiiieio', 'Male', '09181111122', NULL, 6,  2, 32, GETDATE(), NULL);

/* ___________________________________________________________ */

INSERT INTO Person.StaffType VALUES ('Cashier', NULL);
INSERT INTO Person.StaffType VALUES ('Janitor', NULL);
INSERT INTO Person.StaffType VALUES ('Services', NULL);
INSERT INTO Person.StaffType VALUES ('Repairs', NULL);
INSERT INTO Person.StaffType VALUES ('Postman', NULL);

/* ___________________________________________________________ */

INSERT INTO Person.Staff VALUES ('Ali', 'Ali', 'Male', GETDATE(), '09191111122', NULL, NULL, NULL, 1000,  2, 1, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Mohammad', 'Rezaei', 'Male', GETDATE(), '09191111123', NULL, NULL, NULL, 1000,  2, 1, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Hassan', 'Hashemi', 'Male', GETDATE(), '09191111124', NULL, NULL, NULL, 1000,  2, 1, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Mohammad', 'Rezaeii', 'Male', GETDATE(), '09191111125', NULL, NULL, NULL, 1000,  2, 1, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Qazal', 'Rezvani', 'Female', GETDATE(), '09191111126', NULL, NULL, NULL, 1000,  2, 1, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Zahra', 'Razi', 'Female', GETDATE(), '09191111127', NULL, NULL, NULL, 1000,  2, 1, GETDATE(), NULL);

INSERT INTO Person.Staff VALUES ('Ali', 'Alaei', 'Male', GETDATE(), '09191111130', NULL, NULL, NULL, 500,  2, 2, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Alireza', 'Ali', 'Male', GETDATE(), '09191111142', NULL, NULL, NULL, 500,  2, 2, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Hossein', 'Ali', 'Male', GETDATE(), '09191111152', NULL, NULL, NULL, 500,  2, 2, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Arman', 'riasi', 'Male', GETDATE(), '09191111162', NULL, NULL, NULL, 500,  2, 2, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Mamad', 'vahidi', 'Male', GETDATE(), '09191111172', NULL, NULL, NULL, 500,  2, 2, GETDATE(), NULL);

INSERT INTO Person.Staff VALUES ('Zahra', 'Naseri', 'Female', GETDATE(), '09191121127', NULL, NULL, NULL, 1500,  2, 3, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Leyli', 'Noori', 'Female', GETDATE(), '09191131127', NULL, NULL, NULL, 1500,  2, 3, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Maryam', 'Nadi', 'Female', GETDATE(), '09191411127', NULL, NULL, NULL, 1500,  2, 3, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Sara', 'Navabi', 'Female', GETDATE(), '09191111612', NULL, NULL, NULL, 1500,  2, 3, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Maede', 'Bahrami', 'Female', GETDATE(), '09191171127', NULL, NULL, NULL, 1500,  2, 3, GETDATE(), NULL);


INSERT INTO Person.Staff VALUES ('Vahid', 'Abbasi', 'Male', GETDATE(), '09191161130', NULL, NULL, NULL, 700,  2, 4, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Alireza', 'Gholami', 'Male', GETDATE(), '09196111142', NULL, NULL, NULL, 700,  2, 4, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Soheil', 'Zare', 'Male', GETDATE(), '09191116152', NULL, NULL, NULL, 700,  2, 4, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Amir', 'Behroozi', 'Male', GETDATE(), '09191161162', NULL, NULL, NULL, 700,  2, 4, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Mohammad', 'Soltani', 'Male', GETDATE(), '09196111172', NULL, NULL, NULL, 700,  2, 4, GETDATE(), NULL);


INSERT INTO Person.Staff VALUES ('Hassan', 'Abbasi', 'Male', GETDATE(), '09198111130', NULL, NULL, NULL, 700,  2, 5, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Alireza', 'Molavi', 'Male', GETDATE(), '09191811142', NULL, NULL, NULL, 700,  2, 5, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Hossien', 'Zare', 'Male', GETDATE(), '09191181152', NULL, NULL, NULL, 700,  2, 5, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Amir', 'Mansuri', 'Male', GETDATE(), '09191181162', NULL, NULL, NULL, 700,  2, 5, GETDATE(), NULL);
INSERT INTO Person.Staff VALUES ('Reza', 'Soltani', 'Male', GETDATE(), '09191181172', NULL, NULL, NULL, 700,  2, 5, GETDATE(), NULL);

/* ___________________________________________________________ */

INSERT INTO Person.Customer VALUES ('Amir', 'Mansurian', 'Male', GETDATE(), '09198121130', NULL, NULL, NULL, -250,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Ali', 'Naqhash', 'Male', GETDATE(), '09198141130', NULL, NULL, NULL, -20,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Hassan', 'Nouroozi', 'Male', GETDATE(), '09198251130', NULL, NULL, NULL, -40,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Hossein', 'Niazi', 'Male', GETDATE(), '09198511130', NULL, NULL, NULL, 0,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Reza', 'Ekhtiari', 'Male', GETDATE(), '09198161130', NULL, NULL, NULL, 0,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Shayan', 'Shamspour', 'Male', GETDATE(), '09198171130', NULL, NULL, NULL, 50,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Nima', 'Sohrabi', 'Male', GETDATE(), '09198118130', NULL, NULL, NULL, -300,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Ahmad', 'ALipour', 'Male', GETDATE(), '09198119130', NULL, NULL, NULL, -10,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Rasoul', 'Kamali', 'Male', GETDATE(), '09198131130', NULL, NULL, NULL, -50,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Arash', 'Abdi', 'Male', GETDATE(), '09198121130', NULL, NULL, NULL, 20,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Aria', 'Abbasi', 'Male', GETDATE(), '09198911130', NULL, NULL, NULL, 0,  GETDATE(), NULL);

INSERT INTO Person.Customer VALUES ('Nafise', 'Roshan', 'Female', GETDATE(), '09198121131', NULL, NULL, NULL, 0,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Qazal', 'Kiani', 'Female', GETDATE(), '09198141132', NULL, NULL, NULL, 0,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Maede', 'Farazmand', 'Female', GETDATE(), '09198251133', NULL, NULL, NULL, 0,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Nastaran', 'Heshmati', 'Female', GETDATE(), '09198511134', NULL, NULL, NULL, 0,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Elnaz', 'Shirzadi', 'Female', GETDATE(), '09198161135', NULL, NULL, NULL, 10,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Bahar', 'Fatahi', 'Female', GETDATE(), '09198171136', NULL, NULL, NULL, 0,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Fatemeh', 'Hoseini', 'Female', GETDATE(), '09198118137', NULL, NULL, NULL, 0,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Zahra', 'Saeidi', 'Female', GETDATE(), '09198119138', NULL, NULL, NULL, -60,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Marzieh', 'Ashoori', 'Female', GETDATE(), '09198131139', NULL, NULL, NULL, 0,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Sajede', 'Baradaran', 'Female', GETDATE(), '09198121140', NULL, NULL, NULL, -250,  GETDATE(), NULL);
INSERT INTO Person.Customer VALUES ('Faride', 'Ahmadi', 'Female', GETDATE(), '09198911141', NULL, NULL, NULL, 0,  GETDATE(), NULL);

/* ___________________________________________________________ */

INSERT INTO Person.Relation VALUES (1, 22);
INSERT INTO Person.Relation VALUES (22, 5);
INSERT INTO Person.Relation VALUES (8, 7);
INSERT INTO Person.Relation VALUES (1, 10);
INSERT INTO Person.Relation VALUES (2, 14);

/* ___________________________________________________________ */

INSERT INTO Production.ProductionSubClass VALUES ('Food', NULL, 1);
INSERT INTO Production.ProductionSubClass VALUES ('Dairy', NULL, 1);
INSERT INTO Production.ProductionSubClass VALUES ('Junk Food', NULL, 1);
INSERT INTO Production.ProductionSubClass VALUES ('Refrigeratory', NULL, 1);
INSERT INTO Production.ProductionSubClass VALUES ('Beans', NULL, 1);
INSERT INTO Production.ProductionSubClass VALUES ('Fruit', NULL, 1);

INSERT INTO Production.ProductionSubClass VALUES ('Tissue', NULL, 2);
INSERT INTO Production.ProductionSubClass VALUES ('Washer', NULL, 2);

INSERT INTO Production.ProductionSubClass VALUES ('To write', NULL, 3);
INSERT INTO Production.ProductionSubClass VALUES ('To read', NULL, 3);

INSERT INTO Production.ProductionSubClass VALUES ('Perfume', NULL, 4);
INSERT INTO Production.ProductionSubClass VALUES ('Cosmetic', NULL, 4);

INSERT INTO Production.ProductionSubClass VALUES ('Multimedia', NULL, 5);
INSERT INTO Production.ProductionSubClass VALUES ('To Kitcken', NULL, 5);
INSERT INTO Production.ProductionSubClass VALUES ('Furniture', NULL, 5);

INSERT INTO Production.ProductionSubClass VALUES ('Summer clothes', NULL, 6);
INSERT INTO Production.ProductionSubClass VALUES ('Winter Clothes', NULL, 6);
INSERT INTO Production.ProductionSubClass VALUES ('Under Wear', NULL, 6);

/* ___________________________________________________________ */

INSERT INTO Production.Product VALUES ('Rice', '6260000000001', 'Tabiaat', 1, 'Number', 10);
INSERT INTO Production.Product VALUES ('Pasta', '6260000000002', 'Zar Makaron', 1, 'Number', 1.5);
INSERT INTO Production.Product VALUES ('Honey', '6260000000003', 'Shana', 1, 'Number', 3);
INSERT INTO Production.Product VALUES ('Oil', '6260000000004', 'Famila', 1, 'Number', 2);
INSERT INTO Production.Product VALUES ('Matches', '6260000000005', 'Tavakoli', 1, 'Number', 0.2);

INSERT INTO Production.Product VALUES ('Butter', '6260000000006', 'Mihan', 2, 'Number', 1);
INSERT INTO Production.Product VALUES ('Chesse', '6260000000007', 'Mihan', 2, 'Number', 2);
INSERT INTO Production.Product VALUES ('Milk', '6260000000008', 'Ramak', 2, 'Number', 1.5);
INSERT INTO Production.Product VALUES ('Ice cream', '6260000000009', 'Dayti', 2, 'Number', 0.3);
INSERT INTO Production.Product VALUES ('Cream', '6260000000010', 'Kale', 2, 'Number', 1);

INSERT INTO Production.Product VALUES ('Cheaps', '6260000000211', 'Maz Maz', 3, 'Number', 0.5);
INSERT INTO Production.Product VALUES ('Pop Corn', '6260000000212', 'Chetooz', 3, 'Number', 0.5);
INSERT INTO Production.Product VALUES ('Choklate', '6260000000213', 'Farmand', 3, 'Number', 2);
INSERT INTO Production.Product VALUES ('Pastil', '6260000000214', 'Shibaba', 3, 'Number', 1);
INSERT INTO Production.Product VALUES ('Browni', '6260000000215', 'Dorna', 3, 'Number', 0.4);
INSERT INTO Production.Product VALUES ('Soft Drink', '6260000000211', 'Canda Dry', 3, 'Number', 1);

INSERT INTO Production.Product VALUES ('Meet', '6260100000000', 'Kale', 4, 'Kilo', 15);
INSERT INTO Production.Product VALUES ('Egge', '6260100000001', 'Telavang', 4, 'Number', 1.5);
INSERT INTO Production.Product VALUES ('Fish', '6260100000002', 'Kale', 4, 'Kilo', 12);
INSERT INTO Production.Product VALUES ('Pizza Chesse', '6260100000003', 'A B', 4, 'Number', 5);
INSERT INTO Production.Product VALUES ('Burger', '6260100000004', 'Gooshtiran', 4, 'Number', 9);

INSERT INTO Production.Product VALUES ('Tissue', '6260100000005', 'Cheshmak', 5, 'Number', 3);
INSERT INTO Production.Product VALUES ('Baby Diaper', '6260100000006', 'Molfix', 5, 'Number', 10);

INSERT INTO Production.Product VALUES ('Washing Powder', '6260100000007', 'Persil', 6, 'Number', 6);
INSERT INTO Production.Product VALUES ('Dishwashing Liquid', '6260100000008', 'Golrang', 6, 'Number', 2);
INSERT INTO Production.Product VALUES ('Shampoo', '6260100000017', 'Dove', 6, 'Number', 8);

INSERT INTO Production.Product VALUES ('Pen', '6260100000009', 'Stedler', 7, 'Number', 1.5);
INSERT INTO Production.Product VALUES ('Pencil', '6260100000010', 'Bic', 7, 'Number', 2);

INSERT INTO Production.Product VALUES ('Note book 100 pages', '6260100000011', 'Nevesht Afzar', 8, 'Number', 4);
INSERT INTO Production.Product VALUES ('Kavir Book Dr shariaati', '6260100000012', 'Entesharate Bahar', 8, 'Number', 10);

INSERT INTO Production.Product VALUES ('Perfume', '6260100000013', 'Hakoopian', 9, 'Number', 12);
INSERT INTO Production.Product VALUES ('Freshener', '6260100000014', NULL, 9, 'Number', 3);

INSERT INTO Production.Product VALUES ('Tv 46 inches', '6260100000015', 'LG', 11, 'Number', 150);
INSERT INTO Production.Product VALUES ('Dvd Player blueray', '6260100000016', 'Sony', 11, 'Number', 60);

/* ___________________________________________________________ */

INSERT INTO Production.Inventory VALUES (1, 200, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (2, 2000, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (3, 250, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (4, 600, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (5, 43, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (6, 678, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (7, 52, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (8, 41, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (9, 39, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (10, 22, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (11, 55, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (12, 79, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (13, 150, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (14, 920, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (15, 152, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (35, 23, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (42, 310, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (43, 42, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (44, 120, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (45, 103, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (46, 106, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (49, 160, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (50, 156, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (54, 1560, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (55, 410, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (56, 130, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (57, 410, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (58, 638, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (59, 82, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (60, 720, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (61, 560, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (62, 630, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (63, 272, GETDATE(), NULL);
INSERT INTO Production.Inventory VALUES (65, 63, GETDATE(), NULL);

/* ___________________________________________________________ */

INSERT INTO Production.CostChanges VALUES (1, 10, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (2, 1.5, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (3, 3, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (4, 2, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (5, 0.2, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (6, 1, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (7, 2, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (8, 1.5, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (9, 0.3, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (10, 1, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (11, 0.5, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (12, 0.5, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (13, 2, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (14, 1, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (15, 0.4, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (35, 1, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (42, 15, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (43, 1.5, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (44, 12, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (45, 5, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (46, 9, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (49, 3, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (50, 10, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (54, 12, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (55, 3, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (56, 150, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (57, 60, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (58, 1.5, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (59, 2, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (60, 4, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (61, 10, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (62, 6, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (63, 2, GETDATE(), NULL);
INSERT INTO Production.CostChanges VALUES (65, 8, GETDATE(), NULL);

/* ___________________________________________________________ */
	
INSERT INTO Production.ProductDetail VALUES (1, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (2, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (3, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (4, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (5, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (6, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (7, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (8, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (9, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (10, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (11, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (12, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (13, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (14, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (15, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (35, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (42, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (43, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (44, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (45, 1, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (46, 2, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (49, 11, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (50, 12, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (54, 24, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (55, 23, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (56, 17, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (57, 18, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (58, 19, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (59, 19, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (60, 20, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (61, 20, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (62, 39, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (63, 40, 9, 0, GETDATE(), NULL);
INSERT INTO Production.ProductDetail VALUES (65, 40, 9, 0, GETDATE(), NULL);

/* ___________________________________________________________ */

INSERT INTO Transactions.BuyHeader VALUES (NULL, 1, 'Credit Card', 0, 5938.3, 6000, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 2, 'Credit Card', 0, 10550.8, 10560, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 11, 'Credit Card', 0, 480, 490, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 12, 'Credit Card', 0, 1560, 1570, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 23, 'Credit Card', 0, 1230, 1235, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 24, 'Credit Card', 0, 18720, 18750, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 17, 'Credit Card', 0, 19500, 19510, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 18, 'Credit Card', 0, 244600, 24650, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 19, 'Credit Card', 0, 1121, 1130, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 20, 'Credit Card', 0, 8480, 8500, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 39, 'Credit Card', 0, 3780, 3790, GETDATE(), GETDATE(),NULL);

INSERT INTO Transactions.BuyHeader VALUES (NULL, 40, 'Credit Card', 0, 1048, 1055, GETDATE(), GETDATE(),NULL);


/* ___________________________________________________________ */

INSERT INTO Transactions.BuyDetail VALUES (2, 1, 200, 0, 9, 10,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 4, 600, 0, 1, 2,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 5, 43, 0,0.1, 0.2,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 6, 678, 0, 0.5, 1,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 9, 39, 0, 0.2, 0.3,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 10, 22, 0, 0.6, 1,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 12, 79, 0, 0.3, 0.5,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 13, 150, 0, 1, 2,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 43, 42, 0, 1, 1.5,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 44, 120, 0, 10, 12,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (2, 45, 103, 0, 3.5, 5,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (3, 2, 2000, 0, 1, 1.5,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (3, 3, 250, 0, 2, 3,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (3, 7, 52, 0, 1, 2,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (3, 8, 41, 0, 1, 1.5,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (3, 11, 55, 0, 0.35, 0.5,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (3, 14, 920, 0, 0.5, 1,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (3, 15, 152, 0, 0.3, 0.4,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (3, 35, 23, 0, 0.5, 1,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (3, 42, 310, 0, 10, 15,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (3, 46, 106, 0, 6, 9,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (4, 49, 160, 0, 1.5, 3,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (5, 50, 156, 0, 6.5, 10,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (6, 55, 410, 0, 1.5, 3,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (7, 54, 1560, 0, 11, 12,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (8, 56, 130, 0, 100, 150,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (9, 57, 410, 0, 48, 60,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (10, 58, 638, 0, 1, 1.5,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (10, 59, 82, 0, 1, 2,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (11, 60, 720, 0, 2, 4,GETDATE());
INSERT INTO Transactions.BuyDetail VALUES (11, 61, 560, 0, 8.5, 10,GETDATE());

INSERT INTO Transactions.BuyDetail VALUES (12, 62, 630, 0, 3, 6,GETDATE());


/* ___________________________________________________________ */

INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 10, 10, GETDATE(), GETDATE(),NULL);
INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 1.5, 1.5, GETDATE(), GETDATE(),NULL);
INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 3, 3, GETDATE(), GETDATE(),NULL);
INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 2, 2, GETDATE(), GETDATE(),NULL);
INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 0.2, 0.2, GETDATE(), GETDATE(),NULL);
INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 1, 1, GETDATE(), GETDATE(),NULL);
INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 150, 150, GETDATE(), GETDATE(),NULL);
INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 60, 60, GETDATE(), GETDATE(),NULL);
INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 9, 9, GETDATE(), GETDATE(),NULL);
INSERT INTO Transactions.SaleHeader VALUES ( NULL, NULL, 'Accepted', 'Cash', 0, 3.5, 3.5, GETDATE(), GETDATE(),NULL);

/* ___________________________________________________________ */

INSERT INTO Transactions.SaleDetail VALUES (1, 1, 1, 10, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (2, 2, 1, 1.5, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (3, 3, 1, 3, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (4, 4, 1, 2, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (5, 5, 1, 0.2, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (6, 6, 1, 1, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (7, 56, 1, 150, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (8, 57, 1, 60, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (9, 46, 1, 9, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (10, 58, 1, 1.5, 'Accepted', GETDATE());

INSERT INTO Transactions.SaleDetail VALUES (10, 59, 1, 2, 'Accepted', GETDATE());

/* ___________________________________________________________ */

