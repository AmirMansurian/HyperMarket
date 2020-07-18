CREATE PROCEDURE Person.StaffBirthDayReminder 
as
begin 
	update Person.Staff
	set Descriptoin = 'Happy Birth Day to you Dear' + FirstName + 'Hyper Market'
	where MONTH(BithDay) = MONTH(GETDATE()) and DAY(BithDay) = DAY(GETDATE())
end;


/*_____________________________________________________________________________________________________________ */


CREATE PROCEDURE Person.CustomerRelationRank 
as
begin

	with RelationChain (Inviter, Invited) as (

		select * from Person.Relation

		union all

		select C.Inviter, R.InvitedId 
		from RelationChain as C, Person.Relation as R
		where C.Invited = R.InviterId
	)

	UPDATE Person.Customer
	set RelationChain = 
	case 
		when (select count(*) from RelationChain as R where R.Inviter = CustomerId) < 50 then 'Bronze Customer'
		when (select count(*) from RelationChain as R where R.Inviter = CustomerId) >= 50 and (select count(*) from RelationChain as R where R.Inviter = CustomerId) <100 then 'Silver Customer'
		else 'Golden Customer'
	end

end


/* ___________________________________________________________________________________________________ */


CREATE PROCEDURE Person.CustomerDebt
as
begin

	update Person.Customer
	set Descriptoin = 'Your Debt is more than 100 $ Please check your Bills'
	where Debt > 100

end

/* ___________________________________________________________________________________________________ */


CREATE PROCEDURE Production.ExpiredProductWarning
as
begin

	UPDATE Production.ProductDetail
	set Description = 'Product is going to be expired in 10 days'
	where YEAR(ExpirationDate) =  YEAR(GETDATE()) and MONTH(ExpirationDate) =  MONTH(GETDATE()) and DAY(ExpirationDate) -  YEAR(GETDATE()) < 10

end
