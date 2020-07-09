use HyperMarket
go

/* view for showing amount of buy for each customer */


CREATE VIEW Person.BestCustomer as 

with temp (ID, TotalBuy) as (
			select C.CustomerId ,sum(SH.TotalCost) as 'Total buy'
			from Transactions.SaleHeader as SH left join Person.Customer as C on (SH.CustomerId = C.CustomerId)
			group by C.CustomerId
									)

select ISNULL(CAST(C.CustomerId as varchar), 'Other') as [CUstomer ID], ISNULL(C.FirstName, 'Other') as [First Name], ISNULL(C.LastName, 'Other') as [Last Name], T.TotalBuy
from Person.Customer as C right join temp as T on (C.CustomerId = T.ID)

/* _____________________________________________________________________________________________________________ */




/* amount of sale for each Class, SubClass and Total */


CREATE VIEW Transactions.SubSales as 

with CatSub (Cat, Sub) as (
							select T.TypeName, S.TypeName
							from Production.ProductionType as T inner join Production.ProductionSubClass as S on (T.ProductiontypeId = S.ClassId))
							
select

case GROUPING(T.TypeName)
when 0 then T.TypeName
else case GROUPING(S.TypeName)
			when 0 then (select C.Cat from CatSub as C where C.Sub = S.TypeName)
			else	'All Categories'
			end
end as Category,

case GROUPING(S.TypeName)
when 0 then S.TypeName
else 'All SubClasses'
end as [Sub Class],

Sum(D.UnitPrice) * sum(D.ProductQty) as SaleTotal

from Production.ProductionType as T inner join Production.ProductionSubClass as S on (S.ClassId = T.ProductiontypeId)
									inner join Production.Product as P on (P.SubClassId = S.ProductionSubClassId)
									inner join Transactions.SaleDetail as D on (D.ProductId = P.ProductId)

group by GROUPING sets (T.TypeName, S.TypeName, ())

/* _____________________________________________________________________________________________________________ */






/* sum of amount of money sold by salespersons for each type of product */

CREATE VIEW Transactions.CashiersSubSale
as
select CashierId as 'Cashier ID', [Foodstaff], [Sanitary], [Stationery], [Cosmetic], [Home Appliances], [Clothing]
from 
(
	select H.CashierId, T.TypeName, (S.UnitPrice * S.ProductQty) as 'total'
	from Transactions.SaleDetail as S inner join Transactions.SaleHeader as H on (H.SaleId = S.SaleId)
									  inner join Production.Product as P on (S.ProductId = P.ProductId)
									  inner join Production.ProductionSubClass as SB on (P.SubClassId = SB.ProductionSubClassId)
									  inner join Production.ProductionType as T on (SB.ClassId = T.ProductiontypeId)
)as a

pivot 
(
	sum (total)
	for TypeName in ([Foodstaff], [Sanitary], [Stationery], [Cosmetic], [Home Appliances], [Clothing])
)as PVT

/* _____________________________________________________________________________________________________________ */







/* classify sales by year, month and day */

CREATE VIEW Transactions.SaleHistory as

select 

case GROUPING (year(S.ModifiedDate))
when 0 then cast(year(S.ModifiedDate) as varchar)
else 'All'
end as [Year],

case GROUPING (month(S.ModifiedDate))
when 0 then cast(month(S.ModifiedDate) as varchar)
else 'All' 
end as [Month],

case GROUPING (day(S.ModifiedDate))
when 0 then cast(day(S.ModifiedDate) as varchar)
else 'All' 
end as [Day],

sum (S.TotalCost) as [Sale Total]
from Transactions.SaleHeader as S
GROUP BY ROLLUP (year(S.ModifiedDate), Month(S.ModifiedDate), DAY(S.ModifiedDate))


select *
from Transactions.SaleHistory