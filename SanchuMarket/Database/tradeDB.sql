<<<<<<< HEAD
create table trade
(
  p_idx int,
  seller_idx int,
  buyer_idx int
)

alter table trade
   add constraint pk_trade_p_idx primary key(p_idx);
   
alter table trade
   add constraint fk_trade_seller_idx foreign key(seller_idx)
   references user_market(u_idx);
   
alter table trade
   add constraint fk_trade_buyer_idx foreign key(buyer_idx)
   references user_market(u_idx);

   
   

=======
/*
--�Ǽ� ������ ���̺� �����
drop table trade cascade constraints

/* 
�ŷ���Ȳ ���̺��ε� ���� ��ȹ�ߴ��� int������, 
���ü��� �������� ȸ�����̵�� ����
*/  

create table trade
(
	p_idx	int,	--��ǰ����
	seller	varchar2(100),	--�Ǹ���
	buyer	varchar2(100)	--������
)

---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table trade
	add constraint pk_trade_p_idx primary key(p_idx);

------------------------------------------------------




insert into trade values(1,'hong123','haha');






*/
>>>>>>> 810e9086e2d00a49d9f25731658d776e2df5bb4f
