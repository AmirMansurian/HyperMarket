
/* trigger for update inventory after sale */

create trigger Transactions.InventorySaleUpdate
on Transactions.SaleDetail
after insert 
as
begin

	update Production.Inventory
	set Inventory = Inventory - (select i.ProductQty from inserted as i	where ProductId = i.ProductId), ModifiedDate = GETDATE()
	where ProductId in (select i.ProductId	from inserted as i)

end

/*___________________________________________________________________________________________________________________ */


/* trigger for update inventory and cost of each product after buy */

create trigger Transactions.InventoryBuyUpdate
on Transactions.BuyDetail
after insert 
as
begin

	update Production.Inventory
	set Inventory = Inventory + (select i.ProductQty from inserted as i	where ProductId = i.ProductId), ModifiedDate = GETDATE()
	where ProductId in (select i.ProductId	from inserted as i)

	Update Production.Product
	set ProductFee = (select i.UnitPrice from inserted as i where ProductId = i.ProductId)
	where ProductId in (select i.ProductId	from inserted as i)

	
	update Production.ProductDetail
	set BuyFee = (select i.BuyPrice from inserted as i where ProductId = i.ProductId), 
		Discount = (select i.Discount from inserted as i where ProductId = i.ProductId)
	where ProductId in (select i.ProductId	from inserted as i)

	insert into Production.CostChanges
	select I.ProductId, I.UnitPrice, GETDATE(), NULL
	from inserted as I inner join Production.CostChanges as C on (I.ProductId = C.ProductId)
	where I.UnitPrice <> C.ProductFee

end


/*___________________________________________________________________________________________________________________ */

/* insert records for new products in inventory and cost change table */

create trigger Production.CreateProduct
on Production.product
after insert
as
begin

	insert	into Production.Inventory
	select I.ProductId, 0, GETDATE(), NULL
	from inserted as I

	insert into Production.CostChanges
	select I.ProductId, I.ProductFee, GETDATE(), NULL
	from inserted as I

end


/*___________________________________________________________________________________________________________________ */
