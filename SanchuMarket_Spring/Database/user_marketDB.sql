/*
--�Ǽ� ������ ���̺� �����
drop table user_market cascade constraints

--ȸ�� ���̺� ����, user�� ������ ���Ұ�. user_market���� ��ü

create table user_market
(
	u_idx		int,					 -- ȸ����ȣ(pk)
	u_id		varchar2(100)  not null, -- ���̵�
	u_pwd		varchar2(100)  not null, -- ��й�ȣ
	u_name		varchar2(100)  not null, -- �̸�
	u_nickname	varchar2(100)  not null, -- �г���
	u_birth		varchar2(100)  not null, -- �������
	u_addr		varchar2(2000) not null, -- ȸ���ּ�
	u_regdate	date		   not null, -- ��������
	u_like		int,					 -- ����
	u_profile	varchar2(2000),			 -- �ڱ�Ұ�
	u_photo		varchar2(2000),			 -- ȸ������
	u_tel		varchar2(100)  not null, -- ��ȭ��ȣ
	u_mail		varchar2(100)  not null, -- �̸���
	u_grade		varchar2(100)  default '�Ϲ�ȸ��', -- ȸ�����
	u_ip		varchar2(100),			 -- ip
	postcode 	varchar2(50),			 -- �����ȣ
	u_status 	varchar2(100),			 -- ȸ������
	u_likecount int					     -- ȸ����õī��Ʈ
)	

---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table user_market
	add constraint pk_user_maket_u_idx primary key(u_idx);

--------����ũ ����--------
--���̵�
alter table user_market
	add constraint uq_user_market_u_id unique(u_id);

--�г���
alter table user_market
	add constraint uq_user_market_u_nickname unique(u_nickname);
	
--�̸���
alter table user_market
	add constraint uq_user_market_u_mail unique(u_mail);	


	
-----check���� ����+�����(7/27)--------
alter table user_market
    drop constraint	ck_user_market_u_grade
    
alter table user_market
     add constraint ck_user_market_u_grade
     check( u_grade in('�Ϲ�ȸ��','������'))
    
	
--------check ����2 (7/6 ����)-------
alter table user_market
    add constraint ck_user_market_u_status
    check( u_status in('Ȱ��', 'Ż��','����'))	
    
---check���� ���Ǹ� ����---	
ALTER TABLE user_market 
   RENAME CONSTRAINT ck_user_market_u_garde TO
                     ck_user_market_u_grade;
	
	
-----------�ݵ�� �ҰͿ����ȣ column�߰�-------------

alter table user_market add postcode varchar2(50); 
alter table user_market add	u_ip varchar2(100)

-----------7/4 �� �� + Ȱ������ column�߰�----------
alter table user_market add u_status varchar2(100); 
alter table user_market add	u_listcount int;

------------7/6 column�� ����----------------------
alter table user_market rename column u_listcount to u_likecount

---------------------- ���õ����� ----------------------

  /* ������ �����ʰ�, 1������ �ϴ� ������ ��� */
insert into user_market 
values( (select nvl(max(u_idx)+1,1) from user_market),		  
		'hong123',    	 	  --���̵�
		'1234',	    		  --���
		'ȫ�浿',	    	  --�̸�
		'������½',   		  --�г���
		'1994-06-17', 		  --�������
		'����� ���Ǳ� �Ÿ���', --�ּ�
		sysdate,			  --��������
		5,					  --����
		'�氡�氡~',		  --�ڱ�Ұ�
		'no_file',			  --����
		'010-1234-5678',	  --��ȭ��ȣ
		'hongkill@gmail.com', --����
		'�Ϲ�ȸ��',		 	  --ȸ�����
		'111.111.111.111',    --ip
		'25231',          	  --postcode
		'Ȱ��',   	  		  --ȸ������
		0   	  			  --ȸ����õī��Ʈ
		); 


insert into user_market 
values( (select nvl(max(u_idx)+1,1) from user_market),		  
		'admin',    	 	  --���̵�
		'1234',	    		  --���
		'�������',	    	  --�̸�
		'������',   		  --�г���
		'1994-06-17', 		  --�������
		'����� ���Ǳ� �Ÿ���', --�ּ�
		sysdate,			  --��������
		5,					  --����
		'������ ���̵�',	  --�ڱ�Ұ�
		'no_file',				  --����
		'010-1234-5678',	  --��ȭ��ȣ
		'admin123@gmail.com', --����
		'������',			  --ȸ�����
		'111-111-111',        --ip
		'23231',          	  --postcode
		'Ȱ��', 			  --ȸ������
		0 				  	  --ȸ����õī��Ʈ
		);

insert into user_market 
values( (select nvl(max(u_idx)+1,1) from user_market),		  
		'haha',   	 	 	  --���̵�
		'1234',	    		  --���
		'������',	    	  --�̸�
		'����',		   		  --�г���
		'1993-06-18', 		  --�������
		'����� ������',	  --�ּ�
		sysdate,			  --��������
		0,					  --����
		'�ȳ糭���Ͼ�',		  --�ڱ�Ұ�
		'no_file',			  --����
		'010-4567-8901',	  --��ȭ��ȣ
		'haha12@naver.com',   --����
		'�Ϲ�ȸ��'	,		  --ȸ�����
		'111-111-111' , 	  --ip
		'25251',         	  --postcode
		'Ȱ��',	 			  --ȸ������
		0	 				  --ȸ����õī��Ʈ
		
		);


---��ȸ��
select * from user_market;

update user_market set u_pwd='1234' where u_id='dkwlsdl8'

select to_char(u_regdate,'mm') as month, count(*) as tot
	from user_market
	where to_char(u_regdate,'yy')=to_char(sysdate,'yy') 
	group by to_char(u_regdate,'mm') order by to_char(u_regdate,'mm') asc


select u_idx, u_name, u_id, u_tel, u_addr, u_status from user_market where u_grade='�Ϲ�ȸ��' order by u_idx
  
 select * from user_market where u_grade='�Ϲ�ȸ��' order by u_idx

  select count(*) from product where to_char(p_date,'dd') = to_char(sysdate, 'dd')

select u_id from user_market where u_name='������' and u_tel='010-5852-1068'

update user_market set u_grade='������' where u_idx=2;

select no, u_name, u_id, u_tel, u_addr, nvl2(u_status,u_status,'�Ϲ�ȸ��')u_status from
		(
		select p.*, rank() over(order by u_idx)no from(select * from user_market)p
		)			
		where no between 1 and 5 and u_grade='�Ϲ�ȸ��'




	select no, u_name, u_id, u_tel, u_addr, nvl2(u_status,u_status,'Ȱ��')u_status, u_grade
		from
		(
		select 
			p.*, 
			rank() over(order by u_idx) no 
			from(select * from user_market where u_grade='�Ϲ�ȸ��')p
		)			
		where no between 1 and 5


select * from user_market

update user_market set 

*/

