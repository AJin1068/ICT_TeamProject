
/*
--�Ǽ� ������ ���̺� �����
drop table image cascade constraints

--�̹��� ���̺� ������ ��ü���� (���� ������ ���� �ȵ�!!)
delete from image


create table image
(
	i_idx		int,
	p_idx		int, 			--��ǰ��ȣ
	sumimage	varchar2(4000)	--����
);

---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table image
	add constraint pk_image_i_idx primary key(i_idx);


select * from image


insert into image
values(
(select max(p_idx) from product),
cat123.gif,
wow123.jpg,
null,
null,
null,
null
)

select * from image
select p_idx, sumimage from image 
select * from product

*/

