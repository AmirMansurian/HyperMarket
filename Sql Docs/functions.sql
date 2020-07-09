use HyperMarket
go

/* function for finding history of buy for a customer in the specific time */

CREATE FUNCTION Person.BuyHistory(@PersonID int, @S_Date date = null, @E_Date date = GETDATE)
RETURNS numeric(12,2) 
as
begin

	declare @Start	date
	set @Start = ISNULL(@S_Date, (select top 1 H.[Date]	from Transactions.SaleHeader as H	order by H.Date))

	return (select sum(H.TotalCost)
			from Transactions.SaleHeader as H
			where H.CustomerId = @PersonID and H.[Date] >= @Start and H.[Date] <= @E_Date
			group by H.CustomerId
									)
end

 /* __________________________________________________________________________________________________________________________ */


/* function for amount of sale in an interval of time */

CREATE FUNCTION Transactions.SaleByDate (@Start date = NULL, @End date = GETDATE)
RETURNS numeric(12, 2)
as
begin

	set @Start = ISNULL(@Start, (select top 1 H.[Date]	from Transactions.SaleHeader as H	order by H.Date))

		return (select sum(H.TotalCost)
			from Transactions.SaleHeader as H
			where H.[Date] >= @Start and H.[Date] <= @End)


end


 /* __________________________________________________________________________________________________________________________ */



/* function that returns inventory of product by id */

CREATE FUNCTION Production.InventoryByID(@ID int)
RETURNS INT
as
begin
	return (select I.Inventory	from Production.Inventory as I	where I.ProductId = @ID)
end		
						
						
 /* __________________________________________________________________________________________________________________________ */


 /* fucntion that returns CostChange for a product in Interav of time */

CREATE FUNCTION Production.CostChangeByID(@ID int, @Start date = null, @End date = GETDATE)
RETURNS @res table (
					PID int,
					fee	numeric(12, 2), 
					mod_date	date

								)
as
begin

	set @Start = ISNULL(@Start, (select top 1 H.[ModifiedDate]	from Production.CostChanges as H	where H.ProductId = @ID	order by H.ModifiedDate))

	insert into @res select H.ProductId, H.ProductFee, H.ModifiedDate
			from Production.CostChanges as H
			where H.ProductId = @ID and H.[ModifiedDate] >= @Start and H.[ModifiedDate] <= @End	
	RETURN
end



 /* __________________________________________________________________________________________________________________________ */


 
 /* function that return sum of sale for sprcific type of product */

 CREATE FUNCTION Person.StaffByID(@ID int)
 RETURNS @info table
				(
					[sid] int,
					fname	varchar(30),
					lname	varchar(30),
					gender	varchar(6),
					birthday	date,
					phonenumber	varchar(13),
					[address]	varchar(50),
					email	varchar(50),
					carnumber	varchar(16),
					salary	numeric(12,2),
					score	int,
					typeid	int,
					moddate	date,
					descr	varchar(50)

				)
as
begin

	insert into @info select *
	from Person.Staff as S
	where S.StaffId = @ID
 
	return
end




