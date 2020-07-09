
CREATE SCHEMA Production;
CREATE SCHEMA Existence;
CREATE SCHEMA Person;
CREATE SCHEMA Transactions;

CREATE TABLE Existence.Province
(
	ProvinceId	int PRIMARY KEY IDENTITY(1,1),
	ProvinceName	varchar(30) NOT NULL
);


CREATE TABLE Existence.City
(
	CItyId	int PRIMARY KEY IDENTITY(1,1),
	CityName	varchar(30) NOT NULL,
	ProvinceId	int,
	FOREIGN KEY (ProvinceId) REFERENCES Existence.Province(ProvinceId)
);


CREATE TABLE Production.ProductionType
(
	ProductiontypeId	int PRIMARY KEY IDENTITY(1,1),
	TypeName	varchar(20)	NOT NULL,
	[Description]	varchar(50)
);

CREATE TABLE Production.ProductionSubClass
(
	ProductionSubClassId	int PRIMARY KEY IDENTITY(1,1),
	ClassId	int,
	TypeName	varchar(20)	NOT NULL,
	[Description]	varchar(50),
	FOREIGN KEY (ClassId) REFERENCES Production.productionType(productionTypeId)
);



CREATE TABLE Existence.Company
(
	CompanyId	int PRIMARY KEY IDENTITY(1,1),
	CompanyName	varchar(30)	NOT NULL,
	CityId	int,
	ProductionType	int,
	CallNumber	varchar(11),
	[Description]	varchar(50),
	FOREIGN KEY (CityId) REFERENCES Existence.City(CityId),
	FOREIGN KEY (ProductionType) REFERENCES Production.ProductionType(ProductionTypeId)
);


CREATE TABLE Production.Product
(
	ProductId	int	PRIMARY KEY IDENTITY(1,1), 
	ProductName	varchar(40) NOT NULL,	
	Barcode		varchar(13)	NOT NULL UNIQUE ,
	Brand		varchar(30),
	ClassId		int,
	SubClassId	int,
	MeasureUnit	varchar(6) CHECK (MeasureUnit in ('Kilo', 'Number')),
	ProductFee	numeric(12, 2),
	FOREIGN KEY (ClassId) REFERENCES Production.ProductionType(ProductionTypeId),
	FOREIGN KEY (SubClassId) REFERENCES Production.ProductionSubClass(ProductionSubClassId)
);

CREATE TABLE Production.Inventory
(
	ProductId	int	PRIMARY KEY,
	Inventory	int	NOT NULL, 
	ModifiedDate	DateTime	DEFAULT GETDATE(),
	[Description]	varchar(50),
	FOREIGN KEY (ProductId) REFERENCES Production.Product(ProductId)
);


CREATE TABLE Production.CostChanges
(
	CostChangeId	BIGINT	PRIMARY KEY IDENTITY(1,1),
	ProductId	int,
	ProductFee	numeric(12,2),
	ModifiedDate	DateTime	DEFAULT GETDATE(),
	[Description]	varchar(50),
	FOREIGN KEY (ProductId) REFERENCES Production.Product(ProductId)
);


CREATE TABLE Person.Customer
(
	CustomerId	int	PRIMARY KEY IDENTITY(1,1),
	[FirstName]	varchar(30) NOT NULL,
	[LastName]	Varchar(30)	NOT NULL,
	Gender	varchar(6)	CHECK (Gender in ('Male', 'Female')),
	BirthDay	Date,
	PhoneNumber	varchar(11),
	[Address]	varchar(50),
	BankCardNumber	varchar(16),
	Email	varchar(30),
	Debt	numeric(12, 2) DEFAULT 0.00,
	ModifiedDate	DateTime	DEFAULT GETDATE(),
	[Descriptoin]	varchar(50)
);


CREATE TABLE person.StaffType
(
	StaffTypeId	int PRIMARY KEY IDENTITY(1,1),
	StaffTypeName	varchar(20) NOT NULL,
	[Description]	varchar(50)
);


CREATE TABLE person.SupplierType
(
	SupplierTypeId	int PRIMARY KEY IDENTITY(1,1),
	SupplierTypeName	varchar(20) NOT NULL,
	[Description]	varchar(50)
);


CREATE TABLE Person.Staff
(
	StaffId	int	PRIMARY KEY IDENTITY(1,1),
	[FirstName]	varchar(30) NOT NULL,
	[LastName]	Varchar(30)	NOT NULL,
	Gender	varchar(6)	CHECK (Gender in ('Male', 'Female')),
	BithDay	date,
	PhoneNumber	varchar(11),
	[Address]	varchar(50),
	Email	varchar(30),
	BankCardNumber	varchar(16),
	Salary	numeric(12, 2)	NOT NULL,
	Score	int	DEFAULT 0,
	TypeId	int,
	ModifiedDate	DateTime	DEFAULT GETDATE(),
	[Descriptoin]	varchar(50)
	FOREIGN KEY (TypeId) REFERENCES Person.StaffType(StaffTypeId)
);

