
/*
--�Ǽ� ������ ���̺� �����
drop table image cascade constraints

--�̹��� ���̺� ������ ��ü���� (���� ������ ���� �ȵ�!!)
delete from image

create sequence image_idx
--������ ����
drop sequence image_idx


create table image
(
	i_idx		int,
	p_idx		int, 			--��ǰ��ȣ
	imagedata	varchar2(4000)	--����
);

---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table image
	add constraint pk_image_i_idx primary key(i_idx);





select * from image order by i_idx
select p_idx, sumimage from image 
select * from product

select * from (select * from image where p_idx=3  order by i_idx) where ROWNUM  = 1


*/

