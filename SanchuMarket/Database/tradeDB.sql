
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



-----------------7/5 �ŷ��Ϸ���ȸ�� ��¥column�߰�--------------------
alter table trade add t_date date;



insert into trade values(1,'hong123','haha');






*/