CREATE TABLE Person.Relation
(
	InviterId	int,
	InvitedId	int,
	PRIMARY KEY (InviterId, InvitedId),
	FOREIGN KEY (InviterId) REFERENCES Person.Customer(CustomerId),
	FOREIGN KEY (InvitedId) REFERENCES Person.Customer(CustomerId)
);

CREATE TABLE Person.Supplier
(
	SupplierId	int	PRIMARY KEY IDENTITY(1,1),
	[FirstName]	varchar(30) NOT NULL,
	[LastName]	Varchar(30)	NOT NULL,
	Gender	varchar(6)	CHECK (Gender in ('Male', 'Female')),
	PhoneNumber	varchar(11),
	Email	varchar(30),
	Score	int	DEFAULT 0,
	TypeId	int,
	CompanyId int,
	ModifiedDate	DateTime	DEFAULT GETDATE(),
	[Descriptoin]	varchar(50),
	FOREIGN KEY (CompanyId) REFERENCES Existence.Company(CompanyId),
	FOREIGN KEY (TypeId) REFERENCES Person.SupplierType(SupplierTypeId)
);


CREATE TABLE Production.ProductDetail
(
	ProductId	int	PRIMARY KEY,
	SupplierId	int, 
	BuyFee	numeric(12,2) NOT NULL,
	Discount numeric(12, 2) DEFAULT 0.00,
	ModifiedDate	DateTime DEFAULT GETDATE(),
	[Description]	varchar(50),
	FOREIGN KEY (ProductId) REFERENCES Production.Product(ProductId)
);


CREATE TABLE Transactions.SaleHeader
(
	SaleId	BIGINT	PRIMARY KEY IDENTITY(1,1),
	CashierId	int,
	CustomerId int,
	SaleStatus	varchar(10)	CHECK (SaleStatus in ('Accepted','Referred')),
	PayType	varchar(12)	CHECK (PayType in ('Cash', 'Credit Card', 'Debt')),
	Discount	numeric(12,2)	DEFAULT 0.00,
	TotalCost	numeric(12,2) NOT NULL,
	FinalCost	numeric(12,2) NOT NULL,
	[Date]	DateTime	DEFAULT GETDATE(),
	ModifiedDate	DateTime DEFAULT GETDATE(),
	[Description]	varchar(50),
	FOREIGN KEY (CashierId) REFERENCES Person.Staff(StaffId),
	FOREIGN KEY (CustomerId) REFERENCES Person.Customer(CustomerId)
);


CREATE TABLE Transactions.SaleDetail
(
	SaleDetailId	BIGINT	PRIMARY KEY	IDENTITY(1,1),
	SaleId	BIGINT NOT NULL,
	ProductId	int	NOT NULL,
	ProductQty	int DEFAULT 1,
	UnitPrice	numeric(12, 2) NOT NULL,
	SaleStatus	varchar(10)	CHECK (SaleStatus in ('Accepted','Referred')),
	ModifiedDate	DateTime DEFAULT GETDATE(),
	FOREIGN KEY (SaleId) REFERENCES Transactions.SaleHeader(SaleId),
	FOREIGN KEY (ProductId) REFERENCES Production.Product(ProductId)
);




CREATE TABLE Transactions.BuyHeader
(
	BuyId	BIGINT	PRIMARY KEY	IDENTITY(1,1),
	TransfereeId	int,
	SupplierId	int,
	PayType	varchar(12)	CHECK (PayType in ('Cash', 'Credit Card', 'Cheque')),
	Discount	numeric(12,2)	DEFAULT 0.00,
	TotalCost	numeric(12,2) NOT NULL,
	FinalCost	numeric(12,2) NOT NULL,
	[Date]	DateTime	DEFAULT GETDATE(),
	ModifiedDate	DateTime DEFAULT GETDATE(),
	[Description]	varchar(50),
	FOREIGN KEY (TransfereeId) REFERENCES Person.Staff(StaffId),
	FOREIGN KEY (SupplierId) REFERENCES Person.Supplier(SupplierId)
);

CREATE TABLE Transactions.BuyDetail
(
	BuyDetailId	BIGINT	PRIMARY KEY	IDENTITY(1,1),
	BuyId	BIGINT NOT NULL,
	ProductId	int	NOT NULL,
	ProductQty	int DEFAULT 1,
	Discount	numeric(12,2)	DEFAULT 0,
	BuyPrice	numeric(12, 2) NOT NULL,
	UnitPrice	numeric(12, 2) NOT NULL,
	ModifiedDate	DateTime DEFAULT GETDATE(),
	FOREIGN KEY (BuyId) REFERENCES Transactions.BuyHeader(BuyId),
	FOREIGN KEY (ProductId) REFERENCES Production.Product(ProductId)
);

